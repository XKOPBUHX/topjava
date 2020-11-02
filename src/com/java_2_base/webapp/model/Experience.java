package com.java_2_base.webapp.model;

import java.time.LocalDate;
import java.util.Objects;

public class Experience {
    private final LocalDate startDate;
    private final LocalDate endDate;
    private final String title;
    private final String description;

    public Experience(LocalDate startDate, LocalDate endDate, String title, String description) {
        Objects.requireNonNull(startDate, "start date must not be null");
        Objects.requireNonNull(endDate, "end date must not be null");
        Objects.requireNonNull(title, "title must not be null");
        this.startDate = startDate;
        this.endDate = endDate;
        this.title = title;
        this.description = description;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Experience that = (Experience) o;
        return startDate.equals(that.startDate) &&
                endDate.equals(that.endDate) &&
                title.equals(that.title) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(startDate, endDate, title, description);
    }
}
