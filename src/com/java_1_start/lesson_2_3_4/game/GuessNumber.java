package com.java_1_start.lesson_2_3_4.game;

import java.util.Scanner;

public class GuessNumber {
	
	private final int hiddenNumber;
	private final Player player1;
	private final Player player2;
	private final Scanner scanner;
	private int numberPlayer;
	private int numberMove;
	private boolean isWinner;

	public GuessNumber(Player player1, Player player2) {
		this.player1 = player1;
		this.player2 = player2;
		scanner = new Scanner(System.in);
		hiddenNumber = (int) (Math.random() * 101);
		numberMove = 1;
	}

	public void run() {
		System.out.println("\nУ каждого есть 10 попыток! Поехали!");
		while (!isWinner) {
			setNumber(player1);
			if (isWinner) {
				break;
			}
			setNumber(player2);
			if (isWinner || numberMove == 10) {
				break;
			}
			numberMove++;
		}
		if (!isWinner) {
			System.out.println("\nУвы, победителя нет - попытки закончились :(\n");
		}
		resultPlayer(player1);
		resultPlayer(player2);
	}

	private void setNumber(Player player) {
		System.out.print("\nХод " + numberMove + ". " + player.getName() + ", ваше число: ");
		numberPlayer = scanner.nextInt();
		player.setNumber(numberPlayer, numberMove);
		checkNumber(player);
	}

	private void checkNumber(Player player) {
		if (hiddenNumber == numberPlayer) {
			System.out.println("\nИгрок " + player.getName() + " угадал число " + hiddenNumber + " с " + numberMove + " попытки!\n");
			isWinner = true;
			return;
		}
		System.out.println("Ваше число " + numberPlayer + ((hiddenNumber > numberPlayer) ? " меньше " : " больше ") + "загаданного!");
		if (numberMove == 10) {
			System.out.println("У игрока " + player.getName() + " закончились попытки!");
		}
	}

	private void resultPlayer(Player player) {
		player.numbersToString(numberMove);
		player.clearNumbers(numberMove);
	}
}