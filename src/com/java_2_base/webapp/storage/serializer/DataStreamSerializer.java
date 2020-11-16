package com.java_2_base.webapp.storage.serializer;

import com.java_2_base.webapp.model.*;

import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class DataStreamSerializer implements StreamSerializer {

    @Override
    public Resume doRead(InputStream stream) throws IOException {
        try (DataInputStream inputStream = new DataInputStream(stream)) {
            Resume resume = new Resume(inputStream.readUTF(), inputStream.readUTF());
            readContacts(inputStream, resume);
            readSections(inputStream, resume);
            return resume;
        }
    }

    @Override
    public void doWrite(Resume resume, OutputStream stream) throws IOException {
        try (DataOutputStream outputStream = new DataOutputStream(stream)) {
            writeFields(outputStream, resume);
            writeContacts(outputStream, resume);
            writeSections(outputStream, resume);
        }
    }


    private <T> void writeCollection(DataOutputStream outputStream, Collection<T> collection, DataWriter<T> writer) throws IOException {
        outputStream.writeInt(collection.size());
        for (T element : collection) {
            writer.writeElement(element);
        }
    }

    private void writeFields(DataOutputStream outputStream, Resume resume) throws IOException {
        outputStream.writeUTF(resume.getUuid());
        outputStream.writeUTF(resume.getFullName());
    }

    private void writeContacts(DataOutputStream outputStream, Resume resume) throws IOException {
        writeCollection(outputStream, resume.getContacts().entrySet(), entry -> {
            outputStream.writeUTF(entry.getKey().name());
            outputStream.writeUTF(entry.getValue());
        });
    }

    private void writeSections(DataOutputStream outputStream, Resume resume) throws IOException {
        writeCollection(outputStream, resume.getSections().entrySet(), entry -> writeSection(outputStream, entry.getKey(), entry.getValue()));
    }

    private void writeSection(DataOutputStream outputStream, SectionType sectionType, AbstractSection section) throws IOException {
        outputStream.writeUTF(sectionType.name());
        switch (sectionType) {
            case PERSONAL:
            case OBJECTIVE:
                writeSimpleTextSection(outputStream, (SimpleTextSection) section);
                break;
            case ACHIEVEMENT:
            case QUALIFICATIONS:
                writeListSection(outputStream, (ListSection) section);
                break;
            case EXPERIENCE:
            case EDUCATION:
                writeOrganizationSection(outputStream, (OrganizationSection) section);
                break;
        }
    }

    private void writeSimpleTextSection(DataOutputStream outputStream, SimpleTextSection section) throws IOException {
        outputStream.writeUTF(section.getText());
    }

    private void writeListSection(DataOutputStream outputStream, ListSection section) throws IOException {
        writeCollection(outputStream, section.getList(), outputStream::writeUTF);
    }

    private void writeOrganizationSection(DataOutputStream outputStream, OrganizationSection section) throws IOException {
        writeCollection(outputStream, section.getList(), organization -> {
            writeHomePage(outputStream, organization);
            writePositions(outputStream, organization);
        });
    }

    private void writeHomePage(DataOutputStream outputStream, Organization organization) throws IOException {
        Organization.Link homePage = organization.getHomePage();
        outputStream.writeUTF(homePage.getName());
        outputStream.writeUTF(homePage.getUrl());
    }

    private void writePositions(DataOutputStream outputStream, Organization organization) throws IOException {
        writeCollection(outputStream, organization.getPositions(), position -> writePosition(outputStream, position));
    }

    private void writePosition(DataOutputStream outputStream, Organization.Position position) throws IOException {
        writeDate(outputStream, position.getStartDate());
        writeDate(outputStream, position.getEndDate());
        outputStream.writeUTF(position.getTitle());
        outputStream.writeUTF(position.getDescription());
    }

    private void writeDate(DataOutputStream outputStream, LocalDate date) throws IOException {
        outputStream.writeUTF(date.toString());
    }

    private void readCollection(DataInputStream inputStream, DataReader reader) throws IOException {
        int size = inputStream.readInt();
        for (int i = 0; i < size; i++) {
            reader.readElement();
        }
    }

    private <T> List<T> readListCollection(DataInputStream inputStream, DataListReader<T> reader) throws IOException {
        int sizeList = inputStream.readInt();
        List<T> list = new ArrayList<>();
        for (int j = 0; j < sizeList; j++) {
            list.add(reader.readElement());
        }
        return list;
    }

    private void readContacts(DataInputStream inputStream, Resume resume) throws IOException {
        readCollection(inputStream, () -> readContact(inputStream, resume));
    }

    private void readContact(DataInputStream inputStream, Resume resume) throws IOException {
        resume.setContact(ContactType.valueOf(inputStream.readUTF()), inputStream.readUTF());
    }

    private void readSections(DataInputStream inputStream, Resume resume) throws IOException {
        readCollection(inputStream, () -> readSection(inputStream, resume));
    }

    private void readSection(DataInputStream inputStream, Resume resume) throws IOException {
        SectionType sectionType = SectionType.valueOf(inputStream.readUTF());
        switch (sectionType) {
            case PERSONAL:
            case OBJECTIVE:
                readSimpleTextSection(inputStream, resume, sectionType);
                break;
            case ACHIEVEMENT:
            case QUALIFICATIONS:
                readListSection(inputStream, resume, sectionType);
                break;
            case EXPERIENCE:
            case EDUCATION:
                readOrganizationSection(inputStream, resume, sectionType);
                break;
        }
    }

    private void readSimpleTextSection(DataInputStream inputStream, Resume resume, SectionType sectionType) throws IOException {
        resume.setSection(sectionType, new SimpleTextSection(inputStream.readUTF()));
    }

    private void readListSection(DataInputStream inputStream, Resume resume, SectionType sectionType) throws IOException {
        List<String> list = readListCollection(inputStream, inputStream::readUTF);
        setSection(resume, sectionType, new ListSection(list));
    }

    private void readOrganizationSection(DataInputStream inputStream, Resume resume, SectionType sectionType) throws IOException {
        List<Organization> list = readListCollection(inputStream, () -> getOrganization(inputStream));
        setSection(resume, sectionType, new OrganizationSection(list));
    }

    private void setSection(Resume resume, SectionType sectionType, AbstractSection section) {
        resume.setSection(sectionType, section);
    }

    private Organization getOrganization(DataInputStream inputStream) throws IOException {
        Organization.Link homePage = new Organization.Link(inputStream.readUTF(), inputStream.readUTF());
        List<Organization.Position> listPosition = readListCollection(inputStream, () -> getPosition(inputStream));
        return new Organization(homePage, listPosition);
    }

    private Organization.Position getPosition(DataInputStream inputStream) throws IOException {
        LocalDate startDate = readDate(inputStream);
        LocalDate endDate = readDate(inputStream);
        String title = inputStream.readUTF();
        String description = inputStream.readUTF();
        return new Organization.Position(startDate, endDate, title, description);
    }

    private LocalDate readDate(DataInputStream inputStream) throws IOException {
        return LocalDate.parse(inputStream.readUTF());
    }
}