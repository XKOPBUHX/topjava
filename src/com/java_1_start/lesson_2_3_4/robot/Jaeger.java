package com.java_1_start.lesson_2_3_4.robot;

public class Jaeger {
	
	private String modelName;
	private float height;
	private float weight;
	private int mark;
	
	public Jaeger() {
		
	}

	public Jaeger(String modelName) {
		this.modelName = modelName;
	}

	public Jaeger(String modelName, float height, float weight) {
		this.modelName = modelName;
		this.height = height;
		this.weight = weight;
	}

	public Jaeger(String modelName, float height, float weight, int mark) {
		this.modelName = modelName;
		this.height = height;
		this.weight = weight;
		this.mark = mark;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		if (modelName.isEmpty()) {
			System.out.println("Не могу установить новое значение modelName! Передана пустая строка!");
			return;	
		}
		this.modelName = modelName;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public int getMark() {
		return mark;
	}

	public void setMark(int mark) {
		this.mark = mark;
	}	

	public boolean drift() {
		System.out.println("Вы вошли в дрифт!");
		return true;
	}

	public void move() {
		System.out.println("Вы прошли 5 шагов!");
	}

	public String scanKaiju() {
		return "nothing";
	}

	public void jump() {
		System.out.println("Прыг-скок!");
	}

	@Override
	public String toString()
	{
		return "Модель: " + modelName + "\nСерия: " + mark + "\nРост: " + height + "\nВес: " + weight;
	}
}