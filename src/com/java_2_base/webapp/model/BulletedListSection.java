package com.java_2_base.webapp.model;

import java.util.List;

public class BulletedListSection extends AbstractSection {

    private final List<String> data;

    public BulletedListSection(List<String> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        StringBuilder text = new StringBuilder();
        for (String element : data) {
            text.append("- ").append(element).append("\n");
        }
        return text.toString().trim();
    }
}
