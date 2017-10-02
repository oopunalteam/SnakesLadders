package Business;

import Data.Board;
import Data.Player;
import ui.UI;



public class GamePlay {

	public static void play (Player player, Board board) {

		boolean win = false;

		while (!win) {

			//GameMechanics.movement(player, board);

			GameMechanics.rollDice(player, board);

			UI.printBoard(board);

			win = GameMechanics.checkWin(player, board);
		}
	}

	public static void beginGame() {

		Board board = new Board();
		Player player = new Player();

		UI.askSize(board);
		UI.askToken(player);

		/*Test
		board.setSize(64);
		player.setToken('a');
		*/

		board.setBoard();

		GameMechanics.fillArcs(board);

		player.setPosition(board.getBoard()[0]);

		UI.printBoard(board);

		play(player, board);
	}

	public static void main (String[] args) {
		UI.menu();
		beginGame();
	}
}