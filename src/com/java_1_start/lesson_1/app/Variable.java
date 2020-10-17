package com.java_1_start.lesson_1.app;

public class Variable {
	
	public static void main(String[] args) {
		// CPU
		char cpuName = 'i';
		byte cpuCoresNumber = 4;
		float cpuFrequency = 3.4f;

		// RAM
		short ramCapacity = 16;
		double ramFrequency = 1600d;

		// Other
		int windowsVersion = 10;
		long monitorDiagonal = 27L;
		boolean isSsd = true;

		// Output
		System.out.println("Процессор: " + cpuName + "5 @ " + cpuFrequency + "GHz (" + cpuCoresNumber + " ядра).");
		System.out.println("Память: " + ramCapacity + "Gb @ " + ramFrequency + "MHz.");
		System.out.println("Есть SSD: " + isSsd + ".");
		System.out.println("Диагональ монитора: " + monitorDiagonal + "'.");
		System.out.println("ОС: Windows " + windowsVersion + " Pro.");
	}
}