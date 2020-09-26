package com.java_1_start.lesson_2_3_4.game;

import java.util.Arrays;

public class Player {
	
	private final String name;
	private final int[] numbers;

	public Player(String name) {
		this.name = name;
		numbers = new int[10];
	}

	public String getName() {
		return name;
	}

	public int[] getNumbers() {
		return Arrays.copyOf(numbers, numbers.length);
	}

	public void setNumber(int number, int numberMove) {
		if (number < 0 || number > 100) {
			System.out.println("Необходимо вводить число от 0 до 100!");
		}
		numbers[numberMove - 1] = number;
	}

	public void clearNumbers(int numberMove) {
		Arrays.fill(numbers, 0, numberMove, 0);
	}

	public int getNumberByIndex(int index) {
		return numbers[index];
	}
}