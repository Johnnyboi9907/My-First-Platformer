package entity;

import java.awt.Color;
import java.awt.Graphics2D;

import main.GamePanel;
import main.KeyHandler;

public class Player extends Entity {

	GamePanel gp;
	KeyHandler keyHandler;

	public Player(GamePanel gp, KeyHandler keyHandler) {

		this.gp = gp;
		this.keyHandler = keyHandler;
		setDefaultValues();
	}

	public void setDefaultValues() { // set the player's default values

		x = 100;
		y = 100;
		speed = 4;
	}

	public void update() { // update player's position

		if (keyHandler.upPressed == true) {
			y -= speed;
		} else if (keyHandler.downPressed == true) {
			y += speed;
		} else if (keyHandler.leftPressed == true) {
			x -= speed;
		} else if (keyHandler.rightPressed == true) {
			x += speed;
		}
	}
	
	public void draw(Graphics2D g2) {
		
		g2.setColor(Color.magenta);
		g2.fillRect(x, y, gp.tileSize, gp.tileSize);
	}

}
