package com.java_1_start.lesson_2_3_4.calculator;

public class Calculator {
	
	private String mathExpression;
	private int firstNumber;
	private int secondNumber;
	private char mathOperation;

	public void setStringMath(String mathExpression) {
		this.mathExpression = mathExpression;
	}

	public void calculate() {
		prepareMathOperation();
		switch (mathOperation) {
			case '+' :
				System.out.println(firstNumber + " " + mathOperation + " " + secondNumber + " = " + Math.addExact(firstNumber, secondNumber));
				break;
			case '-' :
				System.out.println(firstNumber + " " + mathOperation + " " + secondNumber + " = " + Math.subtractExact(firstNumber, secondNumber));
				break;
			case '*' :
				System.out.println(firstNumber + " " + mathOperation + " " + secondNumber + " = " + Math.multiplyExact(firstNumber, secondNumber));
				break;
			case '/' :
				if (secondNumber == 0) {
					System.out.println("На 0 делить нельзя!");
				} else {
					System.out.println(firstNumber + " " + mathOperation + " " + secondNumber + " = " + Math.floorDiv(firstNumber, secondNumber));
				}
				break;
			case '%' :
				System.out.println(firstNumber + " " + mathOperation + " " + secondNumber + " = " + Math.floorMod(firstNumber, secondNumber));
				break;
			case '^' :
				if (secondNumber < 0) {
					System.out.println("Возводить в отрицательную степень нельзя!");
				} else {
					System.out.println(firstNumber + " " + mathOperation + " " + secondNumber + " = " + Math.pow(firstNumber, secondNumber));
				}
				break;
			default :
				System.out.println("Вы ввели недопустимую операцию '" + mathOperation + "'!");
		}
	}

	private void prepareMathOperation() {
		String[] arrayMath = mathExpression.split(" ");
		if (arrayMath.length != 3) {
			System.out.println("Вы ввели что-то не то!");
			return;
		}
		firstNumber = Integer.parseInt(arrayMath[0]);
		secondNumber = Integer.parseInt(arrayMath[2]);
		mathOperation = arrayMath[1].charAt(0);
	}
}