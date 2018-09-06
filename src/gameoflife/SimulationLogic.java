package gameoflife;

import java.util.Random;

public class SimulationLogic {

	private int columns = 200;
	private int rows = 200;
	private Cell[][] cellMatrix;

	public SimulationLogic() {
		cellMatrix = new Cell[columns][rows];
		initCells();
	}

	private void initCells() {
		for (int x = 0; x < columns; x++) {
			for (int y = 0; y < rows; y++) {
				cellMatrix[x][y] = new Cell(false, x, y);
			}
		}
	}

	public void clearCellMatrix() {
		for(int x = 0; x < columns; x++) {
			for(int y = 0; y < rows; y++) {
				cellMatrix[x][y].setAlive(false);
				cellMatrix[x][y].setAliveNextGen(false);
			}
		}
	}

	public void initCellsRandomly() {
		Random random = new Random();
		for(int x = 0; x < columns; x++) {
			for(int y = 0; y < rows; y++) {
				cellMatrix[x][y].setAlive(random.nextBoolean());
			}
		}
	}

	public void reviveCell(boolean isAlive, int x, int y) {
		if(x < columns && y < rows) {
			cellMatrix[x][y].setAlive(true);
		}
	}

	// updates the cell state (alive/dead) after one generation/iteration
	private void updateCellState() {
		for (int x = 0; x < columns; x++) {
			for (int y = 0; y < rows; y++) {
				cellMatrix[x][y].setAlive(cellMatrix[x][y].isAliveNextGen());
			}
		}
	}

	/*
	 * Count adjacent cells of every cell and apply game rules
	 */
	private void countNeighboursAndApplyRules() {
		int countNeighbours = 0;

		for (int xPos = 0; xPos < columns; xPos++) {
			for (int yPos = 0; yPos < rows; yPos++) {

				if (cellMatrix[Math.floorMod(xPos - 1, columns)][Math.floorMod(yPos - 1, rows)].isAlive()) {
					countNeighbours++;
				}

				if (cellMatrix[Math.floorMod(xPos - 1, columns)][Math.floorMod(yPos, rows)].isAlive()) {
					countNeighbours++;
				}

				if (cellMatrix[Math.floorMod(xPos - 1, columns)][Math.floorMod(yPos + 1, rows)].isAlive()) {
					countNeighbours++;
				}

				if (cellMatrix[Math.floorMod(xPos, columns)][Math.floorMod(yPos + 1, rows)].isAlive()) {
					countNeighbours++;
				}

				if (cellMatrix[Math.floorMod(xPos + 1, columns)][Math.floorMod(yPos + 1, rows)].isAlive()) {
					countNeighbours++;
				}

				if (cellMatrix[Math.floorMod(xPos + 1, columns)][Math.floorMod(yPos, rows)].isAlive()) {
					countNeighbours++;
				}

				if (cellMatrix[Math.floorMod(xPos + 1, columns)][Math.floorMod(yPos - 1, rows)].isAlive()) {
					countNeighbours++;
				}

				if (cellMatrix[Math.floorMod(xPos, columns)][Math.floorMod(yPos - 1, rows)].isAlive()) {
					countNeighbours++;
				}
				countNeighbours = 0;
			}
		}
	}

}
