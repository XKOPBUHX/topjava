package com.java_2_base.webapp.storage;

import com.java_2_base.webapp.exception.ExistStorageException;
import com.java_2_base.webapp.exception.NotExistStorageException;
import com.java_2_base.webapp.model.Resume;

public abstract class AbstractStorage implements Storage {

    @Override
    public void save(Resume resume) {
        Object searchKey = getKey(resume.getUuid(), false);
        doSave(resume, searchKey);
    }

    @Override
    public void update(Resume resume) {
        Object searchKey = getKey(resume.getUuid(), true);
        doUpdate(resume, searchKey);
    }

    @Override
    public void delete(String uuid) {
        Object searchKey = getKey(uuid, true);
        doDelete(searchKey);
    }

    @Override
    public Resume get(String uuid) {
        Object searchKey = getKey(uuid, true);
        return doGet(searchKey);
    }


    protected abstract boolean isExist(Object searchKey);

    protected abstract void doSave(Resume resume, Object searchKey);

    protected abstract void doUpdate(Resume resume, Object searchKey);

    protected abstract void doDelete(Object searchKey);

    protected abstract Resume doGet(Object searchKey);

    protected abstract Object getSearchKey(String uuid);


    private Object getKey(String uuid, boolean shouldExist) {
        Object searchKey = getSearchKey(uuid);
        if (shouldExist && !isExist(searchKey)) {
            throw new NotExistStorageException(uuid);
        } else if (!shouldExist && isExist(searchKey)) {
            throw new ExistStorageException(uuid);
        }
        return searchKey;
    }
}