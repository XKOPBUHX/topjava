package com.java_2_base.webapp.storage;

import com.java_2_base.webapp.exception.StorageException;
import com.java_2_base.webapp.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage extends AbstractStorage {
    protected static final int STORAGE_LIMIT = 10_000;

    protected final Resume[] storage = new Resume[STORAGE_LIMIT];
    int size = 0;

    @Override
    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }


    @Override
    protected boolean doExist(String uuid) {
        return getIndex(uuid) >= 0;
    }

    @Override
    protected void doSave(Resume resume) {
        if (size == STORAGE_LIMIT) {
            throw new StorageException("Storage overflow", resume.getUuid());
        }
        doAdd(getIndex(resume.getUuid()), resume);
        size++;
    }

    @Override
    protected void doUpdate(Resume resume) {
        storage[getIndex(resume.getUuid())] = resume;
    }

    @Override
    protected void doDelete(String uuid) {
        doRemove(getIndex(uuid));
        storage[size - 1] = null;
        size--;
    }

    @Override
    protected Resume doGet(String uuid) {
        return storage[getIndex(uuid)];
    }


    protected abstract int getIndex(String uuid);

    protected abstract void doAdd(int currentIndex, Resume resume);

    protected abstract void doRemove(int index);
}