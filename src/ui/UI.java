package ui;

import Data.Board;

import java.util.Scanner;

public class UI {

	private static Scanner input = new Scanner(System.in);

	//Setting the game
	public static void menu () {
		System.out.println("Snakes & Ladders" + "\n 1. Play" +"\n 2. Instructions" + "\n 3. About");

		int select = input.nextInt();
		switch (select) {
			case 1:
				System.out.println("PLAY");
				break;
			case 2:
				System.out.println("Instructions:");
				System.out.println("Write something to roll the dice");
				UI.menu();
				break;
			case 3:
				System.out.println("This game is an early version of a \ngroup proyect for OOP");
				UI.menu();
				break;
			default:
				UI.badFeedback();
				UI.menu();
		}
	}

	public static int askSize() {
		System.out.println("Difficulty:" + "\n 1: 8x8" + "\n 2. 10x10 " + "\n 3. 12x12");

		int size;
		int select = input.nextInt();
		switch (select) {
			case 1:
				size = (int) Math.pow(8, 2);
				break;
			case 2:
				size = (int) Math.pow(10, 2);
				break;
			case 3:
				size = (int) Math.pow(12, 2);
				break;
			default:
				UI.badFeedback();
				size = UI.askSize();
		}
		return size;
	}

	public static char askToken() {
		System.out.println("Select your token");

		char token = input.next().charAt(0);

		if ((64 < token && token < 91) || (96 < token && token < 123)) {
			System.out.println("You selected the token: " + token);
		} else {
			UI.badFeedback();
			token = UI.askToken();
		}
		return token;
	}


	//Printing the game
	public static void printBoard(Board board) {
		System.out.println(board);
	}

	public static void playerWins () {
		System.out.println("You win!");
	}


	//Request input
	public static void askRoll() {
		System.out.println("Roll dice?");
		String order = input.next();
	}


	//Feedback
	public static void turnFeedback(int move) {
		switch (move) {
			case 1:
				System.out.print("Bummer");
				break;
			case 2:
				System.out.print("Meh");
				break;
			case 3:
				System.out.print("Ok");
				break;
			case 4:
				System.out.print("Good");
				break;
			case 5:
				System.out.print("Great");
				break;
			case 6:
				System.out.print("WOW");
				break;
		}
		System.out.println(", you rolled a " + move);
	}

	public static void arcFeedback (boolean good, int entry, int exit) {
		if (good) {
			System.out.println("You climbed a ladder! You moved from square "+ entry +" to square "+ exit);
		} else if (!good) {
			System.out.println("A snake attacked you! You moved from square "+ entry +" to square "+ exit);
		}

	}

	public static void badFeedback () {
		System.out.println("Seleccione una opción valida \n");
	}

	//Testing only
	public static int askMovement(Board board) {
		System.out.println("Select the square that you want to move to");
		int move = input.nextInt();
		if (move < 0 || move > board.getSize()) {
			badFeedback();
			askMovement(board);
		}
		return move;
	}

}
