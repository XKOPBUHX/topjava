package com.java_2_base.webapp.storage;

import com.java_2_base.webapp.storage.serializer.DataStreamSerializer;

class DataPathStorageTest extends AbstractStorageTest {
    public DataPathStorageTest() {
        super(new PathStorage(STORAGE_DIR.getAbsolutePath(), new DataStreamSerializer()));
    }
}