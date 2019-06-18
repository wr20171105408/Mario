package StartGame;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Main.mainPage;

public class Startgame extends mainPage{

	public static void start(Object object) {
		// TODO Auto-generated method stub
		JFrame framestart = new JFrame();
		framestart.setTitle("开始游戏");
		framestart.setLocation(300, 50);
		framestart.setSize(1280, 760);
		framestart.setVisible(true);
		ImageIcon icon = new ImageIcon("Images/mario_left.gif");//将图片放入label中
		JLabel label = new JLabel(icon);//设置label的大小
		label.setBounds(0,0,icon.getIconWidth(),icon.getIconHeight());
		framestart.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));//获取窗口的第二层，将label放入	
		JPanel j=(JPanel)framestart.getContentPane();//获取frame的顶层容器,并设置为透明
		j.setOpaque(false);
	}
}
