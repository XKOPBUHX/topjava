package com.java_1_start.lesson_2_3.game;

public class Player {
	
	private String name;
	private int number;

	public Player(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		if (number < 0 || number > 100) {
			System.out.println("Необходимо вводить число от 0 до 100!");
		}
		this.number = number;
	}
}