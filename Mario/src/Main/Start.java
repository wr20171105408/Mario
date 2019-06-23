package Main;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

import Body.BackDrop;
import Body.Mario;
public class Start extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Mario mario = new Mario();
	BackDrop backdrop = new BackDrop();
	public void go() {
		// TODO Auto-generated method stub
		this.setSize(1280, 760);
		this.setTitle("超级玛丽");
		this.setResizable(false);
		this.setLocationRelativeTo(null);  
		this.setDefaultCloseOperation(3); 
		this.addKeyListener(mario.kl);
		mario.trun.start();
		System.out.println(mario.icon.getWidth(null)+ "  "+mario.icon.getHeight(null));
		this.setVisible(true); 
		new Thread() {
			public void run() {
				while(true) {
					repaint();
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO: handle exception
						e.printStackTrace();
					}	
				}
			}
		}.start();
	}
	private BufferedImage bf;  
    private Graphics bg;  
	public void paint(Graphics g) {
		bf =(BufferedImage)this.createImage(this.getSize().width, this.getSize().height);//实现缓冲,这样的重绘方法实现了对背景图和超级玛丽的双缓冲
		bg = bf.createGraphics();//初始化
		bg=bf.getGraphics(); //获得bf对象的画笔
		bg.drawImage(backdrop.icon,backdrop.x,backdrop.y,null); //绘制背景图
		bg.drawImage(mario.icon, mario.x, mario.y, mario.width, mario.heigth,null);//绘制超级玛丽
		g.drawImage(bf,0,0, null);//往窗口绘图
	}
	
}
