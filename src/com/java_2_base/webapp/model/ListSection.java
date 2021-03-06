package com.java_2_base.webapp.model;

import java.util.List;
import java.util.Objects;

public class ListSection extends AbstractSection {

    private static final long serialVersionUID = 1L;
    private List<String> list;

    public ListSection() {
    }

    public ListSection(List<String> list) {
        Objects.requireNonNull(list, "list sections must not be null");
        this.list = list;
    }

    public List<String> getList() {
        return list;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String element : list) {
            sb.append("- ").append(element).append("\n");
        }
        return sb.toString().trim();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ListSection that = (ListSection) o;

        return list.equals(that.list);
    }

    @Override
    public int hashCode() {
        return list.hashCode();
    }
}
