package com.java_1_start.lesson_2_3_4.robot;

public class JaegerTest {
	
	public static void main(String[] args) {
		Jaeger jaegerOne = new Jaeger();
		jaegerOne.setModelName("Багровый Тайфун");
		jaegerOne.setMark(4);
		jaegerOne.setHeight(76f);
		jaegerOne.setWeight(1722f);
		System.out.println(jaegerOne);
		jaegerOne.jump();
		System.out.println();
				
		Jaeger jaegerTwo = new Jaeger("Черно Альфа");
		System.out.println(jaegerTwo.toString());
		jaegerTwo.setHeight(85f);
		System.out.println("Новый рост: " + jaegerTwo.getHeight());
		System.out.println(jaegerTwo);
		System.out.println();

		Jaeger jaegerThree = new Jaeger("Храбрый Горизонт", 72.5f, 7890f, 1);
		System.out.println(jaegerThree);
		System.out.println();
	}
}