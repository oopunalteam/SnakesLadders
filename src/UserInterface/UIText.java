package UserInterface;
import Data.Board;
import Data.Player;

import java.util.Scanner;

public class UIText implements UI {

	private Scanner input = new Scanner(System.in);

	//Setting the game
	@Override
	public void menu () {
		System.out.println("Snakes & Ladders" + "\n 1. Play" +"\n 2. Instructions" + "\n 3. About");

		int select = input.nextInt();
		switch (select) {
			case 1:
				System.out.println("PLAY");
				break;
			case 2:
				System.out.println("Instructions:");
				System.out.println("Write something to roll the dice");
				this.menu();
				break;
			case 3:
				System.out.println("This game is an early version of a \ngroup proyect for OOP");
				this.menu();
				break;
			default:
				this.badFeedback();
				this.menu();
		}
	}

	@Override
	public int askSize() {
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
				this.badFeedback();
				size = this.askSize();
		}
		return size;
	}

	@Override
	public char askToken(int playerNum) {
		System.out.println("Player " + playerNum + ". select your token");

		char token = input.next().charAt(0);

		if ((64 < token && token < 91) || (96 < token && token < 123)) {
			System.out.println("You selected the token: " + token + "\n");
		} else {
			this.badFeedback();
			token = this.askToken(playerNum);
		}
		return token;
	}

	@Override
	public int askPlayerNum() {
		System.out.println("How many players are going to play?");
		return input.nextInt();
	}


	//Printing the game
	@Override
	public void printBoard(Board board) {
		System.out.println(board);
	}

	@Override
	public void playerWins () {
		System.out.println("You win!");
	}


	//Request input
	@Override
	public void askRoll(Player player) {
		System.out.println("Player "+ player +", roll dice?");
		String order = input.next();
	}


	//Feedback
	@Override
	public void turnFeedback(int move) {
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

	@Override
	public void arcFeedback (boolean good, int entry, int exit) {
		if (good) {
			System.out.println("You climbed a ladder! You moved from square "+ entry +" to square "+ exit);
		} else if (!good) {
			System.out.println("A snake attacked you! You moved from square "+ entry +" to square "+ exit);
		}

	}

	@Override
	public void badFeedback () {
		System.out.println("Select a valid option \n");
	}


	//Testing only
	@Override
	public int askMovement(Board board) {
		System.out.println("Select the square that you want to move to");
		int move = input.nextInt();
		if (move < 0 || move > board.getSize()) {
			badFeedback();
			askMovement(board);
		}
		return move;
	}
}
