package com.java_2_base.webapp.storage;

import com.java_2_base.webapp.model.Resume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapStorageUuid extends AbstractStorage {
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
    protected boolean isExist(Object searchKey) {
        return storage.containsKey(String.valueOf(searchKey));
    }

    @Override
    protected void doSave(Resume resume, Object searchKey) {
        storage.put(String.valueOf(searchKey), resume);
    }

    @Override
    protected void doUpdate(Resume resume, Object searchKey) {
        storage.replace(String.valueOf(searchKey), resume);
    }

    @Override
    protected void doDelete(Object searchKey) {
        storage.remove(String.valueOf(searchKey));
    }

    @Override
    protected Resume doGet(Object searchKey) {
        return storage.get(String.valueOf(searchKey));
    }

    protected Object getSearchKey(String uuid) {
        return uuid;
    }

    @Override
    protected List<Resume> getAll() {
        return new ArrayList<>(storage.values());
    }
}
