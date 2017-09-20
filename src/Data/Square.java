package Data;

public class Square {

	private int row;
	private int col;
	private char image;


	public Square(int row, int col, char image) {
		this.row = row;
		this.col = col;
		this.image = image;
	}

	public char getImage() {
		return image;
	}

	public void setImage(char image) {
		this.image = image;
	}

}
