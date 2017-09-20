package Business;

import Data.Board;
import Data.Player;
import ui.UI;

import java.util.Random;

public class GameMechanics {

	//movement. ONLY for testing
	public static void movement (Player player, Board board) {
		int move = UI.askMovement();

		//Erase the player token
		player.getPosition().setImage(String.valueOf(player.getPosition().getIndex()));

		//set new position
		player.setPosition(board.getBoard()[move - 1]);


	}

	public static int rollDice () {
		Random dice = new Random();
		return dice.nextInt(6);
	}

	public static boolean checkWin (Player player, Board board) {
		if (player.getPosition().getIndex() == board.getBoard().length) {
			UI.playerWins();
			return true;
		} else {
			return false;
		}
	}
}