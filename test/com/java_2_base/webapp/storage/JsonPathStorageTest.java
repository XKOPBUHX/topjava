package com.java_2_base.webapp.storage;

import com.java_2_base.webapp.storage.serializer.JsonStreamSerializer;

class JsonPathStorageTest extends AbstractStorageTest {
    public JsonPathStorageTest() {
       super(new PathStorage(STORAGE_DIR.getAbsolutePath(), new JsonStreamSerializer()));
    }
}