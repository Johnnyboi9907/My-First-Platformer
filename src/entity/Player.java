package entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;

public class Player extends Entity {

	GamePanel gp;
	KeyHandler keyHandler;

	public Player(GamePanel gp, KeyHandler keyHandler) {

		this.gp = gp;
		this.keyHandler = keyHandler;

		setDefaultValues();
		getPlayerImage();
	}

	public void setDefaultValues() { // set the player's default values

		x = 100;
		y = 100;
		speed = 4;
		direction = "down";
	}

	public void getPlayerImage() { 

		try { // assign all player positions to their respective image

			up1 = ImageIO.read(getClass().getResourceAsStream("/player/sprite_07.png"));
			up2 = ImageIO.read(getClass().getResourceAsStream("/player/sprite_08.png"));
			down1 = ImageIO.read(getClass().getResourceAsStream("/player/sprite_01.png"));
			down2 = ImageIO.read(getClass().getResourceAsStream("/player/sprite_02.png"));
			left1 = ImageIO.read(getClass().getResourceAsStream("/player/sprite_04.png"));
			left2 = ImageIO.read(getClass().getResourceAsStream("/player/sprite_05.png"));
			right1 = ImageIO.read(getClass().getResourceAsStream("/player/sprite_10.png"));
			right2 = ImageIO.read(getClass().getResourceAsStream("/player/sprite_11.png"));
			still_up = ImageIO.read(getClass().getResourceAsStream("/player/sprite_06.png"));
			still_down = ImageIO.read(getClass().getResourceAsStream("/player/sprite_00.png"));
			still_left = ImageIO.read(getClass().getResourceAsStream("/player/sprite_03.png"));
			still_right = ImageIO.read(getClass().getResourceAsStream("/player/sprite_09.png"));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void update() { // update player's position 60 times per second

		if (keyHandler.upPressed == true || keyHandler.downPressed == true 
				|| keyHandler.leftPressed == true || keyHandler.rightPressed == true) { // when the player is moving
			
			if (keyHandler.upPressed == true) {
				direction = "up";
				y -= speed;
			} else if (keyHandler.downPressed == true) {
				direction = "down";
				y += speed;
			} else if (keyHandler.leftPressed == true) {
				direction = "left";
				x -= speed;
			} else if (keyHandler.rightPressed == true) {
				direction = "right";
				x += speed;
			}
			
			// basic sprite walking animation using 2 motion position images
			spriteCounter ++;
			if(spriteCounter > 10) { // every ten frames, change the sprite's motion position (ex: up1 to up2)
				if (spriteNumber == 0) {
					spriteNumber = 1; // if we are idle go to motion position 1
				}
				else if(spriteNumber == 1) {
					spriteNumber = 2; // go from motion position 1 to motion position 2
				}
				else if(spriteNumber == 2) {
					spriteNumber = 1; // go from motion position 2 back to motion position 1
				}
				spriteCounter = 0; // reset the counter to continuously alternate between motion positions
			}

		}
		
		else if (keyHandler.upPressed == false || keyHandler.downPressed == false 
				|| keyHandler.leftPressed == false || keyHandler.rightPressed == false) { // when the player stops moving
			
			if(spriteNumber == 1 || spriteNumber == 2) {
				spriteNumber = 0; // spriteNumber 0 is the player's idle position
			}
		}
		
	}

	public void draw(Graphics2D g2) { // draw the player on the screen

		BufferedImage image = null;

		switch (direction) { // assign sprite numbers to images

		case "up":
			if (spriteNumber == 0) {
				image = still_up; // idle position
			}
			if (spriteNumber == 1) {
				image = up1; // motion position 1
			}
			if (spriteNumber == 2) {
				image = up2; // motion position 2
			}
			break;
		case "down":
			if (spriteNumber == 0) {
				image = still_down;
			}
			if (spriteNumber == 1) {
				image = down1;
			}
			if (spriteNumber == 2) {
				image = down2;
			}
			break;
		case "left":
			if (spriteNumber == 0) {
				image = still_left;
			}
			if (spriteNumber == 1) {
				image = left1;
			}
			if (spriteNumber == 2) {
				image = left2;
			}
			break;
		case "right":
			if (spriteNumber == 0) {
				image = still_right;
			}
			if (spriteNumber == 1) {
				image = right1;
			}
			if (spriteNumber == 2) {
				image = right2;
			}
			break;
		}

		g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
	}

}
