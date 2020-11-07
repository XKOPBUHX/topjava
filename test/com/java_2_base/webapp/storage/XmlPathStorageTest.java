package com.java_2_base.webapp.storage;

import com.java_2_base.webapp.storage.serializer.XmlStreamSerializer;

class XmlPathStorageTest extends AbstractStorageTest {
    public XmlPathStorageTest() {
        super(new PathStorage(STORAGE_DIR.getAbsolutePath(), new XmlStreamSerializer()));
    }
}