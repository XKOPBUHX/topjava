package com.java_1_start.lesson_1.game;

public class MyFirstGame {
	
	public static void main(String[] args) {
		int hiddenNumber = 80;
		int playerNumber = 90;

		while (hiddenNumber != playerNumber) {
			if (hiddenNumber > playerNumber) {
				System.out.println("Ваше число " + playerNumber + " меньше того, что загадал компьютер!");
				playerNumber++;
			} else {
				System.out.println("Ваше число " + playerNumber + " больше того, что загадал компьютер!");
				playerNumber--;
			}
		}
		System.out.println("Ваше число " + playerNumber + ". Вы угадали загаданное компьютером число!");
	}
}