package Business;

import Data.Arc;
import Data.Board;
import Data.Player;
import ui.UI;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class GamePlay {

	private static Random random = new Random();

	public static void main (String[] args) {
		UI.menu();
		beginGame();
	}

	public static void beginGame() {

		int selectSize = UI.askSize();
		Board board = new Board(selectSize);

		char selectToken = UI.askToken();
		Player player = new Player(selectToken);

		/*Testing only
		Board board = new Board(64);
		Player player = new Player('A');
		*/

		setArcs(board);

		player.setPosition(board.getBoard()[0]);

		UI.printBoard(board);

		play(player, board);
	}

	public static void play (Player player, Board board) {

		boolean win = false;

		while (!win) {

			UI.askRoll();
			rollDice(player, board);

			// Testing only
			//movement(player, board);

			arcMovement(player);

			UI.printBoard(board);

			win = checkWin(player, board);
		}
	}

	/*Testing only
	public static void movement (Player player, Board board) {
		int move = UI.askMovement(board) - 1;
		//Erase the player token
		//player.getPosition().setImage(Integer.toString(player.getPosition().getIndex()));
		//Winning move
		if((move) > board.getBoard().length) {
			player.setPosition(board.getBoard()[board.getBoard().length - 1]);
		} else {
			//set new position
			player.setPosition(board.getBoard()[move]);
		}
	}
	*/

	public static void rollDice (Player player, Board board) {

		int move = random.nextInt(5) + 1;

		//Winning move
		if( (player.getPosition().getIndex()+ move - 1) > board.getBoard().length ) {
			player.setPosition(board.getBoard()[board.getBoard().length - 1]);
		} else {
			//set new position
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


	public static void setArcs(Board board) {
		//create collection of random numbers
		int numberDoors = random.nextInt(board.getSize()/2) + 2;

		ArrayList<Integer> doors = new ArrayList<>(numberDoors);
		for (int i = 0; i < board.getSize(); i++) {
			doors.add(i);
		}
		Collections.shuffle(doors);

		//
		int entry, exit;
		for (int j = 0, l = 1; j < numberDoors; j+= 2, l++) {
			entry = j;
			exit = j+1;
			Arc arc = new Arc(l, board, doors.get(entry), doors.get(exit));

			board.getBoard()[doors.get(entry)].setArc(arc);

			board.getBoard()[doors.get(exit)].setArc(arc);
		}

		//Print. ONLY for testing
		for (int k = 0, l = 1; k < numberDoors; k+=2, l++) {
			System.out.println(l +": "+ String.valueOf(doors.get(k)+1) + ", "+ String.valueOf(doors.get(k+1)+1));
		}
	}

	public static void arcMovement(Player player) {
		if (player.getPosition().getArc() != null) {

			int entry = player.getPosition().getIndex();
			int exit = player.getPosition().getArc().getExit().getIndex();

			//Feedback
			if (entry < exit) {
				UI.arcFeedback(true, entry, exit);
			} else if (entry > exit) {
				UI.arcFeedback(false, entry, exit);
			}
			//set new position
			player.setPosition(player.getPosition().getArc().getExit());
		}
	}
}