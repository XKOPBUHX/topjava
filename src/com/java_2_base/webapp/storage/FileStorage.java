package com.java_2_base.webapp.storage;

import com.java_2_base.webapp.exception.StorageException;
import com.java_2_base.webapp.model.Resume;
import com.java_2_base.webapp.storage.serialization.SerializationStrategy;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FileStorage extends AbstractStorage<File> {
    private final File directory;
    private final SerializationStrategy serializationStrategy;

    protected FileStorage(File directory, SerializationStrategy serializationStrategy) {
        Objects.requireNonNull(directory, "directory must not be null");
        Objects.requireNonNull(serializationStrategy, "stream serialization must not be null");
        if (!directory.isDirectory()) {
            throw new IllegalArgumentException(directory.getAbsolutePath() + " is not directory");
        }
        if (!directory.canRead() || !directory.canWrite()) {
            throw new IllegalArgumentException(directory.getAbsolutePath() + " is not readable / writable");
        }
        this.directory = directory;
        this.serializationStrategy = serializationStrategy;
    }

    @Override
    protected boolean isExist(File file) {
        return file.exists();
    }

    @Override
    protected void doSave(Resume resume, File file) {
        try {
            if (!file.createNewFile()) {
                throw new StorageException("file save error", file.getName());
            }
        } catch (IOException e) {
            throw new StorageException("file save error", resume.getUuid(), e);
        }
        doUpdate(resume, file);
    }

    @Override
    protected void doUpdate(Resume resume, File file) {
        try {
            serializationStrategy.doWrite(resume, new BufferedOutputStream(new FileOutputStream(file)));
        } catch (IOException e) {
            throw new StorageException("file update error", resume.getUuid(), e);
        }
    }

    @Override
    protected void doDelete(File file) {
        if (!file.delete()) {
            throw new StorageException("file delete error", file.getName());
        }
    }

    @Override
    protected Resume doGet(File file) {
        try {
            return serializationStrategy.doRead(new BufferedInputStream(new FileInputStream(file)));
        } catch (IOException e) {
            throw new StorageException("file read error", file.getName(), e);
        }
    }

    @Override
    protected List<Resume> doCopyAll() {
        File[] files = getFilesInDirectory();
        List<Resume> resumes = new ArrayList<>(files.length);
        for (File file : files) {
            resumes.add(doGet(file));
        }
        return resumes;
    }

    @Override
    protected File getSearchKey(String uuid) {
        return new File(directory, uuid);
    }

    @Override
    public void clear() {
        File[] files = getFilesInDirectory();
        for (File file : files) {
            doDelete(file);
        }
    }

    @Override
    public int size() {
        return getFilesInDirectory().length;
    }

    private File[] getFilesInDirectory() {
        File[] files = directory.listFiles();
        if (files == null) {
            throw new StorageException("directory read error");
        }
        return files;
    }
}
