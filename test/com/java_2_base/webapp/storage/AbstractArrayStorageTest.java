package com.java_2_base.webapp.storage;

import com.java_2_base.webapp.exception.ExistStorageException;
import com.java_2_base.webapp.exception.NotExistStorageException;
import com.java_2_base.webapp.exception.StorageException;
import com.java_2_base.webapp.model.Resume;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

abstract class AbstractArrayStorageTest {
    private final Storage storage;
    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";
    private static final String UUID_4 = "uuid4";
    private static final Resume RESUME_1 = new Resume(UUID_1);
    private static final Resume RESUME_2 = new Resume(UUID_2);
    private static final Resume RESUME_3 = new Resume(UUID_3);
    private static final Resume RESUME_4 = new Resume(UUID_4);
    private static final int STORAGE_LIMIT = 10_000;

    public AbstractArrayStorageTest(Storage storage) {
        this.storage = storage;
    }

    @BeforeEach
    void setUp() {
        storage.clear();
        storage.save(RESUME_1);
        storage.save(RESUME_2);
        storage.save(RESUME_3);
    }

    @Test
    void save() {
        storage.save(RESUME_4);
        try {
            storage.get(UUID_4);
        } catch (StorageException e) {
            Assertions.fail("Resume with uuid '" + UUID_4 + "' not saved!");
        }
        assertEquals(4, storage.size());
    }

    @Test
    void saveExist() {
        assertThrows(ExistStorageException.class, () -> storage.save(RESUME_3));
    }

    @Test
    void saveOverflow() {
        try {
            while (storage.size() < STORAGE_LIMIT) {
                storage.save(new Resume());
            }
        } catch (StorageException e) {
            Assertions.fail("Attention! Storage problems found!");
        }
        assertThrows(StorageException.class, () -> storage.save(new Resume()));
    }

    @Test
    void update() {
        storage.update(RESUME_1);
        assertEquals(storage.get(UUID_1), RESUME_1);
    }

    @Test
    void updateNotExist() {
        assertThrows(NotExistStorageException.class, () -> storage.update(RESUME_4));
    }

    @Test
    void delete() {
        storage.delete(UUID_1);
        assertThrows(NotExistStorageException.class, () -> storage.get(UUID_1));
        assertEquals(2, storage.size());
    }

    @Test
    void deleteEmpty() {
        storage.clear();
        assertThrows(NotExistStorageException.class, () -> storage.delete(UUID_1));
        assertEquals(0, storage.size());
    }

    @Test
    void clear() {
        storage.clear();
        assertTrue(isEmpty());
    }

    @Test
    void clearNot() {
        assertFalse(isEmpty());
    }

    @Test
    void size() {
        assertEquals(3, storage.size());
    }

    @Test
    void get() {
        assertEquals(storage.get(UUID_1), RESUME_1);
    }

    @Test
    void getNotExist() {
        assertThrows(NotExistStorageException.class, () -> storage.get(UUID_4));
    }

    @Test
    void getAll() {
        Resume[] actualResumes = storage.getAll();
        Resume[] expectedResumes = new Resume[]{RESUME_1, RESUME_2, RESUME_3};
        if (actualResumes.length != expectedResumes.length) {
            Assertions.fail("Attention! Storage problems found!");
        }
        for (int i = 0; i < actualResumes.length; i++) {
            if (!actualResumes[i].equals(expectedResumes[i])) {
                Assertions.fail("Attention! Storage problems found!");
            }
        }
    }

    private boolean isEmpty() {
        return storage == null || storage.size() == 0 || storage.getAll().length == 0;
    }
}