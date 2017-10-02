package Data;

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

	public Square getEntrance() {
		return entrance;
	}
	public Square getExit() {
		return exit;
	}

	@Override
	public String toString() {
		return image;
	}
}
