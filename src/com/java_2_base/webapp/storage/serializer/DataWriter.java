package com.java_2_base.webapp.storage.serializer;

import java.io.IOException;

@FunctionalInterface
public interface DataWriter<T> {
    void writeElement(T element) throws IOException;
}
