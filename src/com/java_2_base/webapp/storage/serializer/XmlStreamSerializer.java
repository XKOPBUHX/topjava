package com.java_2_base.webapp.storage.serializer;

import com.java_2_base.webapp.model.*;
import com.java_2_base.webapp.util.XmlParser;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class XmlStreamSerializer implements StreamSerializer {

    private final XmlParser xmlParser;

    public XmlStreamSerializer() {
        xmlParser = new XmlParser(Resume.class, ListSection.class, SimpleTextSection.class, OrganizationSection.class,
                Organization.class, Organization.Position.class, Organization.Link.class);
    }


    @Override
    public Resume doRead(InputStream stream) throws IOException {
        try (Reader reader = new InputStreamReader(stream, StandardCharsets.UTF_8)) {
            return (Resume) xmlParser.unmarshall(reader);
        }
    }

    @Override
    public void doWrite(Resume resume, OutputStream stream) throws IOException {
        try (Writer writer = new OutputStreamWriter(stream, StandardCharsets.UTF_8)) {
            xmlParser.marshall(resume, writer);
        }
    }
}
