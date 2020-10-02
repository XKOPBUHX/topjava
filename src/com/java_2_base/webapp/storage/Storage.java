package com.java_2_base.webapp.storage;

import com.java_2_base.webapp.model.Resume;

public interface Storage {

    void save(Resume resume);

    void update(Resume resume);

    void delete(String uuid);

    void clear();

    int size();

    Resume get(String uuid);

    Resume[] getAll();
}