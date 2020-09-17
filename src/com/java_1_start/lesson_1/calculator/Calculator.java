package com.java_1_start.lesson_1.calculator;

public class Calculator {
	
	public static void main(String[] args) {
		int firstNumber = 10;
		int secondNumber = 0;
		char mathOperation = '^';
		
		System.out.print(firstNumber + " " + mathOperation + " " + secondNumber + " = ");
		if (mathOperation == '+') {
			System.out.println(firstNumber + secondNumber);
		} else if (mathOperation == '-') {
			System.out.println(firstNumber - secondNumber);
		} else if (mathOperation == '*') {
			System.out.println(firstNumber * secondNumber);
		} else if (mathOperation == '/') {
			System.out.println(firstNumber / secondNumber);
		} else if (mathOperation == '%') {
			System.out.println(firstNumber % secondNumber);
		} else if (mathOperation == '^') {
			long result = 1;
			for (int i = 0; i < secondNumber; i++) {
				result *= firstNumber;		
			}
			System.out.println(result);
		}
	}
}