package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

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
	
	int FPS = 60; // how many frames will appear on screen per second
	
	Thread gameThread; // game clock which keeps the program running until manually stopped
	KeyHandler keyHandler = new KeyHandler();
	
	// set the player's default values
	int posX = 100;
	int posY = 100;
	int playerSpeed = 4;
	
	public GamePanel() {
		
		this.setPreferredSize(new Dimension(maxScreenWidth, maxScreenHeight));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		this.addKeyListener(keyHandler); // GamePanel can recognize key input
		this.setFocusable(true); // GamePanel can be "focused" to receive key input
	}
	
	public void startGameThread() { // starts the thread, calls run() method
		
		gameThread = new Thread(this);
		gameThread.start();
	}

	@Override
	public void run() { // this method will run after startGameThread() method
		
		double drawInterval = 1000000000/FPS; // how long 1 single frame will last on screen (1 billion nanoseconds / 60)
		double delta = 0;
		long lastTime = System.nanoTime();
		long currentTime;
		
		while (gameThread != null) { // game loop
			
			currentTime = System.nanoTime();
			delta += (currentTime - lastTime) / drawInterval;
			lastTime = currentTime;
			
			if (delta >= 1) {
				update();
				repaint();
				delta--;
			}
			
		}
	}
	
	public void update() { // update player's position
		
		if (keyHandler.upPressed == true) {
			posY -= playerSpeed;
		}
		else if (keyHandler.downPressed == true) {
			posY += playerSpeed;
		}
		else if (keyHandler.leftPressed == true) {
			posX -= playerSpeed;
		}
		else if (keyHandler.rightPressed == true) {
			posX += playerSpeed;
		}
	}
	
	public void paintComponent(Graphics g) { // built-in java method to draw objects on the screen
		
		super.paintComponent(g); // calling method of parent class: JPanel
		
		Graphics2D g2 = (Graphics2D)g; // Graphics g is being converted to Graphics2D g2 (downcasting)
		
		g2.setColor(Color.magenta);
		g2.fillRect(posX, posY, tileSize, tileSize);
		g2.dispose(); // saves memory
	}
}
