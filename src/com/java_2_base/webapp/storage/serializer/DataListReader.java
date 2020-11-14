package com.java_2_base.webapp.storage.serializer;

import java.io.IOException;

@FunctionalInterface
public interface DataListReader<T> {
    T readElement() throws IOException;
}
