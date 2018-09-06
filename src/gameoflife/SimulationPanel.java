package gameoflife;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class SimulationPanel extends JPanel implements ActionListener {

	private int width = 800;
	private int height = 800;

	private int myTimerDelay;
	private Timer myTimer;
	private boolean gameStart;

	private JPanel buttons;
	private JButton startButton;
	private JButton clearButton;
	private JButton randomButton;
	private JSlider speedSlider;


	public SimulationPanel() {
		super();
		this.setPreferredSize(new Dimension(width, height));
		this.setBackground(Color.GRAY);
		this.setLayout(null);

		buttons = new JPanel();
		startButton = new JButton("Start");
		clearButton = new JButton("Clear");
		randomButton = new JButton("Random");
		speedSlider = new JSlider();

		buttons.add(startButton);
		buttons.add(clearButton);
		buttons.add(randomButton);
		buttons.add(speedSlider);


		myTimer= new Timer(myTimerDelay, this);
		// calls the actionPerformed method after given delay
		myTimer.start();
	}


	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		//drawCells(g);
		//drawGrid(g);
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {

		reDraw();
	}

	public void reDraw() {
		this.repaint();
	}

	public JButton getStartButton() { return this.startButton; }

	public JButton getClearButton() { return this.clearButton; }

	public JButton getRandomButton() { return this.startButton; }

	public JSlider getSpeedSlider() { return this.speedSlider; }

	public boolean isGameStart() { return gameStart; }

	public void setGameStart(boolean gameStart) { this.gameStart = gameStart; }

	public int getMyTimerDelay() { return myTimerDelay; }

	public void setMyTimerDelay(int myTimerDelay) { this.myTimerDelay = myTimerDelay; }

	public Timer getMyTimer() { return this.myTimer; }

	public int getWidth() { return this.width; }

	public int getHeight() { return this.height; }
}
