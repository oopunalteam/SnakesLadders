package Business;

import Data.Board;
import Data.Player;
import ui.UI;

public class GameEngine {

	//movement. ONLY for testing

	public static void movement (Player player, Board board) {
		int move = UI.askMovement();


		/*
		public static void printMatrixCharZigZag(char array[][]) {
			System.out.println("Forma Zig-Zag - Matriz de caracteres");
			for (int row = 0, col = 0; row < array.length; row++, col++) {
				if (col % 2 == 0) {
					for (int column = 0; column < array[row].length; column++) {
						System.out.printf("%c, ", array[row][column]);
					}
				} else {
					for (int column = array[row].length-1; column >= 0; --column) {
						System.out.printf("%c, ", array[row][column]);
					}
				}
			}
			System.out.println();
		}
*/
		player.getPosition().setImage('0'); //Erase the token from past position

		for (int i = 0; i < move; i++) {

			//mod 8 para cambiar de fila
		}

		player.setPosition(board.getBoard()[move][move]);

		board.getBoard()[move][move].setImage(player.getToken());
	}



	public static void play (Player player, Board board) {

		player.setPosition(board.getBoard()[0][0]);

		board.getBoard()[0][0].setImage(player.getToken());

		UI.printBoard(board);

		boolean win = false;

		while (!win) {

			movement(player, board);

			UI.printBoard(board);

			win = checkWin(player, board);
		}
	}

	public static boolean checkWin (Player player, Board board) {
		if (player.getPosition() == board.getBoard()[board.getSize()-1][board.getSize()-1]) {
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

	public static void main (String[] args) {
		UI.menu();
		beginGame();
	}

}
