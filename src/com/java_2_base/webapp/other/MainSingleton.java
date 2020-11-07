package com.java_2_base.webapp.other;

public class MainSingleton {

    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance("first value");
        Singleton anotherSingleton = Singleton.getInstance("second value");
        System.out.println(singleton.getValue());
        System.out.println(anotherSingleton.getValue());
    }
}
