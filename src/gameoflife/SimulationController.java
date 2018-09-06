package gameoflife;

import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;

public class SimulationController {

	private SimulationLogic simLogic;
	private SimulationPanel simPanel;

	public SimulationController(SimulationLogic simLogic, SimulationPanel simPanel) {
		this.simLogic = simLogic;
		this.simPanel = simPanel;
		this.simPanel.addMouseListener(getMouseAdapter());
		initController();
	}

	private void initController() {
		simPanel.getStartButton().addActionListener(e -> startSimulation(e));
		simPanel.getClearButton().addActionListener(e -> clear());
		simPanel.getRandomButton().addActionListener(e -> randomizer());
		simPanel.getSpeedSlider().addChangeListener(e -> setSpeed(e));
	}

	private void startSimulation(ActionEvent e) {
		if(!simPanel.isGameStart()) {
			simPanel.setGameStart(true);
			((JButton)e.getSource()).setText("Stop");
		} else {
			simPanel.setGameStart(false);
			((JButton)e.getSource()).setText("Start");
		}
	}

	private void clear() {
		simLogic.clearCellMatrix();
		simPanel.reDraw();
	}

	private void randomizer() {
		simLogic.initCellsRandomly();
		simPanel.reDraw();
	}

	private void setSpeed(ChangeEvent e) {
		int newDelay = simPanel.getMyTimerDelay() / (((JSlider)e.getSource()).getValue() + 1);
		simPanel.getMyTimer().setDelay(newDelay);
	}

	private MouseAdapter getMouseAdapter() {
		return new MouseAdapter() {
			public void mousePressed(MouseEvent me) {
				int x = me.getX()/(SimulationPanel.DRAW_WIDTH/simLogic.getColumns());
				int y = me.getY()/(SimulationPanel.DRAW_HEIGHT/simLogic.getRows());
				simLogic.reviveCell(true, x, y);
				simPanel.reDraw();
			}
		};
	}
}
