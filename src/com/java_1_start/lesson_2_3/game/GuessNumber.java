package com.java_1_start.lesson_2_3.game;

import java.util.Scanner;

public class GuessNumber {
	
	private int hiddenNumber;
	private Player player1;
	private Player player2;

	public GuessNumber(Player player1, Player player2) {
		this.player1 = player1;
		this.player2 = player2;
	}

	public void run() {
		Scanner scanner = new Scanner(System.in, "Cp866");
		setHiddenNumber();
		while (true) {
			setNumber(player1, scanner);
			if (equalNumbers(player1.getNumber())) {
				break;
			}
			setNumber(player2, scanner);
			if (equalNumbers(player2.getNumber())) {
				break;
			}	
		}
	}

	private void setHiddenNumber() {
		hiddenNumber = (int) (Math.random() * 101);
	}
	
	private void setNumber(Player player, Scanner scanner) {
		System.out.print("\n" + player.getName() + ", ваше число: ");
		player.setNumber(scanner.nextInt());
	}

	private boolean equalNumbers(int playerNumber) {
		if (hiddenNumber == playerNumber) {
			System.out.println("Победа! Вы угадали! Загаданное число: " + hiddenNumber);
			return true;
		}
		System.out.println("Ваше число " + playerNumber + ((hiddenNumber > playerNumber) ? " меньше " : " больше ") + "загаданного!");
		return false;
	}
}