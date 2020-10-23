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
    protected boolean isExist(Object searchKey) {
        return (Integer) searchKey >= 0;
    }

    @Override
    protected void doSave(Resume resume, Object searchKey) {
        if (size == STORAGE_LIMIT) {
            throw new StorageException("Storage overflow", resume.getUuid());
        }
        doAdd(resume, (Integer) searchKey);
        size++;
    }

    @Override
    protected void doUpdate(Resume resume, Object searchKey) {
        storage[(Integer) searchKey] = resume;
    }

    @Override
    protected void doDelete(Object searchKey) {
        doRemove((Integer) searchKey);
        storage[size - 1] = null;
        size--;
    }

    @Override
    protected Resume doGet(Object searchKey) {
        return storage[(Integer) searchKey];
    }

    @Override
    protected Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }


    protected abstract Integer getSearchKey(String uuid);

    protected abstract void doAdd(Resume resume, int currentIndex);

    protected abstract void doRemove(int index);
}