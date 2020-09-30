package com.java_1_start.lesson_2_3_4.game;

import java.util.Arrays;

public class Player {

	private final String name;
	private final int[] numbers;
	private int movesNumber;

	public Player(String name) {
		this.name = name;
		numbers = new int[10];
	}

	public String getName() {
		return name;
	}

	public int[] getNumbers() {
		return Arrays.copyOf(numbers, movesNumber);
	}

	public int getMovesNumber() {
		return movesNumber;
	}

	public int getCurrentNumber() {
		return numbers[movesNumber - 1];
	}

	public void setCurrentNumber(int currentNumber) {
		if (currentNumber < 0 || currentNumber > 100) {
			System.out.println("Необходимо вводить число от 0 до 100!");
		}
		numbers[movesNumber] = currentNumber;
		movesNumber++;
	}

	public void clearMovesNumber() {
		movesNumber = 0;
	}

	public void clearNumbers() {
		Arrays.fill(numbers, 0, movesNumber, 0);
	}
}