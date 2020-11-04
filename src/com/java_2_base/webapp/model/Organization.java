package com.java_2_base.webapp.model;

import com.java_2_base.webapp.util.DateUtil;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Organization implements Serializable {
    private static final long serialVersionUID = 1L;
    private final Link homePage;
    private final List<Position> positions;

    public Organization(String name, String url, Position... position) {
        this(new Link(name, url), Arrays.asList(position));
    }

    public Organization(Link homePage, List<Position> positions) {
        Objects.requireNonNull(positions, "positions must not be null");
        Objects.requireNonNull(homePage, "home page must not be null");
        this.homePage = homePage;
        this.positions = positions;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(homePage.toString()).append(": \n");
        for (Position position : positions) {
            stringBuilder.append(position.toString()).append("\n");
        }
        return stringBuilder.toString().trim();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Organization that = (Organization) o;
        return homePage.equals(that.homePage) &&
                positions.equals(that.positions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(homePage, positions);
    }

    public static class Position implements Serializable {
        private static final long serialVersionUID = 1L;
        private final LocalDate startDate;
        private final LocalDate endDate;
        private final String title;
        private final String description;

        public Position(int startYear, Month startMoth, String title, String description) {
            this(DateUtil.of(startYear, startMoth), DateUtil.NOW, title, description);
        }

        public Position(int startYear, Month startMoth, int endYear, Month endMoth, String title) {
            this(startYear, startMoth, endYear, endMoth, title, "");
        }

        public Position(int startYear, Month startMoth, int endYear, Month endMoth, String title, String description) {
            this(DateUtil.of(startYear, startMoth), DateUtil.of(endYear, endMoth), title, description);
        }

        public Position(LocalDate startDate, LocalDate endDate, String title, String description) {
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
            Position that = (Position) o;
            return startDate.equals(that.startDate) &&
                    endDate.equals(that.endDate) &&
                    title.equals(that.title) &&
                    Objects.equals(description, that.description);
        }

        @Override
        public int hashCode() {
            return Objects.hash(startDate, endDate, title, description);
        }

        @Override
        public String toString() {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/yyyy");
            String stringBuilder = formatter.format(startDate) +
                    " - " +
                    formatter.format(endDate) +
                    ". " +
                    title +
                    ". " +
                    description;
            return stringBuilder.trim();
        }
    }

    public static class Link implements Serializable {
        private static final long serialVersionUID = 1L;
        private final String name;
        private final String url;

        public Link(String name, String url) {
            Objects.requireNonNull(name, "name must not be null");
            this.name = name;
            this.url = url;
        }

        public String getName() {
            return name;
        }

        public String getUrl() {
            return url;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Link link = (Link) o;

            if (!name.equals(link.name)) return false;
            return Objects.equals(url, link.url);
        }

        @Override
        public int hashCode() {
            int result = name.hashCode();
            result = 31 * result + (url != null ? url.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return name + ((url != null && !url.isEmpty()) ? " (" + url + ")" : "");
        }
    }
}
