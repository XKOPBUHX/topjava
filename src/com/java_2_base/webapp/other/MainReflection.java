package com.java_2_base.webapp.other;

import com.java_2_base.webapp.model.Resume;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainReflection {
    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Resume resume = new Resume("testName");
        System.out.println(resume);
        Field field = resume.getClass().getDeclaredFields()[0];
        // Hack: cancel access check
        field.setAccessible(true);
        System.out.println(field.getName());
        System.out.println(field.get(resume));
        field.set(resume, "new_uuid");
        System.out.println(resume);
        // Method call using reflection
        Method method = resume.getClass().getMethod("toString");
        System.out.println(method.invoke(resume));
    }
}
