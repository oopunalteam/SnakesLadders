package ui;

import Business.GamePlay;
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
		System.out.println(board);
	}

	public static void playerWins () {
		System.out.println("You win!");
	}


	//Request input

	public static void askRoll(Player player, Board board) {
		System.out.println("Roll dice?");
		String order = input.next();
		//Write feedback
		GamePlay.rollDice(player, board);
	}

	public static void turnFeedback(int move) {
		switch (move) {
			case 1:
				System.out.print("bummer");
				break;
			case 2:
				System.out.print("meh");
				break;
			case 3:
				System.out.print("ok");
				break;
			case 4:
				System.out.print("good");
				break;
			case 5:
				System.out.print("great");
				break;
			case 6:
				System.out.print("wow");
				break;
		}
		System.out.println(", you rolled a " + move);
	}

	public static void badFeedback () {
		System.out.println("Seleccione una opción valida");
		System.out.println();
	}


	/*Testing only
	public static int askMovement(Board board) {
		System.out.println("Select the square that you want to move to");
		int move = input.nextInt();
		if (move < 0 || move > board.getSize()) {
			badFeedback();
			askMovement(board);
		}
		return move;
	}
	*/
}
