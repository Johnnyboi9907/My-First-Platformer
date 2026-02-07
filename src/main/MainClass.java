package main;

public class MainClass {
	
	public static void main(String[] args) {
		
		GamePanel gp = new GamePanel();
		GameWindow gw = new GameWindow(gp);
		gp.startGameThread();

	}

}
