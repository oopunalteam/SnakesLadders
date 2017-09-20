package Data;

public class Board {

	private int size;
	private Square[] board;


	public void setSize(int size) {
		this.size = size;
	}

	public void setBoard() {
		board = new Square[size];
		for (int i = 1; i <= size; i++) {
				Square square = new Square(i, Integer.toString(i));
				board[i-1] = square;
		}
	}

	public Square[] getBoard() {
		return board;
	}

}
