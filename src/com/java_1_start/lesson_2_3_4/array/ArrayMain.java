package com.java_1_start.lesson_2_3_4.array;

public class ArrayMain {

    public static void main(String[] args) {
        int[] numbers = new int[6];
        System.out.println("int[] numbers. Длина: " + numbers.length);
        //System.out.println("println numbers: " + numbers);
        System.out.println("Элементы массива:");
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i * 10;
            System.out.print(numbers[i] + " ");
        }

        float[] numbers1 = {5.1f, 0.5f, .5f, 200f};
        System.out.println("\nfloat[] numbers1. Длина: " + numbers1.length);
        //цикл foreach
        for (float number: numbers1) {
            System.out.print(number + " ");
        }

        String[] text = new String[3];
        text[0] = "Hello";
        text[2] = "Java";
        System.out.println("\nString[] text. Длина: " + text.length);
        for (String string: text) {
            System.out.println(string);
        }
    }
}