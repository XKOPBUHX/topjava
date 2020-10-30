package com.java_2_base.webapp.model;

import java.util.ArrayList;
import java.util.List;

public class OrganizationSection extends AbstractSection {

    public OrganizationSection() {
        this.section = new ArrayList<Experience>();
    }

    @Override
    public String toString() {
        StringBuilder text = new StringBuilder();
        for (Experience element : (List<Experience>) section) {
            text.append("- ").append(element).append("\n");
        }
        return text.toString().trim();
    }
}
