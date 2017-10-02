package Data;

public class Board {


	private int size;
	private Square[] board;


	public  void setSize(int size) {
		this.size = size;
	}

	public int getSize() {
		return size;
	}

	public final void setBoard() {
		board = new Square[size];
		for (int i = 1; i <= size; i++) {
				Square square = new Square(i);
				board[i-1] = square;
		}
	}

	public Square[] getBoard() {
		return board;
	}

	@Override
	public String toString() {

		int sideLength = (int) Math.sqrt(this.getBoard().length);

		String printBoard = "| ";
		for (int i = this.getBoard().length -1; i >= 0; --i) {

			printBoard = printBoard.concat(this.getBoard()[i] + " | ");

			if (i % sideLength == 0 && i!= 0) {
				printBoard = printBoard.concat("\n| ");
			}
		}

		printBoard = printBoard.concat("\n");
		return printBoard;
	}
}