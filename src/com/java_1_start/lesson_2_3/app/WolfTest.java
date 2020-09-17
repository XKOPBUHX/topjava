package com.java_1_start.lesson_2_3.app;

public class WolfTest {
	
	public static void main(String[] args) {
		Wolf wolf = new Wolf();
		System.out.println("\n===СЕТТЕРЫ===");
		wolf.setSex("");
		wolf.setSex("тест");
		wolf.setSex("Кобель");
		wolf.setNickname("Пуся");
		wolf.setColor("Розовый");
		wolf.setColor("Серый");
		wolf.setWeight(-10f);
		wolf.setWeight(0);
		wolf.setWeight(4);
		wolf.setWeight(50.789f);
		wolf.setWeight(150f);
		wolf.setAge(12);
		wolf.setAge(-2);
		wolf.setAge(0);
		wolf.setAge(7);
		
		System.out.println("\n===ГЕТТЕРЫ===");
		System.out.println("sex: " + wolf.getSex());
		System.out.println("nickname: " + wolf.getNickname());
		System.out.println("color: " + wolf.getColor());
		System.out.println("weight: " + wolf.getWeight());
		System.out.println("age: " + wolf.getAge());
		
		System.out.println("\n===МЕТОДЫ===");
		wolf.howl();
		wolf.go();
		wolf.run();
		wolf.hunt();
		wolf.sit();
	}
}