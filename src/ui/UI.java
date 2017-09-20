package ui;

import Data.Board;
import Data.Player;

import java.util.Scanner;

public class UI {

	private static Scanner input = new Scanner(System.in);


	public static void badFeedback () {
		System.out.println("Seleccione una opción valida");
		System.out.println();
	}

	//Setting the game
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

	public static int askSize() {

		System.out.println("Difficulty:");
		System.out.println("1: 8x8");
		System.out.println("2. 10x10");
		System.out.println("3. 12x12");

		int size = 0;

		int select = input.nextInt();
		switch (select) {
			case 1:
				size = 8;
				break;
			case 2:
				size = 10;
				break;
			case 3:
				size = 12;
				break;
			default:
				badFeedback();
				askSize();
		}
		return size;
	}

	public static char convertUppercase (char letter) {
		int temp = (int) letter;
		temp = temp - 32;
		letter = (char) temp;
		return letter;
	}

	public static void askToken(Player player) {
		System.out.println("Select your token");

		char token = input.next().charAt(0);

		if (64 < token && token < 91) {
			player.setToken(token);
			System.out.println("You selected the token: " + token);
		} else if (96 < token && token < 123) {
			player.setToken(convertUppercase(token));
			System.out.println("You selected the token: " + token);
		} else {
			badFeedback();
			askToken(player);
		}
	}


	//Printing the game

	public static void printBoard(Board board) {

		for (int row = 0; row < board.getBoard().length; row++) {
			System.out.print("|");
			for (int col = 0; col < board.getBoard().length; col++) {
				System.out.printf(board.getBoard()[row][col].getImage() + "|");
			}
			System.out.println();
		}
	}

}
