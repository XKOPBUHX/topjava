package com.java_2_base.webapp.storage.serializer;

import com.java_2_base.webapp.model.Resume;
import com.java_2_base.webapp.util.JsonParser;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class JsonStreamSerializer implements StreamSerializer {

    @Override
    public Resume doRead(InputStream stream) throws IOException {
        try (Reader reader = new InputStreamReader(stream, StandardCharsets.UTF_8)) {
            return JsonParser.read(reader, Resume.class);
        }
    }

    @Override
    public void doWrite(Resume resume, OutputStream stream) throws IOException {
        try (Writer writer = new OutputStreamWriter(stream, StandardCharsets.UTF_8)) {
            JsonParser.write(resume, writer);
        }
    }
}
