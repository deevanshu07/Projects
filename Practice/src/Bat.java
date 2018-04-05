
public class Bat {
	
	private int height;
	private int noOfBats;
	private int weight;
	private int width;
	public Bat() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Bat(int noOfBats, int height, int width, int weight) {
		super();
		this.noOfBats = noOfBats;
		this.height = height;
		this.width = width;
		this.weight = weight;
	}
	public int getHeight() {
		return height;
	}
	public int getNoOfBats() {
		return noOfBats;
	}
	public int getWeight() {
		return weight;
	}
	public int getWidth() {
		return width;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public void setNoOfBats(int noOfBats) {
		this.noOfBats = noOfBats;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	@Override
	public String toString() {
		return "Bat [noOfBats=" + noOfBats + ", height=" + height + ", width="
				+ width + ", weight=" + weight + "]";
	}
	

}
