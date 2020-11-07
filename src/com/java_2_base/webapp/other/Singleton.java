package com.java_2_base.webapp.other;

public final class Singleton {

    private static Singleton instance;
    private final String value;

    public static Singleton getInstance(String value) {
        if (instance == null) {
            instance = new Singleton(value);
        }
        return instance;
    }

    private Singleton(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
