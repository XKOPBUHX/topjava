package com.java_1_start.lesson_1.app;

public class Cycle {
	
	public static void main(String[] args) {
		System.out.println("Цикл FOR:");
		for (int i = 0; i <= 20; i++) {
			System.out.println(i);
		}
		System.out.println();

		System.out.println("Цикл WHILE:");
		int j = 6;
		while (j >= -6) {
			System.out.println(j);
			j -= 2;
		}
		System.out.println();

		System.out.println("Цикл DO WHILE:");
		int sum = 0;
		j = 10;
		do {
			if(j % 2 != 0) {
				sum += j;
			}
			j++;
		} while (j <= 20);
		System.out.println("Сумма нечетных чисел " + sum);
	}
}