package Business;

import Data.Board;
import Data.Player;
import ui.UI;

public class GameEngine {

	public static void main (String[] args) {
		//main

		int difficulty = UI.askSize();

		Board board = new Board(difficulty);

		Player player = new Player(board.getBoard()[0][0]);

		UI.askToken(player);

		UI.printBoard(board);

	}

}
