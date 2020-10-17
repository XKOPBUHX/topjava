package com.java_2_base.webapp.storage;

import com.java_2_base.webapp.model.Resume;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {

    @Override
    protected int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    protected void doAdd(int currentIndex, Resume resume) {
        storage[size] = resume;
    }

    @Override
    protected void doRemove(int index) {
        storage[index] = storage[size - 1];
    }
}