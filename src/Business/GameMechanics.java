package Business;

import Data.Board;
import Data.Player;
import Data.Arc;
import ui.UI;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class GameMechanics {

	static Random random = new Random();

	//Testing only
	public static void movement (Player player, Board board) {
		int move = UI.askMovement(board);
		//Erase the player token
		player.getPosition().setImage(String.valueOf(player.getPosition().getIndex()));
		//set new position
		player.setPosition(board.getBoard()[move - 1]);

		GameMechanics.checkArcs(player);
	}

	public static void rollDice (Player player, Board board) {
		UI.askRoll();

		int move = random.nextInt(5) + 1;
		//Erase the player token
		player.getPosition().setImage(String.valueOf(player.getPosition().getIndex()));
		//set new position
		player.setPosition(board.getBoard()[player.getPosition().getIndex() + move - 1]);

		UI.turnFeedback(move);

		checkArcs(player);
	}

	public static void fillArcs(Board board) {
		Random random = new Random();

		int numberDoors = random.nextInt(board.getSize()/2) + 2;

		ArrayList<Integer> doors = new ArrayList<>(numberDoors);
		for (int i = 0; i < board.getSize(); i++) {
			doors.add(i);
		}
		Collections.shuffle(doors);

		//Print. ONLY for testing
		for (int k = 0; k < numberDoors; k+=2) {
			System.out.println(k +": "+ String.valueOf(doors.get(k)+1) + ", "+ String.valueOf(doors.get(k+1)+1));
		}

		for (int j = 0; j < numberDoors; j+= 2) {
			Arc arc = new Arc(j+1,board, doors.get(j), doors.get(j+1));
			board.getBoard()[doors.get(j)].setArc(arc);
			board.getBoard()[doors.get(j+1)].setArc(arc);
		}
	}

	public static void checkArcs (Player player) {
		//Erase the player token
		player.getPosition().setImage(String.valueOf(player.getPosition().getIndex()) + player.getPosition().getArc());

		//set new position
		if (player.getPosition().getArc() != null) {
			player.setPosition(player.getPosition().getArc().getExit());
		}
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
