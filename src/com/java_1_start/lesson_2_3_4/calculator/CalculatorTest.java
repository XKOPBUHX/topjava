package com.java_1_start.lesson_2_3_4.calculator;

import java.util.Scanner;

public class CalculatorTest {

	private static Scanner scanner;

	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		do {
			Calculator calculator = new Calculator();
			System.out.print("\nВведите математическое выражение: ");
			String srcExpression = scanner.nextLine();
			calculator.setStringMath(srcExpression);
			System.out.println(calculator.calculate());
		} while (isNext());
	}

	private static boolean isNext() {
		System.out.println();
		String response;
		do {
			System.out.print("Хотите продолжить?[да/нет]: ");
			response = scanner.nextLine();
		} while (!response.equals("да") && !response.equals("нет"));
		return response.equals("да");
	}
}