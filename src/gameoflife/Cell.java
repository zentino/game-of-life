package gameoflife;

public class Cell {

	private int xCoordinate;
	private int yCoordinate;
	private boolean isAlive;
	private boolean isAliveNextGen;
	private int neighbours;

	public Cell(boolean isAlive) {
		this.isAlive = isAlive;
		this.isAliveNextGen = false;
		this.neighbours = 0;
	}

	public int getxCoordinate() { return xCoordinate; }

	public void setxCoordinate(int xCoordinate) { this.xCoordinate = xCoordinate; }

	public boolean isAlive() { return isAlive; }

	public void setAlive(boolean isAlive) { this.isAlive = isAlive; }

	public int getyCoordinate() { return yCoordinate; }

	public void setyCoordinate(int yCoordinate) { this.yCoordinate = yCoordinate; }

	public boolean isAliveNextGen() { return isAliveNextGen; }

	public void setAliveNextGen(boolean isAliveNextGen) { this.isAliveNextGen = isAliveNextGen; }

	public void setNeighBours(int neighbours) { this.neighbours = neighbours; }

	// Game Of Life Rules
	public void applyRules() {
		if(neighbours >  3) {
			isAliveNextGen = false;
		}

		if(neighbours < 2) {
			isAliveNextGen = false;
		}

		if(isAlive) {
			if(neighbours == 3 || neighbours == 2) {
				isAliveNextGen = true;
			}
		} else {
			if(neighbours == 3) {
				isAliveNextGen = true;
			}
		}
	}




}
