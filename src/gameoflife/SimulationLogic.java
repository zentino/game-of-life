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
	public void updateCellState() {
		for (int x = 0; x < columns; x++) {
			for (int y = 0; y < rows; y++) {
				cellMatrix[x][y].setAlive(cellMatrix[x][y].isAliveNextGen());
			}
		}
	}

	/*
	 * Count adjacent cells of every cell and apply game rules
	 */
	public void countNeighboursAndApplyRules() {
		int countNeighbours = 0;;

		for (int x = 0; x < columns; x++) {
			for (int y = 0; y < rows; y++) {

				if (cellMatrix[Math.floorMod(x - 1, columns)][Math.floorMod(y - 1, rows)].isAlive()) {
					countNeighbours++;
				}

				if (cellMatrix[Math.floorMod(x - 1, columns)][Math.floorMod(y, rows)].isAlive()) {
					countNeighbours++;
				}

				if (cellMatrix[Math.floorMod(x - 1, columns)][Math.floorMod(y + 1, rows)].isAlive()) {
					countNeighbours++;
				}

				if (cellMatrix[Math.floorMod(x, columns)][Math.floorMod(y + 1, rows)].isAlive()) {
					countNeighbours++;
				}

				if (cellMatrix[Math.floorMod(x + 1, columns)][Math.floorMod(y + 1, rows)].isAlive()) {
					countNeighbours++;
				}

				if (cellMatrix[Math.floorMod(x + 1, columns)][Math.floorMod(y, rows)].isAlive()) {
					countNeighbours++;
				}

				if (cellMatrix[Math.floorMod(x + 1, columns)][Math.floorMod(y - 1, rows)].isAlive()) {
					countNeighbours++;
				}

				if (cellMatrix[Math.floorMod(x, columns)][Math.floorMod(y - 1, rows)].isAlive()) {
					countNeighbours++;
				}

				cellMatrix[x][y].setNeighBours(countNeighbours);
				cellMatrix[x][y].applyRules();
				countNeighbours = 0;
			}
		}
	}

	public int getColumns() { return this.columns; }

	public int getRows() { return this.rows; }

	public Cell[][] getCellMatrix() { return this.cellMatrix; }
}
