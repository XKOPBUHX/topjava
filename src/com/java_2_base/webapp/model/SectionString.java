package com.java_2_base.webapp.model;

public class SectionString extends AbstractSection {

    public SectionString(String section) {
        this.section = section;
    }

    @Override
    public String toString() {
        return (String) section;
    }
}
