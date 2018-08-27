package gameoflife;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class SimulationPanel extends JPanel implements ActionListener{

	private static final int WIDTH = 700;
	private static final int HEIGHT = 700;
	private static final int DELAY = 100;
	private static final int COLUMNS = 100;
	private static final int ROWS = 100;
	private static final int CELL_WIDTH = WIDTH/COLUMNS;
	private static final int CELL_HEIGHT = HEIGHT/ROWS;
	private Cell[][] cellMatrix;
	private Timer timer;

	public SimulationPanel() {
		super();
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setBackground(Color.GRAY);
		setLayout(null);
		timer = new Timer(DELAY, this);

		initCellMatrix();
	}

	private void initCellMatrix() {
		cellMatrix = new Cell[COLUMNS][ROWS];

		for(int xPos = 0; xPos < COLUMNS; xPos++) {
			for(int yPos = 0; yPos < ROWS; yPos++) {
				cellMatrix[xPos][yPos] = new Cell(xPos * CELL_WIDTH, yPos * CELL_WIDTH);
			}
		}
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		drawGrid(g);
	}

	private void drawGrid(Graphics g) {
		g.setColor(Color.WHITE);
		// vertical lines
		for(int xPos = 0; xPos <= COLUMNS; xPos++) {
			g.drawLine(xPos * CELL_WIDTH, 0, xPos * CELL_WIDTH, HEIGHT);
		}

		// horizontal lines
		for(int yPos = 0; yPos <= COLUMNS; yPos++) {
			g.drawLine(0, yPos * CELL_HEIGHT, WIDTH,  yPos * CELL_HEIGHT);
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}
}
