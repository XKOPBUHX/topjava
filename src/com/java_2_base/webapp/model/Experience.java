package com.java_2_base.webapp.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Experience {
    private final LocalDate startDate;
    private final LocalDate endDate;
    private final String title;
    private final String description;

    public Experience(LocalDate startDate, LocalDate endDate, String title, String description) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.title = title;
        this.description = description;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/yyyy");
        return formatter.format(startDate) + " - " + formatter.format(endDate) + ". " + title + ". " + description;
    }
}
