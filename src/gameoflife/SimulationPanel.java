package gameoflife;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.Timer;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class SimulationPanel extends JPanel implements ActionListener {

	public static final int DRAW_WIDTH = 800;
	public static final int DRAW_HEIGHT = 800;
	public static final int PANEL_WIDTH = 800;
	public static final int PANEL_HEIGHT = 870;

	private int myTimerDelay;
	private Timer myTimer;
	private boolean gameStart;

	private JPanel buttons;
	private JButton startButton;
	private JButton clearButton;
	private JButton randomButton;
	private JSlider speedSlider;
	private SimulationLogic simLogic;
	private ImageIcon speedMeter;

	public SimulationPanel(SimulationLogic simLogic) {
		super();
		this.simLogic = simLogic;
		this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
		this.setBackground(Color.GRAY);
		this.setLayout(null);
		this.setVisible(true);

		speedMeter = new ImageIcon("src\\speed.png");
		JLabel label = new JLabel(speedMeter);
		buttons = new JPanel(new FlowLayout());
		startButton = new JButton("Start");
		clearButton = new JButton("Clear");
		randomButton = new JButton("Random");
		speedSlider = new JSlider(0, 100, 0);
		speedSlider.setBackground(Color.GRAY);

		buttons.add(startButton);
		buttons.add(clearButton);
		buttons.add(randomButton);
		buttons.add(label);
		buttons.add(speedSlider);
		buttons.setBackground(Color.GRAY);
		buttons.setBounds(0, PANEL_HEIGHT - 70, PANEL_WIDTH, PANEL_HEIGHT);

		this.add(buttons);

		gameStart = false;
		myTimerDelay = 700;
		myTimer= new Timer(myTimerDelay, this);
		// calls the actionPerformed method after given delay
		myTimer.start();
	}


	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		drawCells(g);
		g.setColor(Color.GRAY);
		drawGrid(g);
	}

	private void drawCells(Graphics g) {
		int columns = simLogic.getColumns();
		int rows = simLogic.getRows();
		// Width and height of a rectangle that represents the cell
		int rectWidth = (DRAW_WIDTH/columns);
		int rectHeight = (DRAW_HEIGHT/rows);

		for(int x = 0; x < columns; x++) {
			for(int yPos = 0; yPos < rows; yPos++) {
				if(simLogic.getCellMatrix()[x][yPos].isAlive()) {
					g.setColor(Color.YELLOW);
					g.fillRect(x * rectWidth, yPos * rectHeight, rectWidth, rectHeight);
				} else if(!simLogic.getCellMatrix()[x][yPos].isAlive()) {
					g.setColor(Color.DARK_GRAY);
					g.fillRect(x * rectWidth , yPos * rectHeight, rectWidth, rectHeight);
				}
			}
		}
	}

	private void drawGrid(Graphics g) {
		int columns = simLogic.getColumns();
		int rows = simLogic.getRows();
		int rectWidth = (DRAW_WIDTH/columns);
		int rectHeight = (DRAW_HEIGHT/rows);

		for(int x = 0; x < columns; x++) {
			g.drawLine(x * rectWidth, 0, x * rectHeight, DRAW_HEIGHT);
		}
		for(int y = 0; y < rows; y++) {
			g.drawLine(0, y * rectHeight, DRAW_WIDTH, y * rectWidth);
		}
	}

	// This is the "Game loop" that gets called after a given delay (myTimerDelay)
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(gameStart) {
			simLogic.countNeighboursAndApplyRules();
			simLogic.updateCellState();
			reDraw();
		}
	}

	public void reDraw() {
		this.repaint();
	}

	public JButton getStartButton() { return this.startButton; }

	public JButton getClearButton() { return this.clearButton; }

	public JButton getRandomButton() { return this.randomButton; }

	public JSlider getSpeedSlider() { return this.speedSlider; }

	public boolean isGameStart() { return gameStart; }

	public void setGameStart(boolean gameStart) { this.gameStart = gameStart; }

	public int getMyTimerDelay() { return myTimerDelay; }

	public void setMyTimerDelay(int myTimerDelay) { this.myTimerDelay = myTimerDelay; }

	public Timer getMyTimer() { return this.myTimer; }

}
