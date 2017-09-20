package Data;

public class Player {

	private char token;
	private Square position;


	public Player (Square firstSquare) {
		this.position = firstSquare;
	}

	public char getToken() {
		return token;
	}

	public void setToken(char token) {
		this.token = token;
	}

	public Square getPosition() {
		return position;
	}

	public void setPosition(Square position) {
		this.position = position;
	}
}
