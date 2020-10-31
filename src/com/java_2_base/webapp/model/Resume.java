package com.java_2_base.webapp.model;

import java.util.*;

public class Resume implements Comparable<Resume> {
    private final String uuid;
    private final String fullName;
    private final Map<ContactType, String> contacts = new EnumMap<>(ContactType.class);
    private final Map<SectionType, AbstractSection> sections = new EnumMap<>(SectionType.class);

    public Resume(String fullName) {
        this(UUID.randomUUID().toString(), fullName);
    }

    public Resume(String uuid, String fullName) {
        Objects.requireNonNull(uuid, "uuid must not be null");
        Objects.requireNonNull(fullName, "fullName must not be null");
        this.uuid = uuid;
        this.fullName = fullName;
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


    public void setContact(ContactType type, String contact) {
        contacts.put(type, contact);
    }

    public void setSection(SectionType type, AbstractSection section) {
        sections.put(type, section);
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
