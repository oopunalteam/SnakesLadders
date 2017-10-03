package Business;

import Data.Arc;
import Data.Board;
import Data.Player;
import ui.UI;

import java.util.Random;


public class GamePlay {

	private static Random random = new Random();

	public static void main (String[] args) {
		int select=UI.menu();
		while(select!=1) {
			switch (select) {
				case 2:
					System.out.println("Instructions:");
					System.out.println("Snakes & Ladders...");
					select = UI.menu();
					break;
				case 3:
					System.out.println("This game is an early version of a \ngroup proyect for OOP");
					select = UI.menu();
					break;
				default:
					UI.badFeedback();
					select = UI.menu();
			}
		}

		beginGame();
	}

	public static void beginGame() {

		Board board = new Board();
		Player player = new Player();

		int select=UI.askSize(board);
		boolean flag=true;
		while(flag) {
			switch (select) {
				case 1:
					board.setSize((int) Math.pow(8, 2));
					flag=false;
					break;
				case 2:
					board.setSize((int) Math.pow(10, 2));
					flag=false;
					break;
				case 3:
					board.setSize((int) Math.pow(12, 2));
					flag=false;
					break;
				default:
					UI.badFeedback();
					select=UI.askSize(board);
			}
		}

		char token=UI.askToken(player);
        flag=true;
        while(flag) {
            if ((64 < token && token < 91) || (96 < token && token < 123)) {
                player.setToken(token);
                System.out.println("You selected the token: " + token);
                System.out.println();
                flag=false;
            }
            else {
                UI.badFeedback();
                token=UI.askToken(player);
            }
        }


		/*Testing only
		board.setSize(64);
		player.setToken('a');
		*/

		board.setBoard();

		Arc.setArcs(board);

		player.setPosition(board.getBoard()[0]);

		UI.printBoard(board);

		play(player, board);
	}

	public static void play (Player player, Board board) {

		boolean win = false;

		while (!win) {
			/* Testing only
			movement(player, board);
			*/

			UI.askRoll(player, board);

			rollDice(player, board);

			Arc.hasArc(player);

			UI.printBoard(board);

			win = checkWin(player, board);
		}
	}

	/*Testing only
	public static void movement (Player player, Board board) {
		int move = UI.askMovement(board);
		//Erase the player token
		player.getPosition().setImage(String.valueOf(player.getPosition().getIndex()));
		//set new position
		player.setPosition(board.getBoard()[move - 1]);
	}
	*/

	public static void rollDice (Player player, Board board) {

		int move = random.nextInt(5) + 1;
		//Erase the player token
		player.getPosition().setImage(String.valueOf(player.getPosition().getIndex()));
		//set new position
		if((player.getPosition().getIndex()+move-1)>board.getBoard().length) {
			player.setPosition(board.getBoard()[board.getBoard().length - 1]);
		}
		else {
			player.setPosition(board.getBoard()[player.getPosition().getIndex() + move - 1]);
		}

		UI.turnFeedback(move);
	}

	public static boolean checkWin (Player player, Board board) {
		if (player.getPosition().getIndex() >= board.getBoard().length) {
			UI.playerWins();
			return true;
		} else {
			return false;
		}
	}

}