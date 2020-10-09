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
    private static final int STORAGE_LIMIT = 10_000;

    public AbstractArrayStorageTest(Storage storage) {
        this.storage = storage;
    }

    @BeforeEach
    void setUp() {
        storage.clear();
        storage.save(new Resume(UUID_1));
        storage.save(new Resume(UUID_2));
        storage.save(new Resume(UUID_3));
    }

    @Test
    void save() {
        storage.save(new Resume(UUID_4));
        try {
            storage.get(UUID_4);
        } catch (Exception e) {
            Assertions.fail("Resume with uuid '" + UUID_4 + "' not saved!");
        }
    }

    @Test
    void saveExist() {
        assertThrows(ExistStorageException.class, () -> storage.save(new Resume(UUID_3)));
    }

    @Test
    void saveOverflow() {
        try {
            while (storage.size() < STORAGE_LIMIT) {
                storage.save(new Resume());
            }
        } catch (Exception e) {
            Assertions.fail("Attention! Storage problems found!");
        }
        assertThrows(StorageException.class, () -> storage.save(new Resume()));
    }

    @Test
    void update() {
        storage.update(new Resume(UUID_1));
        assertEquals(storage.getAll()[0].getUuid(), UUID_1);
    }

    @Test
    void updateNotExist() {
        assertThrows(NotExistStorageException.class, () -> storage.update(new Resume(UUID_4)));
    }

    @Test
    void delete() {
        storage.delete(UUID_1);
        assertThrows(NotExistStorageException.class, () -> storage.get(UUID_1));
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
    void sizeSave() {
        storage.save(new Resume(UUID_4));
        assertEquals(4, storage.size());
    }

    @Test
    void sizeDelete() {
        storage.delete(UUID_1);
        assertEquals(2, storage.size());
    }

    @Test
    void get() {
        Resume resume = storage.get(UUID_1);
        assertEquals(resume.getUuid(), UUID_1);
    }

    @Test
    void getNotExist() {
        assertThrows(NotExistStorageException.class, () -> storage.get(UUID_4));
    }

    @Test
    void getAll() {
        Resume[] currentStorage = storage.getAll();
        Resume[] testStorage = new Resume[3];
        if (currentStorage.length != testStorage.length) {
            Assertions.fail("Attention! Storage problems found!");
        }
        testStorage[0] = new Resume(UUID_1);
        testStorage[1] = new Resume(UUID_2);
        testStorage[2] = new Resume(UUID_3);
        for (int i = 0; i < currentStorage.length; i++) {
            if (!currentStorage[i].equals(testStorage[i])) {
                Assertions.fail("Attention! Storage problems found!");
            }
        }
    }

    private boolean isEmpty() {
        boolean isEmpty = true;
        if (storage != null && storage.size() != 0) {
            for (Resume resume : storage.getAll()) {
                if (resume != null) {
                    isEmpty = false;
                    break;
                }
            }
        }
        return isEmpty;
    }
}