package com.java_2_base;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    private int indexStorage = 0;

    void clear() {
        Arrays.fill(storage, 0, indexStorage, null);
        indexStorage = 0;
    }

    void save(Resume r) {
        storage[indexStorage] = r;
        indexStorage++;
    }

    Resume get(String uuid) {
        int index = getIndexByUuid(uuid);
        if (index == -1) {
            return null;
        }
        return storage[index];
    }

    void delete(String uuid) {
        int index = getIndexByUuid(uuid);
        if (index == -1) {
            return;
        }
        storage[index] = storage[indexStorage - 1];
        storage[indexStorage - 1] = null;
        indexStorage--;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOf(storage, indexStorage);
    }

    int size() {
        return indexStorage;
    }

    private int getIndexByUuid(String uuid) {
        for (int i = 0; i < indexStorage; i++) {
            Resume resume = storage[i];
            if (resume.uuid.equals(uuid)) {
                return i;
            }
        }
        return -1;
    }
}
