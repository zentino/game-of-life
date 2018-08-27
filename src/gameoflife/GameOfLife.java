package gameoflife;


import javax.swing.JFrame;

public class GameOfLife {

	private JFrame jframe;
	private static final int WIDTH = 700;
	private static final int HEIGHT = 700;
	private SimulationPanel simPanel;

	public GameOfLife() {
		initGui();
	}

	private void initGui() {
		jframe = new JFrame("Game Of Life Clone");
		simPanel = new SimulationPanel();
		jframe.setSize(WIDTH, HEIGHT);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.setResizable(false);
		jframe.add(simPanel);
		jframe.setVisible(true);

	}

	public static void main(String[] args) {
		new GameOfLife();
	}
}
