package com.java_2_base.webapp.model;

import java.util.ArrayList;
import java.util.List;

public class SectionListString extends AbstractSection {

    public SectionListString() {
        this.section = new ArrayList<String>();
    }

    @Override
    public String toString() {
        StringBuilder text = new StringBuilder();
        for (String element : (List<String>) section) {
            text.append("- ").append(element).append("\n");
        }
        return text.toString().trim();
    }
}
