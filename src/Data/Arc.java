package Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Arc {

	private Square entrance;
	private Square exit;
	private String image;

	public Arc(int index, Board board, int entrance, int exit) {
		this.entrance = board.getBoard()[entrance];
		this.exit = board.getBoard()[exit];

		if (entrance > exit) {			//Snake
			this.image = " S";
		} else if (entrance < exit) {	//Ladder
			this.image  = " L";
		}
		this.image = this.image + String.valueOf(index);
	}

	public Square getExit() {
		return exit;
	}

	public static void setArcs(Board board) {
		Random random = new Random();

		int numberDoors = random.nextInt(board.getSize()/2) + 2;

		ArrayList<Integer> doors = new ArrayList<>(numberDoors);
		for (int i = 0; i < board.getSize(); i++) {
			doors.add(i);
		}
		Collections.shuffle(doors);

		for (int j = 0, l = 1; j < numberDoors; j+= 2, l++) {
			Arc arc = new Arc(l, board, doors.get(j), doors.get(j+1));
			board.getBoard()[doors.get(j)].setArc(arc);
			board.getBoard()[doors.get(j+1)].setArc(arc);
		}

		//Print. ONLY for testing
		for (int k = 0, l = 1; k < numberDoors; k+=2, l++) {
			System.out.println(l +": "+ String.valueOf(doors.get(k)+1) + ", "+ String.valueOf(doors.get(k+1)+1));
		}
	}

	public static void hasArc(Player player) {
		if (player.getPosition().getArc() != null) {
			//Erase the player token
			player.getPosition().setImage(String.valueOf(player.getPosition().getIndex()) + player.getPosition().getArc());
			//set new position
			player.setPosition(player.getPosition().getArc().getExit());
		}
	}

	@Override
	public String toString() {
		return image;
	}
}
