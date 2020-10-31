package com.java_2_base.webapp.model;

public class SimpleTextSection extends AbstractSection {

    private final String text;

    public SimpleTextSection(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
