package com.java_2_base.webapp.storage;

class FileStorageTest extends AbstractStorageTest {
    public FileStorageTest() {
        super(new FileStorage(STORAGE_DIR, new StreamSerialization()));
    }
}