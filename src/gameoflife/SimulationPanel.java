package gameoflife;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class SimulationPanel extends JPanel implements ActionListener {

	private static final int WIDTH = 700;
	private static final int HEIGHT = 700;
	private static final int DELAY = 100;
	private static final int COLUMNS = 100;
	private static final int ROWS = 100;
	private static final int CELL_WIDTH = WIDTH / COLUMNS;
	private static final int CELL_HEIGHT = HEIGHT / ROWS;
	private Cell[][] cellMatrix;
	private Timer timer;

	public SimulationPanel() {
		super();
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setBackground(Color.GRAY);
		setLayout(null);

		timer = new Timer(DELAY, this);
		// calls the actionPerformed method after given delay
		timer.start();

		initCellMatrix();
	}

	private void initCellMatrix() {
		cellMatrix = new Cell[COLUMNS][ROWS];

		for (int xPos = 0; xPos < COLUMNS; xPos++) {
			for (int yPos = 0; yPos < ROWS; yPos++) {
				cellMatrix[xPos][yPos] = new Cell(false, xPos * CELL_WIDTH, yPos * CELL_WIDTH);
			}
		}
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		drawCells(g);
		drawGrid(g);
	}

	private void drawGrid(Graphics g) {
		g.setColor(Color.WHITE);
		// vertical lines
		for (int xPos = 0; xPos <= COLUMNS; xPos++) {
			g.drawLine(xPos * CELL_WIDTH, 0, xPos * CELL_WIDTH, HEIGHT);
		}

		// horizontal lines
		for (int yPos = 0; yPos <= COLUMNS; yPos++) {
			g.drawLine(0, yPos * CELL_HEIGHT, WIDTH, yPos * CELL_HEIGHT);
		}
	}

	private void drawCells(Graphics g) {
		for (int xPos = 0; xPos < COLUMNS; xPos++) {
			for (int yPos = 0; yPos < ROWS; yPos++) {
				Cell cell = cellMatrix[xPos][yPos];
				if (cell.isAlive()) {
					g.setColor(Color.YELLOW);
					g.fillRect(cell.getxCoordinate(), cell.getyCoordinate(), CELL_WIDTH, CELL_HEIGHT);
				} else {
					g.setColor(Color.GRAY);
					g.fillRect(cell.getxCoordinate(), cell.getyCoordinate(), CELL_WIDTH, CELL_HEIGHT);
				}
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		checkNeighbours();
		this.repaint();
	}

	/*
	 * Count adjacent neighbours of every cell and apply game rules
	 */
	private void checkNeighbours() {
		int countNeighbours = 0;

		for(int xPos = 0; xPos < COLUMNS; xPos++) {
			for(int yPos = 0; yPos < ROWS; yPos ++) {

				// + = position that gets checked
				// o = current cell

				/*
				 *	+ - -
				 *	- o -
				 *	- - -
				 *
				 */
				if(cellMatrix[Math.floorMod(xPos - 1, COLUMNS) ][Math.floorMod(yPos - 1, ROWS)].isAlive()) {
					countNeighbours++;
				}
				/*
				 *	- - -
				 *	+ o -
				 *	- - -
				 *
				 */
				if(cellMatrix[Math.floorMod(xPos - 1, COLUMNS)][Math.floorMod(yPos, ROWS)].isAlive()) {
					countNeighbours++;
				}

				/*
				 *	- - -
				 *	- o -
				 *	+ - -
				 *
				 */
				if(cellMatrix[Math.floorMod(xPos - 1, COLUMNS)][Math.floorMod(yPos + 1, ROWS)].isAlive()) {
					countNeighbours++;
				}

				/*
				 *	- - -
				 *	- o -
				 *	- + -
				 *
				 */
				if(cellMatrix[Math.floorMod(xPos, COLUMNS)][Math.floorMod(yPos + 1, ROWS)].isAlive()) {
					countNeighbours++;
				}

				/*
				 *	- - -
				 *	- o -
				 *	- - +
				 *
				 */
				if(cellMatrix[Math.floorMod(xPos + 1, COLUMNS)][Math.floorMod(yPos + 1, ROWS)].isAlive()) {
					countNeighbours++;
				}

				/*
				 *	- - -
				 *	- o +
				 *	- - -
				 *
				 */
				if(cellMatrix[Math.floorMod(xPos + 1, COLUMNS)][Math.floorMod(yPos, ROWS)].isAlive()) {
					countNeighbours++;
				}

				/*
				 *	- - +
				 *	- o -
				 *	- - -
				 *
				 */
				if(cellMatrix[Math.floorMod(xPos + 1, COLUMNS)][Math.floorMod(yPos - 1, ROWS)].isAlive()) {
					countNeighbours++;
				}

				/*
				 *	- + -
				 *	- o -
				 *	- - -
				 *
				 */
				if(cellMatrix[Math.floorMod(xPos, COLUMNS)][Math.floorMod(yPos - 1, ROWS)].isAlive()) {
					countNeighbours++;
				}

				// apply game of life rules
				if(countNeighbours > 3) {
					// a living cell dies by overpopulation
					cellMatrix[xPos][yPos].setAlive(false);
				}

				if(countNeighbours < 2) {
					// a living cell dies by underpopulation
					cellMatrix[xPos][yPos].setAlive(false);
				}

				if(cellMatrix[xPos][yPos].isAlive()) {
					// a living cell stays alive in the next generation
					if(countNeighbours == 3 || countNeighbours == 2) {
						cellMatrix[xPos][yPos].setAlive(true);
					}
				} else {
					// a dead cell gets revived
					if(countNeighbours == 3) {
						cellMatrix[xPos][yPos].setAlive(true);
					}
				}


			}
		}
	}
}
