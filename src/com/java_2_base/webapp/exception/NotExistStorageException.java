package com.java_2_base.webapp.exception;

public class NotExistStorageException extends StorageException {

    public NotExistStorageException(String uuid) {
        super("Resume with uuid '" + uuid + "' not exists!", uuid);
    }
}