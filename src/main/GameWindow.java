package main;

import javax.swing.JFrame;

public class GameWindow extends JFrame{
	
	public GameWindow(GamePanel gamePanel) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setTitle("2D Adventure");
		
		add(gamePanel);
		pack();
		
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
