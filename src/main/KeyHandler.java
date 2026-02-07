package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

	public boolean upPressed, downPressed, leftPressed, rightPressed;
	
	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {

		int code = e.getKeyCode(); // returns the integer number of the inputed key

		if (code == KeyEvent.VK_W) { // if the user pressed 'W' key
			upPressed = true;
		}

		if (code == KeyEvent.VK_S) { // if the user pressed 'S' key
			downPressed = true;
		}

		if (code == KeyEvent.VK_A) { // if the user pressed 'A' key
			leftPressed = true;
		}

		if (code == KeyEvent.VK_D) { // if the user pressed 'D' key
			rightPressed = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		int code = e.getKeyCode();
		
		if (code == KeyEvent.VK_W) {
			upPressed = false;
		}

		if (code == KeyEvent.VK_S) {
			downPressed = false;
		}

		if (code == KeyEvent.VK_A) {
			leftPressed = false;
		}

		if (code == KeyEvent.VK_D) {
			rightPressed = false;
		}
	}

}
