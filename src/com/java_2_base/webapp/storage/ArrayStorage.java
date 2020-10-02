package com.java_2_base.webapp.storage;

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
    protected int getIndexToSaveElement(int currentIndex) {
        return size;
    }

    @Override
    protected void removeElement(int index) {
        storage[index] = storage[size - 1];
    }
}