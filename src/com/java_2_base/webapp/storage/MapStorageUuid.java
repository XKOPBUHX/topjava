package com.java_2_base.webapp.storage;

import com.java_2_base.webapp.model.Resume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapStorageUuid extends AbstractStorage<String> {
    private final Map<String, Resume> storage = new HashMap<>();

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    public int size() {
        return storage.size();
    }

    @Override
    protected boolean isExist(String searchKey) {
        return storage.containsKey(searchKey);
    }

    @Override
    protected void doSave(Resume resume, String searchKey) {
        storage.put(searchKey, resume);
    }

    @Override
    protected void doUpdate(Resume resume, String searchKey) {
        storage.replace(searchKey, resume);
    }

    @Override
    protected void doDelete(String searchKey) {
        storage.remove(searchKey);
    }

    @Override
    protected Resume doGet(String searchKey) {
        return storage.get(searchKey);
    }

    @Override
    protected List<Resume> doCopyAll() {
        return new ArrayList<>(storage.values());
    }

    @Override
    protected String getSearchKey(String uuid) {
        return uuid;
    }
}
