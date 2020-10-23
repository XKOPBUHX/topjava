package com.java_2_base.webapp.storage;

import com.java_2_base.webapp.model.Resume;

public class ArrayStorage extends AbstractArrayStorage {

    @Override
    protected Integer getSearchKey(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    protected void doAdd(Resume resume, int currentIndex) {
        storage[size] = resume;
    }

    @Override
    protected void doRemove(int index) {
        storage[index] = storage[size - 1];
    }
}