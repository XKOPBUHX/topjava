package com.java_2_base.webapp.storage.serializer;

import java.io.IOException;

@FunctionalInterface
public interface DataReader {
    void readElement() throws IOException;
}
