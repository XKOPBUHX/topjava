package com.java_2_base.webapp.model;

import java.time.LocalDate;
import java.util.*;

public class Resume implements Comparable<Resume> {
    private final String uuid;
    private final String fullName;
    private Map<ContactType, String> contacts;
    private Map<SectionType, AbstractSection> sections;

    public Resume(String fullName) {
        this(UUID.randomUUID().toString(), fullName);
    }

    public Resume(String uuid, String fullName) {
        Objects.requireNonNull(uuid, "uuid must not be null");
        Objects.requireNonNull(fullName, "fullName must not be null");
        this.uuid = uuid;
        this.fullName = fullName;
        this.contacts = new EnumMap<>(ContactType.class);
        this.sections = new EnumMap<>(SectionType.class);
    }

    public String getUuid() {
        return uuid;
    }

    public String getFullName() {
        return fullName;
    }

    @Override
    public String toString() {
        return fullName + "(" + uuid + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Resume resume = (Resume) o;

        if (!uuid.equals(resume.uuid)) return false;
        return fullName.equals(resume.fullName);
    }

    @Override
    public int hashCode() {
        int result = uuid.hashCode();
        result = 31 * result + fullName.hashCode();
        return result;
    }

    @Override
    public int compareTo(Resume o) {
        return Comparator.comparing(Resume::getFullName).thenComparing(Resume::getUuid).compare(this, o);
    }

    public void addContact(ContactType type, String contact) {
        contacts.put(type, contact);
    }

    public void addSectionString(SectionType type, String text) {
        if (type == SectionType.PERSONAL || type == SectionType.OBJECTIVE) {
            sections.put(type, new SimpleTextSection(text));
        }
    }

    public void addBulletedListSection(SectionType type, String text) {
        if (type == SectionType.ACHIEVEMENT || type == SectionType.QUALIFICATIONS) {
            AbstractSection value = sections.get(type);
            if (value == null) {
                value = new BulletedListSection();
                sections.put(type, value);
            }
            ((List<String>) value.section).add(text);
        }
    }

    public void addOrganizationSection(SectionType type, LocalDate startDate, LocalDate endDate, String title, String description) {
        if (type == SectionType.EXPERIENCE || type == SectionType.EDUCATION) {
            AbstractSection value = sections.get(type);
            if (value == null) {
                value = new OrganizationSection();
                sections.put(type, value);
            }
            Experience experience = new Experience(startDate, endDate, title, description);
            ((List<Experience>) value.section).add(experience);
        }
    }

    public void show() {
        System.out.println(fullName);
        for (Map.Entry<ContactType, String> entry : contacts.entrySet()) {
            System.out.println(entry.getKey().getTitle() + " : " + entry.getValue());
        }
        for (Map.Entry<SectionType, AbstractSection> entry : sections.entrySet()) {
            System.out.println("\n" + entry.getKey().getTitle() + ":");
            System.out.println(entry.getValue().toString());
        }
    }
}
