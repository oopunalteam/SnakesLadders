package Data;

public class Square {

	private int index;
	private String image;


	public Square(int index, String image) {
		this.index = index;
		this.image = image;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return image;
	}
}
