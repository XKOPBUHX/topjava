package com.java_2_base.webapp.storage;

import com.java_2_base.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10000];
    private int size = 0;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void save(Resume resume) {
        if (size == storage.length - 1) {
            System.out.println("Save error! Storage is full!");
            return;
        }
        if (getIndexByUuid(resume.getUuid()) > -1) {
            System.out.println("Save error! Resume with uuid '" + resume.getUuid() + "' already exists!");
            return;
        }
        storage[size] = resume;
        size++;
    }

    public void update(Resume resume) {
        int i = getIndexByUuid(resume.getUuid());
        if (i == -1) {
            System.out.println("Update error! Resume with uuid '" + resume.getUuid() + "' not found!");
            return;
        }
        storage[i] = resume;
    }

    public Resume get(String uuid) {
        int i = getIndexByUuid(uuid);
        if (i == -1) {
            System.out.println("Error! Resume with uuid '" + uuid + "' not found!");
            return null;
        }
        return storage[i];
    }

    public void delete(String uuid) {
        int i = getIndexByUuid(uuid);
        if (i == -1) {
            System.out.println("Delete error! Resume with uuid '" + uuid + "' not found!");
            return;
        }
        storage[i] = storage[size - 1];
        storage[size - 1] = null;
        size--;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    public int size() {
        return size;
    }

    private int getIndexByUuid(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }
}
