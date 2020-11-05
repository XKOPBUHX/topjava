package com.java_2_base.webapp.storage;

import com.java_2_base.webapp.storage.serialization.StreamSerialization;

class PathStorageTest extends AbstractStorageTest {
    public PathStorageTest() {
        super(new PathStorage(STORAGE_DIR.getAbsolutePath(), new StreamSerialization()));
    }
}