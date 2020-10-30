package com.java_2_base.webapp.model;

import java.util.ArrayList;
import java.util.List;

public class SectionListObject extends AbstractSection {

    public SectionListObject() {
        this.section = new ArrayList<ObjectList>();
    }

    @Override
    public String toString() {
        StringBuilder text = new StringBuilder();
        for (ObjectList element : (List<ObjectList>) section) {
            text.append("- ").append(element).append("\n");
        }
        return text.toString().trim();
    }
}
