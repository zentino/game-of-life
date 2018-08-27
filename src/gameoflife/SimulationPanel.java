package gameoflife;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class SimulationPanel extends JPanel{

	private static final int WIDTH = 700;
	private static final int HEIGHT = 700;

	public SimulationPanel() {
		super();
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setBackground(Color.GRAY);
		setLayout(null);
	}
}
