package com.java_1_start.lesson_2_3_4.game;

import java.util.Scanner;

public class GuessNumberTest {

	private static Scanner scanner;

	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		Player player1 = createPlayer(1);
		Player player2 = createPlayer(2);
		do {
			GuessNumber game = new GuessNumber(player1, player2);
			game.run();
		} while (isNext());
	}

	private static Player createPlayer(int numberPlayer) {
		System.out.print("Введите имя " + numberPlayer + " игрока: ");
		return new Player(scanner.nextLine());
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