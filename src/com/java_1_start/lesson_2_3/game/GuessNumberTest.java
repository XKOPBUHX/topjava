package com.java_1_start.lesson_2_3.game;

import java.util.Scanner;

public class GuessNumberTest {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in, "Cp866");
		System.out.print("Введите имя первого игрока: ");
		Player player1 = new Player(scanner.nextLine());
		System.out.print("Введите имя второго игрока: ");
		Player player2 = new Player(scanner.nextLine());
		
		GuessNumber game = new GuessNumber(player1, player2);		
		do {
			game.run();
		} while (!isEndGame(scanner));
	}

	private static boolean isEndGame(Scanner scanner) {
		String response = "";
		while (!response.equals("да") && !response.equals("нет")) {
			System.out.print("Хотите продолжить?[да/нет]: ");
			response = scanner.next();
		}
		return response.equals("нет");
	}
}