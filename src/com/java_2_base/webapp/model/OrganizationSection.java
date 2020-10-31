package com.java_2_base.webapp.model;

import java.util.List;

public class OrganizationSection extends AbstractSection {

    private final List<Experience> data;

    public OrganizationSection(List<Experience> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        StringBuilder text = new StringBuilder();
        for (Experience element : data) {
            text.append("- ").append(element).append("\n");
        }
        return text.toString().trim();
    }
}
