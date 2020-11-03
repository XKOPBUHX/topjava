package com.java_2_base.webapp.other;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class MainFile {
    public static void main(String[] args) {
        String filePath = "./.gitignore";
        File file = new File(filePath);
        try {
            System.out.println(file.getCanonicalPath());
        } catch (IOException e) {
            throw new RuntimeException("Error", e);
        }
        System.out.println("file exist = " + file.exists());

        File dir = new File("./src/com/java_2_base/webapp");
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
        StringBuilder indentBuilder = new StringBuilder();
        showFileTree(new File(System.getProperty("user.dir")), indentBuilder);
    }

    private static void showFileTree(File file, StringBuilder indent) {
        if (!file.exists()) {
            return;
        }
        System.out.println(indent + file.getName());
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null) {
                for (File nestedFile : files) {
                    showFileTree(nestedFile, indent.append("-"));
                    indent.delete(indent.length() - 1, indent.length());
                }
            }
        }
    }
}
