package Body;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Mario implements Runnable{
	public int x = 0, y = 600;
	public int backdropX,backdropY;//背景图片的坐标
	public Map map;
	public ArrayList<Integer> mapxlist = map.mapxlist;//记录地图组件的坐标
	public ArrayList<Integer> mapylist = map.mapylist;//记录地图组件的坐标
	public int vx = 5;
	public Image icon = new ImageIcon("Images/right.png").getImage();
	public boolean left = false, right = false, jump = false;// 不让角色走路异常
	public KeyListener kl = new KeyListener() {
		@Override
		public void keyTyped(KeyEvent e) {//// 发生击键事件时被触发
			// TODO Auto-generated method stub
		}

		@Override
		public void keyReleased(KeyEvent e) {// 松开调用
			// TODO Auto-generated method stub
			int key = e.getKeyCode();
			if (key == KeyEvent.VK_D) {
				icon = new ImageIcon("Images/right.png").getImage();
				right = false;
			}
			if (key == KeyEvent.VK_A) {
				icon = new ImageIcon("Images/left.png").getImage();
				left = false;
			}
			if (key == KeyEvent.VK_W) {
				jump = false;
			}

		}

		@Override
		public void keyPressed(KeyEvent e) {// 按下调用
			// TODO Auto-generated method stub
			int key = e.getKeyCode();
			if (key == KeyEvent.VK_D) {
				right = true;
			}
			if (key == KeyEvent.VK_A) {
				left = true;
			}
			if (key == KeyEvent.VK_W) {
				jump = true;
				jump();
			}
		}
	};
	public Thread trun = new Thread(this);
	public void run() {
		while (true) {
			if (right) {
				if (x < 1230) {
					if(x<=640) {
						x = vx + x;
						icon = new ImageIcon("Images/mario_right.gif").getImage();
					}else if(x>640) {
						backdropX = backdropX-vx;
						for(int i=0;i<mapxlist.size();i++) {
							mapxlist.set(i, mapxlist.get(i)-5);
						}
						if(backdropX<-650) {
							backdropX=0;
						}
						icon = new ImageIcon("Images/mario_right.gif").getImage();
					}
				}
			}
			if (left) {
				if (x > 0) {
					x = x - vx;
					icon = new ImageIcon("Images/mario_left.gif").getImage();
				}
			}
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
	public void jump() {
		Thread tjump = new Thread();
		 new Thread(tjump) {
			public void run() {
				while(jump) {
					for (int i = y;i>450;i=i-5)
					{
						y = i;
						try {
							Thread.sleep(10);
						} catch (InterruptedException e) {
							// TODO: handle exception
							e.printStackTrace();
						}
					}
					while(y<600) {
						y = y+5;
						try {
							Thread.sleep(10);
						} catch (InterruptedException e) {
							// TODO: handle exception
							e.printStackTrace();
						}
					}
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
}
