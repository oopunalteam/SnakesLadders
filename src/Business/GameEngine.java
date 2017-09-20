package Business;

import Data.Board;
import Data.Player;
import ui.UI;
import java.util.Random;

public class GameEngine {

	//movement. ONLY for testing

	public static void movement (Player player, Board board) {
		int move = UI.askMovement();

		player.getPosition().setImage( String.valueOf(player.getPosition().getIndex()) );

		player.setPosition(board.getBoard()[player.getPosition().getIndex()-2 + move]);

		board.getBoard()[player.getPosition().getIndex()].setImage(String.valueOf(player.getToken()));
	}


	

	public static void play (Player player, Board board) {

		player.setPosition(board.getBoard()[0]);

		board.getBoard()[0].setImage(String.valueOf(player.getToken()));

		UI.printBoard(board);

		boolean win = false;

		while (!win) {

			movement(player, board);

			UI.printBoard(board);

			win = checkWin(player, board);

		}
	}

	public static boolean checkWin (Player player, Board board) {
		if (player.getPosition().getIndex() == board.getBoard().length-1) {
			return true;
		} else {
			return false;
		}
	}

	public static void beginGame () {
		Board board = new Board();
		Player player = new Player();

		UI.askSize(board);
		UI.askToken(player);

		board.setBoard();

		play(player, board);
	}
	
	public static int crap(){
            int numero = (int) (Math.random() * 12) + 1;
            return numero;
        }

	public static void main (String[] args) {
		//UI.menu();
		beginGame();
	}

}
