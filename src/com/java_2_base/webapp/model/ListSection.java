package com.java_2_base.webapp.model;

import java.util.List;

public class ListSection<T> extends AbstractSection {

    private final List<T> list;

    public ListSection(List<T> list) {
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
}
