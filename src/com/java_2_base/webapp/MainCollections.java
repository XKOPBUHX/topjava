package com.java_2_base.webapp;

import com.java_2_base.webapp.model.Resume;

import java.util.*;

public class MainCollections {
    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";
    private static final String UUID_4 = "uuid4";
    private static final Resume RESUME_1 = new Resume(UUID_1, "Ivan");
    private static final Resume RESUME_2 = new Resume(UUID_2, "Petr");
    private static final Resume RESUME_3 = new Resume(UUID_3, "Anna");
    private static final Resume RESUME_4 = new Resume(UUID_4, "Max");

    public static void main(String[] args) {
        System.out.println("ArrayList");
        Collection<Resume> collection = new ArrayList<>();
        collection.add(RESUME_1);
        collection.add(RESUME_2);
        collection.add(RESUME_3);

        System.out.println("Перебор через foreach");
        for (Resume resume : collection) {
            System.out.println(resume);
            if (Objects.equals(resume.getUuid(), UUID_1)) {
                //collection.remove(resume);
                System.out.println("collection.remove(resume) - упадет с ошибкой модификации коллекции во время ее обхода");
            }
        }
        System.out.println("collection.toString(): " + collection.toString());

        System.out.println("\nПеребор через итератор");
        Iterator<Resume> iterator = collection.iterator();
        while (iterator.hasNext()) {
            Resume resume = iterator.next();
            System.out.println(resume);
            if (Objects.equals(resume.getUuid(), UUID_1)) {
                iterator.remove();
            }
        }
        System.out.println("collection.toString(): " + collection.toString());

        System.out.println("\nMap");
        Map<String, Resume> map = new HashMap<>();
        map.put(UUID_1, RESUME_1);
        map.put(UUID_2, RESUME_2);
        map.put(UUID_3, RESUME_3);

        System.out.println("Перебор через набор ключ-значение");
        for (Map.Entry<String, Resume> entry : map.entrySet()) {
            System.out.println(entry.getValue());
        }
        System.out.println("map.toString(): " + map.toString());

        System.out.println("\nArrayList внутренний");
        List<Resume> resumes = Arrays.asList(RESUME_1, RESUME_2, RESUME_3);
        // Ошибка! Это внутренний класс ArrayList, без метода remove
        //resumes.remove(1);
        System.out.println(resumes.toString());
    }
}
