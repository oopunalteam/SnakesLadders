package Data;

public class Square {

	private int row;
	private int col;
	private int index;
	private char image;


	public Square(int index, int row, int col, char image) {
		this.row = row;
		this.col = col;
		this.index = index;
		this.image = image;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public char getImage() {
		return image;
	}

	public void setImage(char image) {
		this.image = image;
	}

}
