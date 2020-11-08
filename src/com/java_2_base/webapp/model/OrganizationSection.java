package com.java_2_base.webapp.model;

import java.util.List;
import java.util.Objects;

public class OrganizationSection extends AbstractSection {

    private static final long serialVersionUID = 1L;
    private List<Organization> list;

    public OrganizationSection() {
    }

    public OrganizationSection(List<Organization> list) {
        Objects.requireNonNull(list, "organization sections must not be null");
        this.list = list;
    }

    public List<Organization> getList() {
        return list;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Organization element : list) {
            sb.append("- ").append(element).append("\n");
        }
        return sb.toString().trim();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrganizationSection that = (OrganizationSection) o;

        return list.equals(that.list);
    }

    @Override
    public int hashCode() {
        return list.hashCode();
    }
}
