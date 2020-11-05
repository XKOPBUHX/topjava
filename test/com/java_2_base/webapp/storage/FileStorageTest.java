package com.java_2_base.webapp.storage;

import com.java_2_base.webapp.storage.serialization.StreamSerialization;

class FileStorageTest extends AbstractStorageTest {
    public FileStorageTest() {
        super(new FileStorage(STORAGE_DIR, new StreamSerialization()));
    }
}