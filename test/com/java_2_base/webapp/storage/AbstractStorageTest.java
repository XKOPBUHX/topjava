package com.java_2_base.webapp.storage;

import com.java_2_base.webapp.exception.ExistStorageException;
import com.java_2_base.webapp.exception.NotExistStorageException;
import com.java_2_base.webapp.model.Resume;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static com.java_2_base.webapp.other.ResumeTestData.createResume;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

abstract class AbstractStorageTest {
    final Storage storage;
    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";
    private static final String UUID_4 = "uuid4";
    private static final Resume RESUME_1 = createResume(UUID_1, "Ivan");
    private static final Resume RESUME_2 = createResume(UUID_2, "Petr");
    private static final Resume RESUME_3 = createResume(UUID_3, "Anna");
    private static final Resume RESUME_4 = createResume(UUID_4, "Max");

    AbstractStorageTest(Storage storage) {
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
        assertGet(RESUME_4, UUID_4);
        assertSize(4);
    }

    @Test
    void saveExist() {
        assertThrows(ExistStorageException.class, () -> storage.save(RESUME_3));
    }

    @Test
    void update() {
        Resume resume = createResume(UUID_1, "Ivan New");
        storage.update(resume);
        assertEquals(storage.get(UUID_1), resume);
    }

    @Test
    void updateNotExist() {
        assertThrows(NotExistStorageException.class, () -> storage.update(RESUME_4));
    }

    @Test
    void delete() {
        storage.delete(UUID_1);
        assertThrows(NotExistStorageException.class, () -> storage.get(UUID_1));
        assertSize(2);
    }

    @Test
    void deleteNotExist() {
        assertThrows(NotExistStorageException.class, () -> storage.delete(UUID_4));
    }

    @Test
    void clear() {
        storage.clear();
        assertSize(0);
    }

    @Test
    void size() {
        assertSize(3);
    }

    @Test
    void get() {
        assertGet(RESUME_1, UUID_1);
        assertGet(RESUME_2, UUID_2);
        assertGet(RESUME_3, UUID_3);
    }

    @Test
    void getNotExist() {
        assertThrows(NotExistStorageException.class, () -> storage.get(UUID_4));
    }

    @Test
    void getAllSorted() {
        List<Resume> actualResumes = storage.getAllSorted();
        List<Resume> expectedResumes = Arrays.asList(RESUME_3, RESUME_1, RESUME_2);
        assertEquals(expectedResumes, actualResumes);
    }

    private void assertSize(int size) {
        assertEquals(size, storage.size());
    }

    private void assertGet(Resume resume, String uuid) {
        assertEquals(resume, storage.get(uuid));
    }
}