package Data;

public class Square {

	private int index;
	private String image;
	private Arc arc;

	public Square(int index) {
		this.index = index;
		this.image = Integer.toString(index);
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Arc getArc() {
		return arc;
	}

	public void setArc(Arc arc) {
		this.arc = arc;
		//this.image = this.image + arc;
	}

	@Override
	public String toString() {
		if(arc!=null) {
			return image+arc;
		}
		return image;
	}
}
