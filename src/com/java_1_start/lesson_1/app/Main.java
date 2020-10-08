package com.java_1_start.lesson_1.app;

public class Main {
	
	public static void main(String[] args) {
		/*
		1 + 2 + 3 + 4 + 5 = 15

		1 + 2 = 3
		3 + 3 = 6
		6 + 4 = 10
		10 + 5 = 15
		*/
		
		int result = 0;
		// FOR
		for (int i = 1; i <= 5; i++) {
			result += i;
			System.out.println("Число " + result + " является " + (result % 2 == 0 ? "" : "не") + "четным");
		}
		
		/*
		// WHILE
		int i = 1;
		while(i <= 5) {
			result += i;
			System.out.println("Число " + result + " является " + (result % 2 == 0 ? "" : "не") + "четным");
			i++;
		}
		*/

		/*
		// DO WHILE
		int i = 1;
		do {
			result += i;
			System.out.println("Число " + result + " является " + (result % 2 == 0 ? "" : "не") + "четным");
			i++;
		} while(i <= 5);
		*/

		System.out.println("1 + 2 + 3 + 4 + 5 = " + result);
	}
}