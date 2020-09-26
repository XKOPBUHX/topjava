package com.java_1_start.lesson_2_3_4.calculator;

public class Calculator {
	
	private String mathExpression;
	private int firstNumber;
	private int secondNumber;
	private char mathOperation;

	public void setStringMath(String mathExpression) {
		this.mathExpression = mathExpression;
	}

	public int calculate() {
		prepareMathOperation();
		switch (mathOperation) {
			case '+' :
				return Math.addExact(firstNumber, secondNumber);
			case '-' :
				return Math.subtractExact(firstNumber, secondNumber);
			case '*' :
				return Math.multiplyExact(firstNumber, secondNumber);
			case '/' :
				return Math.floorDiv(firstNumber, secondNumber);
			case '%' :
				return Math.floorMod(firstNumber, secondNumber);
			case '^' :
				return (int) Math.pow(firstNumber, secondNumber);
			default :
				return 0;
		}
	}

	private void prepareMathOperation() {
		String[] splitMathExpression = mathExpression.split(" ");
		firstNumber = Integer.parseInt(splitMathExpression[0]);
		secondNumber = Integer.parseInt(splitMathExpression[2]);
		mathOperation = splitMathExpression[1].charAt(0);
	}
}