package com.java_2_base.webapp.model;

public class SimpleTextSection extends AbstractSection {

    public SimpleTextSection(String section) {
        this.section = section;
    }

    @Override
    public String toString() {
        return (String) section;
    }
}
