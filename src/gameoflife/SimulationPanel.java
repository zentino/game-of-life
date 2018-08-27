package gameoflife;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class SimulationPanel extends JPanel{

	private static final int WIDTH = 700;
	private static final int HEIGHT = 700;
	private Cell[][] cellMatrix;

	public SimulationPanel() {
		super();
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setBackground(Color.GRAY);
		setLayout(null);
		cellMatrix = new Cell[100][100];

		// instantiate Cells
		for(int xPos = 0; xPos < cellMatrix.length; xPos++) {
			for(int yPos = 0; xPos < cellMatrix[0].length; yPos++) {
				cellMatrix[xPos][yPos] = new Cell(xPos, yPos);
			}
		}
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

	}
}
