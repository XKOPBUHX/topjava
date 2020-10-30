package com.java_2_base.webapp.storage;

import com.java_2_base.webapp.exception.ExistStorageException;
import com.java_2_base.webapp.exception.NotExistStorageException;
import com.java_2_base.webapp.model.Resume;

import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

public abstract class AbstractStorage<SK> implements Storage {

    //protected final Logger log = Logger.getLogger(getClass().getName());
    private static final Logger LOG = Logger.getLogger(AbstractStorage.class.getName());

    @Override
    public void save(Resume resume) {
        LOG.info("Save " + resume);
        SK searchKey = getNotExistingKey(resume.getUuid());
        doSave(resume, searchKey);
    }

    @Override
    public void update(Resume resume) {
        LOG.info("Update " + resume);
        SK searchKey = getExistingKey(resume.getUuid());
        doUpdate(resume, searchKey);
    }

    @Override
    public void delete(String uuid) {
        LOG.info("Delete " + uuid);
        SK searchKey = getExistingKey(uuid);
        doDelete(searchKey);
    }

    @Override
    public Resume get(String uuid) {
        LOG.info("Get " + uuid);
        SK searchKey = getExistingKey(uuid);
        return doGet(searchKey);
    }

    @Override
    public List<Resume> getAllSorted() {
        LOG.info("Get all sorted");
        List<Resume> list = doCopyAll();
        Collections.sort(list);
        return list;
    }


    protected abstract boolean isExist(SK searchKey);

    protected abstract void doSave(Resume resume, SK searchKey);

    protected abstract void doUpdate(Resume resume, SK searchKey);

    protected abstract void doDelete(SK searchKey);

    protected abstract Resume doGet(SK searchKey);

    protected abstract List<Resume> doCopyAll();

    protected abstract SK getSearchKey(String uuid);


    private SK getExistingKey(String uuid) {
        SK searchKey = getSearchKey(uuid);
        if (!isExist(searchKey)) {
            LOG.warning("Resume with uuid '" + uuid + "' not exists!");
            throw new NotExistStorageException(uuid);
        }
        return searchKey;
    }

    private SK getNotExistingKey(String uuid) {
        SK searchKey = getSearchKey(uuid);
        if (isExist(searchKey)) {
            LOG.warning("Resume with uuid '" + uuid + "' already exists!");
            throw new ExistStorageException(uuid);
        }
        return searchKey;
    }
}