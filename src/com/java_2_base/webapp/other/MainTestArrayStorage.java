package com.java_2_base.webapp.other;

import com.java_2_base.webapp.model.Resume;
import com.java_2_base.webapp.storage.ArrayStorage;
import com.java_2_base.webapp.storage.Storage;

/**
 * Test for your ArrayStorage implementation
 */
public class MainTestArrayStorage {

    private static final Storage ARRAY_STORAGE = new ArrayStorage();

    public static void main(String[] args) {
        final Resume r1 = new Resume("uuid1", "Ivan");
        final Resume r2 = new Resume("uuid2", "Petr");
        final Resume r3 = new Resume("uuid3", "Anna");

        System.out.println("\nSave r1, r3, r2");
        ARRAY_STORAGE.save(r1);
        ARRAY_STORAGE.save(r3);
        ARRAY_STORAGE.save(r2);
        printAll();

        System.out.println("\nSave r1 (again)");
        //ARRAY_STORAGE.save(r1);
        printAll();

        System.out.println("\nGet r1: " + ARRAY_STORAGE.get(r1.getUuid()));
        System.out.println("Size: " + ARRAY_STORAGE.size());

        System.out.println();
        //System.out.println("Get dummy: " + ARRAY_STORAGE.get("dummy"));

        System.out.println();
        //System.out.println("Get uuid5: " + ARRAY_STORAGE.get("uuid5"));

        System.out.println("\nDelete r3");
        ARRAY_STORAGE.delete(r3.getUuid());
        printAll();

        System.out.println("\nDelete r1");
        ARRAY_STORAGE.delete(r1.getUuid());
        printAll();

        System.out.println("\nDelete uuid5");
        //ARRAY_STORAGE.delete("uuid5");
        printAll();

        System.out.println("\nUpdate r1");
        //ARRAY_STORAGE.update(r1);
        printAll();

        System.out.println("\nUpdate r2");
        ARRAY_STORAGE.update(r2);
        printAll();

        System.out.println("\nUpdate r4");
        //ARRAY_STORAGE.update(new Resume("uuid4"));
        printAll();

        System.out.println("\nClear");
        ARRAY_STORAGE.clear();
        printAll();

        System.out.println("\nSize: " + ARRAY_STORAGE.size());
    }

    private static void printAll() {
        System.out.println("Get All");
        for (Resume r : ARRAY_STORAGE.getAllSorted()) {
            System.out.println(r);
        }
    }
}