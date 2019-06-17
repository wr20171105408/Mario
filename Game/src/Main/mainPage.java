package Main;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import StartGame.Startgame;

public class mainPage {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainPage window = new mainPage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public mainPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("小王游戏");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocation(300,50);
		ImageIcon icon = new ImageIcon("Images/timg.jpg");//将图片放入label中
		JLabel label = new JLabel(icon);//设置label的大小
		label.setBounds(0,0,icon.getIconWidth(),icon.getIconHeight());
		frame.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));//获取窗口的第二层，将label放入	
		JPanel j=(JPanel)frame.getContentPane();//获取frame的顶层容器,并设置为透明
		j.setOpaque(false);

		frame.setSize(icon.getIconWidth(),icon.getIconHeight());
		frame.setVisible(true);
        //主页面按键设置
		JButton startButton = new JButton("开始游戏");
		startButton.setBounds(540, 500, 169, 51);
		startButton.setBackground(Color.yellow);
		frame.getContentPane().add(startButton);
		JButton helpButton = new JButton("游戏帮助");
		helpButton.setBounds(540,550, 169, 51);
		frame.getContentPane().add(helpButton);
		helpButton.setBackground(Color.yellow);
		JButton otherButton = new JButton("关于");
		otherButton.setBounds(540, 600, 169, 51);
		frame.getContentPane().add(otherButton);
		otherButton.setBackground(Color.yellow);
		
		startButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("开始游戏");
				frame.dispose();
				Startgame.start(null);
			}
		});
		helpButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("帮助");
				frame.dispose();
				JFrame framehelp = new JFrame();
				framehelp.setTitle("帮助");
				framehelp.setLocation(300, 50);
				framehelp.setSize(1280, 760);
				framehelp.setVisible(true);
			}
		});
		otherButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("关于");
				frame.dispose();
				JFrame frameother = new JFrame();
				frameother.setTitle("关于");
				frameother.setLocation(300, 50);
				frameother.setSize(1280, 760);
				frameother.setVisible(true);
			}
		});
		
	}
	
}
