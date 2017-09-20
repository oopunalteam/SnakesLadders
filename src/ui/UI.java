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
				board.setSize((int) Math.pow(8,2));
				break;
			case 2:
				board.setSize((int) Math.pow(10,2));
				break;
			case 3:
				board.setSize((int) Math.pow(12,2));
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
		int l = (int) Math.sqrt(board.getBoard().length);
		System.out.print("| ");
		for (int i = board.getBoard().length -1; i >= 0; --i) {
			System.out.print(board.getBoard()[i] + " | ");
			if (i % l == 0 && i!= 0) {
				System.out.println();
				System.out.print("| ");
			}
		}
		System.out.println();
	}

	public static int askMovement() {
		return input.nextInt();
	}

	public static void badFeedback () {
		System.out.println("Seleccione una opción valida");
		System.out.println();
	}
}
