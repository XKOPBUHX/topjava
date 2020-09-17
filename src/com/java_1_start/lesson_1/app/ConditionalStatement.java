package com.java_1_start.lesson_1.app;

public class ConditionalStatement {
	
	public static void main(String[] args) {
		int age = 32;
		if (age > 20) {
			System.out.println("Вы уже старый!");
		}

		boolean isMan = true;
		if (isMan) {
			System.out.println("Вы мужик!");
		}
		if (!isMan) {
			System.out.println("Упс, Вы не мужик!");
		}

		float height = 1.66f;
		if (height < 1.8f) {
			System.out.println("Вы гном!");
		} else {
			System.out.println("У Вас нормальный рост!");
		}

		char firstLetterName = 'А';
		if (firstLetterName == 'М') {
			System.out.println("Вы, наверное, Максим?");
		} else if (firstLetterName == 'И') {
			System.out.println("Может, Вы Ира?");
		} else {
			System.out.println("Да кто же Вы такой?");
		}
	}
}