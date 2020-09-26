package com.java_1_start.lesson_2_3_4.game;

import java.util.Arrays;
import java.util.Scanner;

public class GuessNumber {
	
	private final int hiddenNumber;
	private final Player player1;
	private final Player player2;
	private final Scanner scanner;
	private int numberPlayer;
	private int numberMove;

	public GuessNumber(Player player1, Player player2) {
		this.player1 = player1;
		this.player2 = player2;
		scanner = new Scanner(System.in);
		hiddenNumber = (int) (Math.random() * 101);
		numberMove = 1;
	}

	public void run() {
		System.out.println("\nУ каждого есть 10 попыток! Поехали!");
		while (makeMove()) {
			numberMove++;
		}
		showPlayersNumbers();
		clearPlayersNumbers();
	}

	private boolean makeMove() {
		if (numberMove > 10 || !makeMovePlayer(player1)) {
			return false;
		}
		return makeMovePlayer(player2);
	}

	private boolean makeMovePlayer(Player player) {
		inputNumber(player);
		boolean numberGuessed = checkNumber(player);
		if (numberMove == 10) {
			System.out.println("У игрока " + player.getName() + " закончились попытки!");
		}
		return !numberGuessed;
	}

	private void inputNumber(Player player) {
		System.out.print("\nХод " + numberMove + ". " + player.getName() + ", ваше число: ");
		numberPlayer = scanner.nextInt();
		player.setNumber(numberPlayer, numberMove);
	}

	private boolean checkNumber(Player player) {
		if (hiddenNumber == numberPlayer) {
			System.out.println("\nИгрок " + player.getName() + " угадал число " + hiddenNumber + " с " + numberMove + " попытки!");
			return true;
		}
		System.out.println("Ваше число " + numberPlayer + ((hiddenNumber > numberPlayer) ? " меньше " : " больше ") + "загаданного!");
		return false;
	}

	private void showPlayersNumbers() {
		System.out.println();
		showPlayerNumbers(player1);
		showPlayerNumbers(player2);
	}

	private void showPlayerNumbers(Player player) {
		checkNumberMove(player);
		int[] numbersCopy = Arrays.copyOf(player.getNumbers(), numberMove);
		System.out.println("Числа игрока " + player.getName() + ": " + Arrays.toString(numbersCopy));
	}

	private void checkNumberMove(Player player) {
		if (numberMove > 10) {
			numberMove = 10;
		}
		if (player.getNumberByIndex(numberMove - 1) == 0) {
			numberMove--;
		}
	}

	private void clearPlayersNumbers() {
		player1.clearNumbers(numberMove);
		player2.clearNumbers(numberMove);
	}
}