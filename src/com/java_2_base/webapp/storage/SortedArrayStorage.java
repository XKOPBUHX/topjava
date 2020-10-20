package com.java_2_base.webapp.storage;

import com.java_2_base.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    protected Object getSearchKey(String uuid) {
        return Arrays.binarySearch(storage, 0, size, new Resume(uuid));
    }

    @Override
    protected void doAdd(Resume resume, int currentIndex) {
        int newIndex = Math.abs(currentIndex + 1);
        // Shifting array to one location right
        System.arraycopy(storage, newIndex, storage, newIndex + 1, size - newIndex);
        storage[newIndex] = resume;
    }

    @Override
    protected void doRemove(int index) {
        // Shifting array to one location left
        System.arraycopy(storage, index + 1, storage, index, size - index - 1);
    }
}