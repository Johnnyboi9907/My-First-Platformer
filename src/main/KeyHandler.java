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

		if (code == KeyEvent.VK_UP) { // if the user pressed 'W' key
			upPressed = true;
		}

		if (code == KeyEvent.VK_DOWN) { // if the user pressed 'S' key
			downPressed = true;
		}

		if (code == KeyEvent.VK_LEFT) { // if the user pressed 'A' key
			leftPressed = true;
		}

		if (code == KeyEvent.VK_RIGHT) { // if the user pressed 'D' key
			rightPressed = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		int code = e.getKeyCode();
		
		if (code == KeyEvent.VK_UP) {
			upPressed = false;
		}

		if (code == KeyEvent.VK_DOWN) {
			downPressed = false;
		}

		if (code == KeyEvent.VK_LEFT) {
			leftPressed = false;
		}

		if (code == KeyEvent.VK_RIGHT) {
			rightPressed = false;
		}
	}

}
