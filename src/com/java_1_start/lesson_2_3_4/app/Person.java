package com.java_1_start.lesson_2_3_4.app;

public class Person {
	
	String sex = "Man";
	String name = "Alexandr";
	float height = 1.67f;
	float weight = 90.1f;
	int age = 32;

	void move() {
		System.out.println("Я иду по улице, словно чумачечий :)");
	}

	void sit() {
		System.out.println("Я на ка-му-шке си-жу");
	}

	void run() {
		System.out.println("Беги, Лола, беги!");
	}

	String talk() {
		System.out.println("Скажи что-нибудь умное");
		return "Пивка бы...";
	}

	boolean learnJava() {
		System.out.println("Learn Java? Еще как learn!");
		return true;
	}
}