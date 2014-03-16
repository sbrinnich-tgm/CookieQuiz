package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JFrame;

import control.Controller;

public class View {
	
	private Controller c;
	
	private JFrame frame;
	
	private GamePanel gamePanel;
	private WaitingPanel waitingPanel;
	private MainMenuPanel mainMenuPanel;

	public View(Controller c){
		this.c = c;
		
		frame = new JFrame();
		frame.setSize(575, 600);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setLayout(new BorderLayout());
		
		frame.addWindowListener(new java.awt.event.WindowAdapter() {
		    @Override
		    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
		        closeWindow();
		    }
		});
	}
	
	public void closeWindow(){
		c.beenden();
	}
	
	public void showGamePanel(){
		gamePanel = new GamePanel(c);

		frame.add(gamePanel, BorderLayout.CENTER);
		frame.add(gamePanel.getProgBar(), BorderLayout.SOUTH);
		frame.setVisible(true);
	}
	
	public GamePanel getGamePanel(){
		return gamePanel;
	}
	
	public void showWaitingPanel(){
		waitingPanel = new WaitingPanel(c);

		frame.repaint();
		frame.add(waitingPanel);
		frame.setVisible(true);
	}
	
	public WaitingPanel getWaitingPanel(){
		return waitingPanel;
	}
	
	public void showMainMenuPanel(){
		mainMenuPanel = new MainMenuPanel(c);

		frame.repaint();
		frame.add(mainMenuPanel);
		frame.setVisible(true);
	}
	
	public MainMenuPanel getMainMenuPanel(){
		return mainMenuPanel;
	}
	
	public JFrame getFrame(){
		return frame;
	}
	
}
