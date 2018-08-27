package gameoflife;

public class Cell {

	private int xCoordinate;
	private int yCoordinate;
	private boolean isAlive;

	public Cell(boolean isAlive, int xCoordinate, int yCoordinate) {
		this.xCoordinate = xCoordinate;
		this.setyCoordinate(yCoordinate);
		this.isAlive = isAlive;
	}

	public int getxCoordinate() {
		return xCoordinate;
	}

	public void setxCoordinate(int xCoordinate) {
		this.xCoordinate = xCoordinate;
	}

	public boolean isAlive() {
		return isAlive;
	}

	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

	public int getyCoordinate() {
		return yCoordinate;
	}

	public void setyCoordinate(int yCoordinate) {
		this.yCoordinate = yCoordinate;
	}
}
