package com.java_2_base.webapp.storage.serializer;

import com.java_2_base.webapp.model.Resume;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public interface StreamSerializer {

    Resume doRead(InputStream stream) throws IOException;

    void doWrite(Resume resume, OutputStream stream) throws IOException;
}
