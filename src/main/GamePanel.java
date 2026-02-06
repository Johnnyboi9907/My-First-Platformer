package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable{

	// SCREEN SETTINGS
	final int ORIGINAL_TILE_SIZE = 16; // 16x16 tile
	final int SCALE = 3;
	
	final int tileSize = ORIGINAL_TILE_SIZE * SCALE; // 48x48 tile
	
	final int MAX_COLUMNS = 16;
	final int MAX_ROWS = 12;
	
	final int maxScreenWidth = tileSize * MAX_COLUMNS; // 768 pixels
	final int maxScreenHeight = tileSize * MAX_ROWS; // 576 pixels
	
	Thread gameThread; // game clock which keeps the program running until manually stopped
	
	public GamePanel() {
		
		this.setPreferredSize(new Dimension(maxScreenWidth, maxScreenHeight));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
	}
	
	public void startGameThread() { // starts the thread, calls run() method
		
		gameThread = new Thread(this);
		gameThread.start();
	}

	@Override
	public void run() { // this method will run after startGameThread() method
		
		
	}
}
