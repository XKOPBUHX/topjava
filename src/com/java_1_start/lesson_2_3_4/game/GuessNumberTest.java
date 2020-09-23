package com.java_1_start.lesson_2_3_4.game;

import java.util.Scanner;

public class GuessNumberTest {

	private static Scanner scanner;

	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		Player player1 = setNewPlayer(true);
		Player player2 = setNewPlayer(false);
		do {
			GuessNumber game = new GuessNumber(player1, player2);
			game.run();
		} while (!isEndGame());
	}

	private static Player setNewPlayer(boolean isFirstPlayer) {
		System.out.print("Введите имя " + (isFirstPlayer ? "первого" : "второго") + " игрока: ");
		String namePlayer = scanner.nextLine();
		return new Player(namePlayer);
	}

	private static boolean isEndGame() {
		System.out.println();
		String response;
		do {
			System.out.print("Хотите продолжить?[да/нет]: ");
			response = scanner.nextLine();
		} while (!response.equals("да") && !response.equals("нет"));
		return response.equals("нет");
	}
}