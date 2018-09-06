package gameoflife;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class SimulationPanel extends JPanel implements ActionListener {

	private static final int WIDTH = 700;
	private static final int HEIGHT = 700;
	private static final int DELAY = 100;
	private Timer timer;

	public SimulationPanel() {
		super();
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		this.setBackground(Color.GRAY);
		this.setLayout(null);
		this.addMouseListener(getMouseAdapter());
		timer = new Timer(DELAY, this);
		// calls the actionPerformed method after given delay
		timer.start();
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

		reDraw();
	}

	public void reDraw() {
		this.repaint();
	}

}
