package ui;

import Data.Board;
import Data.Player;

import java.util.Scanner;

public class UI {

	private static Scanner input = new Scanner(System.in);


	//Setting the game
	public static void menu () {
		System.out.println("Snakes & Ladders");
		System.out.println("1. Play");
		System.out.println("2. Instructions");
		System.out.println("3. About");

		int select = input.nextInt();
		switch (select) {
			case 1:
				break;
			case 2:
				System.out.println("Instructions:");
				System.out.println("Snakes & Ladders...");
				menu();
				break;
			case 3:
				System.out.println("This game is an early version of a \ngroup proyect for OOP");
				menu();
				break;
			default:
				badFeedback();
				menu();
		}
	}

	public static void askSize(Board board) {
		System.out.println("Difficulty:");
		System.out.println("1: 8x8");
		System.out.println("2. 10x10");
		System.out.println("3. 12x12");

		int select = input.nextInt();
		switch (select) {
			case 1:
				board.setSize(8);
				break;
			case 2:
				board.setSize(10);
				break;
			case 3:
				board.setSize(12);
				break;
			default:
				badFeedback();
				askSize(board);
		}
	}

	public static void askToken(Player player) {
		System.out.println("Select your token");

		char token = input.next().charAt(0);

		if ((64 < token && token < 91) || (96 < token && token < 123)) {
			player.setToken(token);
			System.out.println("You selected the token: " + token);
			System.out.println();
		} else {
			badFeedback();
			askToken(player);
		}
	}


	//Printing the game
	public static void printBoard(Board board) {

		for (int row = 0; row < board.getBoard().length; row++) {
			System.out.print("| ");
			for (int col = 0; col < board.getBoard().length; col++) {
				System.out.printf(board.getBoard()[row][col].getImage() + " | ");
			}
			System.out.println();
		}
	}

	public static int askMovement() {
		return input.nextInt();
	}

	public static void badFeedback () {
		System.out.println("Seleccione una opción valida");
		System.out.println();
	}
}
