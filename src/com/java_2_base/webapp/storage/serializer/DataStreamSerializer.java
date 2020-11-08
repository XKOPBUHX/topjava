package com.java_2_base.webapp.storage.serializer;

import com.java_2_base.webapp.model.*;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DataStreamSerializer implements StreamSerializer {

    private void readContacts(DataInputStream inputStream, Resume resume) throws IOException {
        int size = inputStream.readInt();
        for (int i = 0; i < size; i++) {
            readContact(inputStream, resume);
        }
    }

    private void readContact(DataInputStream inputStream, Resume resume) throws IOException {
        resume.setContact(ContactType.valueOf(inputStream.readUTF()), inputStream.readUTF());
    }

    private void readSections(DataInputStream inputStream, Resume resume) throws IOException {
        int size = inputStream.readInt();
        for (int i = 0; i < size; i++) {
            readSection(inputStream, resume);
        }
    }

    private void readSection(DataInputStream inputStream, Resume resume) throws IOException {
        SectionType sectionType = SectionType.valueOf(inputStream.readUTF());
        if (sectionType == SectionType.PERSONAL || sectionType == SectionType.OBJECTIVE) {
            readSimpleTextSection(inputStream, resume, sectionType);
        } else if (sectionType == SectionType.ACHIEVEMENT || sectionType == SectionType.QUALIFICATIONS) {
            readListSection(inputStream, resume, sectionType);
        } else if (sectionType == SectionType.EXPERIENCE || sectionType == SectionType.EDUCATION) {
            readOrganizationSection(inputStream, resume, sectionType);
        }
    }

    private void readSimpleTextSection(DataInputStream inputStream, Resume resume, SectionType sectionType) throws IOException {
        resume.setSection(sectionType, new SimpleTextSection(inputStream.readUTF()));
    }

    private void readListSection(DataInputStream inputStream, Resume resume, SectionType sectionType) throws IOException {
        int sizeList = inputStream.readInt();
        List<String> list = new ArrayList<>();
        for (int j = 0; j < sizeList; j++) {
            list.add(inputStream.readUTF());
        }
        ListSection section = new ListSection(list);
        resume.setSection(sectionType, section);
    }

    private void readOrganizationSection(DataInputStream inputStream, Resume resume, SectionType sectionType) throws IOException {
        int sizeList = inputStream.readInt();
        List<Organization> list = new ArrayList<>();
        for (int j = 0; j < sizeList; j++) {
            list.add(getOrganization(inputStream));
        }
        OrganizationSection section = new OrganizationSection(list);
        resume.setSection(sectionType, section);
    }

    private Organization getOrganization(DataInputStream inputStream) throws IOException {
        Organization.Link homePage = new Organization.Link(inputStream.readUTF(), inputStream.readUTF());
        int sizePosition = inputStream.readInt();
        List<Organization.Position> listPosition = new ArrayList<>();
        for (int k = 0; k < sizePosition; k++) {
            listPosition.add(getPosition(inputStream));
        }
        return new Organization(homePage, listPosition);
    }

    private Organization.Position getPosition(DataInputStream inputStream) throws IOException {
        LocalDate startDate = LocalDate.parse(inputStream.readUTF());
        LocalDate endDate = LocalDate.parse(inputStream.readUTF());
        String title = inputStream.readUTF();
        String description = inputStream.readUTF();
        return new Organization.Position(startDate, endDate, title, description);
    }

    private void writeString(DataOutputStream outputStream, String text) throws IOException {
        outputStream.writeUTF(text);
    }

    private void writeInteger(DataOutputStream outputStream, int number) throws IOException {
        outputStream.writeInt(number);
    }

    private void writeFields(DataOutputStream outputStream, Resume resume) throws IOException {
        writeString(outputStream, resume.getUuid());
        writeString(outputStream, resume.getFullName());
    }

    private void writeContacts(DataOutputStream outputStream, Resume resume) throws IOException {
        Map<ContactType, String> contacts = resume.getContacts();
        writeInteger(outputStream, contacts.size());
        for (Map.Entry<ContactType, String> entry : contacts.entrySet()) {
            writeContact(outputStream, entry);
        }
    }

    private void writeContact(DataOutputStream outputStream, Map.Entry<ContactType, String> entry) throws IOException {
        writeString(outputStream, entry.getKey().name());
        writeString(outputStream, entry.getValue());
    }

    private void writeSections(DataOutputStream outputStream, Resume resume) throws IOException {
        Map<SectionType, AbstractSection> sections = resume.getSections();
        writeInteger(outputStream, sections.size());
        for (Map.Entry<SectionType, AbstractSection> entry : sections.entrySet()) {
            writeSection(outputStream, entry.getKey(), entry.getValue());
        }
    }

    private void writeSection(DataOutputStream outputStream, SectionType sectionType, AbstractSection section) throws IOException {
        writeString(outputStream, sectionType.name());
        if (sectionType == SectionType.PERSONAL || sectionType == SectionType.OBJECTIVE) {
            writeSimpleTextSection(outputStream, section);
        } else if (sectionType == SectionType.ACHIEVEMENT || sectionType == SectionType.QUALIFICATIONS) {
            writeListSection(outputStream, section);
        } else if (sectionType == SectionType.EXPERIENCE || sectionType == SectionType.EDUCATION) {
            writeOrganizationSection(outputStream, section);
        }
    }

    private void writeSimpleTextSection(DataOutputStream outputStream, AbstractSection section) throws IOException {
        writeString(outputStream, ((SimpleTextSection) section).getText());
    }

    private void writeListSection(DataOutputStream outputStream, AbstractSection section) throws IOException {
        List<String> list = ((ListSection) section).getList();
        writeInteger(outputStream, list.size());
        for (String string : list) {
            writeString(outputStream, string);
        }
    }

    private void writeOrganizationSection(DataOutputStream outputStream, AbstractSection section) throws IOException {
        List<Organization> list = ((OrganizationSection) section).getList();
        writeInteger(outputStream, list.size());
        for (Organization organization : list) {
            writeHomePage(outputStream, organization);
            writePositions(outputStream, organization);
        }
    }

    private void writeHomePage(DataOutputStream outputStream, Organization organization) throws IOException {
        Organization.Link homePage = organization.getHomePage();
        writeString(outputStream, homePage.getName());
        writeString(outputStream, homePage.getUrl());
    }

    private void writePositions(DataOutputStream outputStream, Organization organization) throws IOException {
        List<Organization.Position> positions = organization.getPositions();
        writeInteger(outputStream, positions.size());
        for (Organization.Position position : positions) {
            writePosition(outputStream, position);
        }
    }

    private void writePosition(DataOutputStream outputStream, Organization.Position position) throws IOException {
        writeString(outputStream, position.getStartDate().toString());
        writeString(outputStream, position.getEndDate().toString());
        writeString(outputStream, position.getTitle());
        writeString(outputStream, position.getDescription());
    }

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
}
