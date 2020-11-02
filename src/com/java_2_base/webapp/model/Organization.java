package com.java_2_base.webapp.model;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;

public class Organization {
    private final Link homePage;
    private final List<Experience> experience;

    public Organization(String name, String url, List<Experience> experience) {
        Objects.requireNonNull(experience, "experience must not be null");
        this.homePage = new Link(name, url);
        this.experience = experience;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/yyyy");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(homePage.toString()).append(": \n");
        for (Experience experienceObj : experience) {
            stringBuilder.append(formatter.format(experienceObj.getStartDate()))
                    .append(" - ")
                    .append(formatter.format(experienceObj.getEndDate()))
                    .append(". ")
                    .append(experienceObj.getTitle())
                    .append(". ")
                    .append(experienceObj.getDescription())
                    .append("\n");
        }

        return stringBuilder.toString().trim();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Organization that = (Organization) o;
        return homePage.equals(that.homePage) &&
                experience.equals(that.experience);
    }

    @Override
    public int hashCode() {
        return Objects.hash(homePage, experience);
    }
}
