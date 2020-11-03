package com.java_2_base.webapp.storage;

import com.java_2_base.webapp.exception.StorageException;
import com.java_2_base.webapp.model.Resume;

import java.io.*;

public class ObjectStreamPathStorage extends AbstractPathStorage {

    protected ObjectStreamPathStorage(String dir) {
        super(dir);
    }

    @Override
    protected Resume doRead(InputStream stream) throws IOException {
        try (ObjectInputStream inputStream = new ObjectInputStream(stream)) {
            return (Resume) inputStream.readObject();
        } catch (ClassNotFoundException e) {
            throw new StorageException("file read error", null, e);
        }
    }

    @Override
    protected void doWrite(Resume resume, OutputStream stream) throws IOException {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(stream)) {
            outputStream.writeObject(resume);
        }
    }
}
