package com.java_1_start.lesson_2_3_4.array;

import java.util.Scanner;

public class ArrayMaxElementMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите длину массива: ");
        int maxLength = scanner.nextInt();
        int[] numbers = new int[maxLength];

        System.out.print("Заполните массив целыми числами через пробел: ");
        for (int i = 0; i < maxLength; i++) {
            numbers[i] = scanner.nextInt();
        }

        int max = numbers[0];
        for (int i: numbers) {
            if (i > max) {
                max = i;
            }
        }
        System.out.println("Максимальное значение: " + max);
    }
}
