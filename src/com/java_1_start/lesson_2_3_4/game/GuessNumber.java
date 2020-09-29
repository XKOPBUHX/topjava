package com.java_1_start.lesson_2_3_4.game;

import java.util.Scanner;

public class GuessNumber {

	private final int hiddenNumber;
	private final Player player1;
	private final Player player2;
	private final Scanner scanner;

	public GuessNumber(Player player1, Player player2) {
		this.player1 = player1;
		this.player1.initPlayer();
		this.player2 = player2;
		this.player2.initPlayer();
		scanner = new Scanner(System.in);
		hiddenNumber = (int) (Math.random() * 101);
	}

	public void run() {
		System.out.println("\nУ каждого есть 10 попыток! Поехали!");
		while (makeMove(player1) && makeMove(player2)) { }
		showPlayersNumbers();
		clearPlayersNumbers();
	}

	private boolean makeMove(Player player) {
		if (player.getMovesNumber() == 10) {
			return false;
		}
		inputNumber(player);
		boolean numberGuessed = checkNumber(player);
		if (player.getMovesNumber() == 10) {
			System.out.println("У игрока " + player.getName() + " закончились попытки!");
		}
		return !numberGuessed;
	}

	private void inputNumber(Player player) {
		System.out.print("\nХод " + (player.getMovesNumber() + 1) + ". " + player.getName() + ", ваше число: ");
		player.setCurrentNumber(scanner.nextInt());
	}

	private boolean checkNumber(Player player) {
		if (hiddenNumber == player.getCurrentNumber()) {
			System.out.println("\nИгрок " + player.getName() + " угадал число " + hiddenNumber + " с " + player.getMovesNumber() + " попытки!");
			return true;
		}
		System.out.println("Ваше число " + player.getCurrentNumber() + ((hiddenNumber > player.getCurrentNumber()) ? " меньше " : " больше ") + "загаданного!");
		return false;
	}

	private void showPlayersNumbers() {
		System.out.println();
		showNumbers(player1);
		showNumbers(player2);
	}

	private void showNumbers(Player player) {
		int[] numbersPlayer = player.getNumbers();
		System.out.print("Числа игрока " + player.getName() + ": ");
		for (int i = 0; i < numbersPlayer.length; i++) {
			System.out.print(numbersPlayer[i] + " ");
		}
		System.out.println();
	}

	private void clearPlayersNumbers() {
		player1.clearNumbers();
		player2.clearNumbers();
	}
}