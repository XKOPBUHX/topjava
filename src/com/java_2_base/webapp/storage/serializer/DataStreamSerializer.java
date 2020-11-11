package com.java_2_base.webapp.storage.serializer;

import com.java_2_base.webapp.model.*;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
            writeString(outputStream, resume.getUuid());
            writeString(outputStream, resume.getFullName());

            Map<ContactType, String> contacts = resume.getContacts();
            writeInteger(outputStream, contacts.size());
            for (Map.Entry<ContactType, String> entry : contacts.entrySet()) {
                writeString(outputStream, entry.getKey().name());
                writeString(outputStream, entry.getValue());
            }

            Map<SectionType, AbstractSection> sections = resume.getSections();
            writeInteger(outputStream, sections.size());
            for (Map.Entry<SectionType, AbstractSection> entry : sections.entrySet()) {
                SectionType sectionType = entry.getKey();
                AbstractSection section = entry.getValue();
                writeString(outputStream, sectionType.name());
                switch (sectionType) {
                    case PERSONAL:
                    case OBJECTIVE:
                        writeString(outputStream, ((SimpleTextSection) section).getText());
                        break;
                    case ACHIEVEMENT:
                    case QUALIFICATIONS:
                        List<String> listString = ((ListSection) section).getList();
                        writeInteger(outputStream, listString.size());
                        for (String string : listString) {
                            writeString(outputStream, string);
                        }
                        break;
                    case EXPERIENCE:
                    case EDUCATION:
                        List<Organization> listOrganization = ((OrganizationSection) section).getList();
                        writeInteger(outputStream, listOrganization.size());
                        for (Organization organization : listOrganization) {
                            Organization.Link homePage = organization.getHomePage();
                            writeString(outputStream, homePage.getName());
                            writeString(outputStream, homePage.getUrl());

                            List<Organization.Position> positions = organization.getPositions();
                            writeInteger(outputStream, positions.size());
                            for (Organization.Position position : positions) {
                                writeString(outputStream, position.getStartDate().toString());
                                writeString(outputStream, position.getEndDate().toString());
                                writeString(outputStream, position.getTitle());
                                writeString(outputStream, position.getDescription());
                            }
                        }
                        break;
                }
            }
        }
    }


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
}