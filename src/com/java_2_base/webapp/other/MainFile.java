package com.java_2_base.webapp.other;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class MainFile {
    public static void main(String[] args) {
        String filePath = "E:\\JAVA\\Projects\\TopJava\\.gitignore";
        File file = new File(filePath);
        try {
            System.out.println(file.getCanonicalPath());
        } catch (IOException e) {
            throw new RuntimeException("Error", e);
        }
        System.out.println("file exist = " + file.exists());

        File dir = new File("E:\\JAVA\\Projects\\TopJava\\src\\com\\java_2_base\\webapp");
        System.out.println(dir);
        System.out.println("is directory : " + dir.isDirectory());
        String[] list = dir.list();
        if (list != null) {
            for (String name : list) {
                System.out.println(name);
            }
        }

        try (FileInputStream fileInputStream = new FileInputStream(filePath)) {
            System.out.println(fileInputStream.read());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("===========================");
        showFileTree(new File(System.getProperty("user.dir")), 0);
    }

    private static void showFileTree(File file, int level) {
        if (!file.exists()) {
            return;
        }
        StringBuilder indent = new StringBuilder();
        for (int i = 1; i < level; i++) {
            indent.append(" ");
        }
        System.out.println(indent.toString() + file.getName());
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null) {
                level++;
                for (File nestedFile : files) {
                    showFileTree(nestedFile, level);
                }
            }
        }
    }
}
