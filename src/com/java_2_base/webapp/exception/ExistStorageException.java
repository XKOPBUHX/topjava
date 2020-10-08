package com.java_2_base.webapp.exception;

public class ExistStorageException extends StorageException {

    public ExistStorageException(String uuid) {
        super("Resume with uuid '" + uuid + "' already exists!", uuid);
    }
}