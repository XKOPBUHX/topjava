package com.java_2_base.webapp.model;

public enum ContactType {
    PHONE("Телефон"),
    SKYPE("Скайп"),
    EMAIL("e-mail"),
    LINKEDIN("LinkedIn"),
    GITHUB("GitHub"),
    STACKOVERFLOW("StackOverFlow"),
    HOMEPAGE("Домашняя страница");

    private String title;

    ContactType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
