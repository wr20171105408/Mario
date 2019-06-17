package StartGame;

import javax.swing.JFrame;

import Main.mainPage;

public class Startgame extends mainPage{

	public static void start(Object object) {
		// TODO Auto-generated method stub
		JFrame framehelp = new JFrame();
		framehelp.setTitle("开始游戏");
		framehelp.setLocation(300, 50);
		framehelp.setSize(1280, 760);
		framehelp.setVisible(true);
	}
}
