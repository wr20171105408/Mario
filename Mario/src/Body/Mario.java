package Body;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import Body.MapAttribute;

import javax.swing.ImageIcon;

public class Mario implements Runnable {
	public int x = 0, y = 600;
	public int backdropX, backdropY;// 背景图片的坐标
	public Map map;
	public int vx = 5;
	public Image icon = new ImageIcon("Images/right.png").getImage();
	public boolean left = false, right = false, jump = false,down = false;
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
				vx=5;
				if (RCollisionDetection()) {// 有障碍的话玛丽的速度为0
					vx = 0;
				}
				if (x < 1230) {
					if (x <= 640) {
						x = vx + x;
						icon = new ImageIcon("Images/mario_right.gif").getImage();
					} else if (x > 640) {
						backdropX = backdropX - vx;
						for (int i = 0; i < map.maplist.size(); i++) {
							MapAttribute a = map.maplist.get(i);
							a.x = a.x - vx;
						}
						if (backdropX < -650) {
							backdropX = 0;
						}
						icon = new ImageIcon("Images/mario_right.gif").getImage();
					}
				}
			}
			if (left) {
				vx=5;
				if (LCollisionDetection()) {
					vx = 0;
				} else if (LCollisionDetection()) {
					vx = 5;
				}
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
				while (jump) {
					for (int i = y; i > 450; i = i - 5) {
						y = i;
						try {
							Thread.sleep(15);
						} catch (InterruptedException e) {
							// TODO: handle exception
							e.printStackTrace();
						}
					}
					while (y < 600) {
						y = y + 5;
						try {
							Thread.sleep(15);
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

	public boolean RCollisionDetection() {// 向右检测碰撞函数
		Rectangle Rmario = new Rectangle(x, y, icon.getWidth(null), icon.getHeight(null));
		Rectangle Rmap=null;
		for (int i = 0; i < map.maplist.size(); i++) {
			MapAttribute a = map.maplist.get(i);
			if(right) {
				Rmap = new Rectangle(a.x-5, a.y, a.icon.getWidth(null), a.icon.getHeight(null));
			}
			if(Rmario.intersects(Rmap)) {
				System.out.println("右边有东西");
				return true;
			}
		}
		return false;
	}
	public boolean LCollisionDetection() {// 向左检测碰撞函数
		Rectangle Rmario = new Rectangle(x, y, icon.getWidth(null), icon.getHeight(null));
		Rectangle Rmap=null;
		for (int i = 0; i < map.maplist.size(); i++) {
			MapAttribute a = map.maplist.get(i);
			if(left) {
				Rmap = new Rectangle(a.x+2, a.y, a.icon.getWidth(null), a.icon.getHeight(null));
			}
			if(Rmario.intersects(Rmap)) {
				System.out.println("左边有东西");
				return true;
			}
		}
		return false;
	}
	public boolean UCollisionDetection() {//向上检测碰撞函数
		Rectangle Rmario = new Rectangle(x, y, icon.getWidth(null), icon.getHeight(null));
		Rectangle Rmap=null;
		for (int i = 0; i < map.maplist.size(); i++) {
			MapAttribute a = map.maplist.get(i);
			if(jump) {
				Rmap = new Rectangle(a.x, a.y+2, a.icon.getWidth(null), a.icon.getHeight(null));
			}
			if(Rmario.intersects(Rmap)) {
				System.out.println("上边有东西");
				return true;
			}
		}
		return false;
	}
	public boolean DCollisionDetection() {//向下检测碰撞函数
		Rectangle Rmario = new Rectangle(x, y, icon.getWidth(null), icon.getHeight(null));
		Rectangle Rmap=null;
		for (int i = 0; i < map.maplist.size(); i++) {
			MapAttribute a = map.maplist.get(i);
			if(down) {
				Rmap = new Rectangle(a.x, a.y-2, a.icon.getWidth(null), a.icon.getHeight(null));
			}
			if(Rmario.intersects(Rmap)) {
				System.out.println("下边有东西");
				return true;
			}
		}
		return false;
	}
}
