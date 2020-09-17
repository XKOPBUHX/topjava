package com.java_1_start.lesson_2_3.app;

public class Wolf {
	
	private String sex;
	private String nickname;
	private String color;
	private float weight;
	private int age;

	public void setSex(String sex) {
		if (sex != "Кобель" && sex != "Сука") {
			System.out.println("Не получилось установить пол '" + sex + "'! Пол может быть 'Кобель' или 'Сука'.");
			return;
		}
		this.sex = sex;
		System.out.println("Успешно установили новый пол '" + sex + "'.");
	}

	public String getSex() {
		return sex;
	}

	public void setNickname(String nickname) {
		if (nickname == "") {
			System.out.println("Не получилось установить пустую кличку!");
			return;
		}
		this.nickname = nickname;
		System.out.println("Успешно установили новую кличку '" + nickname + "'.");
	}

	public String getNickname() {
		return nickname;
	}

	public void setColor(String color) {
		if (color != "Белый" && color != "Серый") {
			System.out.println("Не получилось установить окрас '" + color + "'! Окрас может быть 'Белый' или 'Серый'.");
			return;
		}
		this.color = color;
		System.out.println("Успешно установили новый окрас '" + color + "'.");
	}

	public String getColor() {
		return color;
	}

	public void setWeight(float weight) {
		if (weight <= 0 || weight > 100) {
			System.out.println("Не получилось установить вес '" + weight + "'! Вес может быть от 0.1 до 100 кг.");
			return;
		}
		this.weight = weight;
		System.out.println("Успешно установили новый вес '" + weight + "'.");
	}

	public float getWeight() {
		return weight;
	}

	public void setAge(int age) {
		if (age < 0 || age > 8) {
			System.out.println("Не получилось установить возраст '" + age + "'! Возраст может быть от 0 до 8 лет.");
			return;
		}
		this.age = age;
		System.out.println("Успешно установили новый возраст '" + age + "'.");
	}

	public int getAge() {
		return age;
	}

	public void go() {
		System.out.println("Go-go-go!");
	}

	public void sit() {
		System.out.println("Место! Сидеть!");
	}

	public void run() {
		System.out.println("Беги!");
	}

	public void howl() {
		System.out.println("Аууууууууууууууууууууууууууууу!");
	}

	public void hunt() {
		System.out.println("Ату его! Ату!");
	}
}