package gameoflife;

import java.awt.Dimension;

import javax.swing.JFrame;

public class GameOfLife {

	private JFrame jframe;
	private SimulationPanel simPanel;
	private SimulationLogic simLogic;
	private SimulationController simController;

	public GameOfLife() {
		initGuiAndShow();
	}

	private void initGuiAndShow() {
		jframe = new JFrame("Game Of Life Clone");
		simLogic = new SimulationLogic();
		simPanel = new SimulationPanel(simLogic);
		simController = new SimulationController(simLogic, simPanel);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.setResizable(false);
		jframe.add(simPanel);
		jframe.setVisible(true);
		jframe.pack();

	}

	public static void main(String[] args) {
		new GameOfLife();
	}
}
