package ui;

import java.util.Scanner;

public class UI {

	private static Scanner input = new Scanner(System.in);

	public static void menu () {
		//Menu text
		System.out.println("Snakes & Ladders");
		System.out.println();

		System.out.println("1. Play");
		System.out.println("2. Instructions");

		int select = input.nextInt();

		switch (select) {
			case 1:
				break;

			case 2:
				System.out.println("Instructions:");
				System.out.println("Snakes & Ladders...");
				System.out.println();
				break;

			default:
				badFeedback();
				System.out.println();
				menu();
		}
	}

	public static int selectDifficulty () {
		//Difficulty text

		int difficulty = 0;

		System.out.println("Seleccione la dificultad");
		System.out.println("1: 8x8");
		System.out.println("2. 10x10");
		System.out.println("3. 12x12");


		int select = input.nextInt();
		switch (select) {
			case 1:
				difficulty = 8;
				break;
			case 2:
				difficulty = 8;
				break;
			case 3:
				difficulty = 8;
				break;
			default:
				badFeedback();
				selectDifficulty();
		}
		return difficulty;
	}

	public static String badFeedback () {
		return "Seleccione una opción valida";
	}
}
