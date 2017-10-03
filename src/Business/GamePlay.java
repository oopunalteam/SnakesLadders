package Business;

import Data.Arc;
import Data.Board;
import Data.Player;
import ui.UI;

import java.util.Random;


public class GamePlay {

	private static Random random = new Random();

	public static void main (String[] args) {
		UI.menu();
		beginGame();
	}

	public static void beginGame() {

		Board board = new Board();
		Player player = new Player();

		UI.askSize(board);
		UI.askToken(player);

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
		player.setPosition(board.getBoard()[player.getPosition().getIndex() + move - 1]);

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