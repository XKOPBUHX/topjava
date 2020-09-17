package com.java_1_start.lesson_2_3.calculator;

import java.util.Scanner;

public class CalculatorTest {
	
	public static void main(String[] args) {
		Calculator calculator = new Calculator();
		Scanner scanner = new Scanner(System.in, "Cp866");
		String response = "";
		while (!response.equals("нет")) {
			System.out.print("Введите первое число: ");
			calculator.setFirstNumber(scanner.nextInt());
			System.out.print("Введите знак математической операции: ");
			calculator.setMathOperation(scanner.next().charAt(0));
			System.out.print("Введите второе число: ");
			calculator.setSecondNumber(scanner.nextInt());
			calculator.calculate();
			response = "";
			while (!response.equals("да") && !response.equals("нет")) {
				System.out.print("Хотите продолжить?[да/нет]: ");
				response = scanner.next();
			}
		}
	}
}