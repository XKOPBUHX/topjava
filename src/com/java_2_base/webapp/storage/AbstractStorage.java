package com.java_2_base.webapp.storage;

import com.java_2_base.webapp.exception.ExistStorageException;
import com.java_2_base.webapp.exception.NotExistStorageException;
import com.java_2_base.webapp.model.Resume;

public abstract class AbstractStorage implements Storage {

    @Override
    public void save(Resume resume) {
        if (doExist(resume.getUuid())) {
            throw new ExistStorageException(resume.getUuid());
        }
        doSave(resume);
    }

    @Override
    public void update(Resume resume) {
        checkResumeNotExist(resume.getUuid());
        doUpdate(resume);
    }

    @Override
    public void delete(String uuid) {
        checkResumeNotExist(uuid);
        doDelete(uuid);
    }

    @Override
    public Resume get(String uuid) {
        checkResumeNotExist(uuid);
        return doGet(uuid);
    }


    protected abstract boolean doExist(String uuid);

    protected abstract void doSave(Resume resume);

    protected abstract void doUpdate(Resume resume);

    protected abstract void doDelete(String uuid);

    protected abstract Resume doGet(String uuid);


    private void checkResumeNotExist(String uuid) {
        if (!doExist(uuid)) {
            throw new NotExistStorageException(uuid);
        }
    }
}