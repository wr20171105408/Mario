package StartGame;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class MarioThread implements Runnable{
	private Mario mario;    
	private Graphics g;    
	private JFrame jf;    
	private ImageIcon bgicon = new ImageIcon(this.getClass().getResource("timgbj.jpg"));
	public MarioThread(Mario mario, Graphics g,JFrame jf){
        this.mario = mario;
        this.g = g;
        this.jf = jf;
    }
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			/*使用缓存技术bufferedImage，解决画面交替绘制闪烁问题
                         首先将所有物体绘制于bufferedImage内
                        再将bufferedImage绘制于JFrame内*/
			 //1.创建bufferedImage对象：大小为jf大小，类型为RGB            
			BufferedImage bufferedImage = new BufferedImage(jf.getWidth(),jf.getHeight(),BufferedImage.TYPE_INT_BGR);            
			//2.获取bufferedImage对象的画笔：bg           
			Graphics bg = bufferedImage.createGraphics();            
			//绘制背景和马里奥，于bufferedImage对象上            
			bg.drawImage(bgicon.getImage(),0,0,null);            
			mario.drawPlane(bg);            
			//绘制bufferedImage，到JFrame上            
			g.drawImage(bufferedImage,0,0,null);
		}
	}

}
