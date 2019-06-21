package StartGame;

import java.awt.Graphics;

import javax.swing.ImageIcon;

public class Mario {
	public int x, y;//马里奥的位置
	public int vx;//马里奥的移动速度
	// ImageIcon myicon = new ImageIcon(this.getClass().getResource("PaperPlane.png"));
	public ImageIcon myicon = new ImageIcon(this.getClass().getResource("right.png"));
	public Mario(int x,int y) {//马里奥的位置
		this.x = x;
		this.y = y;
	}
	public void drawPlane(Graphics g) {//画马里奥的函数
        g.drawImage(myicon.getImage(), x, y, null);
        x=vx+x;
    }
	public void setVx(int vx) {//马里奥的速度
        this.vx = vx;
    }

 
}
