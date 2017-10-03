package ui;

import Business.GamePlay;
import Data.Board;
import Data.Player;

import java.util.Scanner;

public class UI {

	private static Scanner input = new Scanner(System.in);


	//Setting the game
	public static int menu () {
		System.out.println("Snakes & Ladders");
		System.out.println("1. Play");
		System.out.println("2. Instructions");
		System.out.println("3. About");

		int select = input.nextInt();
		return select;
	}

	public static int askSize(Board board) {
		System.out.println("Difficulty:");
		System.out.println("1: 8x8");
		System.out.println("2. 10x10");
		System.out.println("3. 12x12");

		int select = input.nextInt();
		return select;
	}

	public static char askToken(Player player) {
		System.out.println("Select your token");

		char token = input.next().charAt(0);
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

	public static void askRoll(Player player, Board board) {
		System.out.println("Roll dice?");
		String order = input.next();
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
