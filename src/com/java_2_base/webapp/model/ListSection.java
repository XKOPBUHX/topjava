package com.java_2_base.webapp.model;

import java.util.List;
import java.util.Objects;

public class ListSection<T> extends AbstractSection {

    private static final long serialVersionUID = 1L;
    private final List<T> list;

    public ListSection(List<T> list) {
        Objects.requireNonNull(list, "list sections must not be null");
        this.list = list;
    }

    public List<T> getList() {
        return list;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T element : list) {
            sb.append("- ").append(element).append("\n");
        }
        return sb.toString().trim();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ListSection<?> that = (ListSection<?>) o;

        return list.equals(that.list);
    }

    @Override
    public int hashCode() {
        return list.hashCode();
    }
}
