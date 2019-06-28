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
	public boolean left = false, right = false, jump = false;// 不让角色走路异常
	public boolean ObstaclesLeft = true, ObstaclesRight = true, ObstaclesUp = true, ObstaclesDown = true;// 不让角色走路异常
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
				Collide();
				right = true;
			}
			if (key == KeyEvent.VK_A) {
				Collide();
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
				if (ObstaclesRight == false) {
					vx = 0;
				} else if (ObstaclesRight == true) {
					vx = 5;
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
				if (ObstaclesLeft == false) {
					vx = 0;
				} else if (ObstaclesLeft == true) {
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

	public void Collide() {// 碰撞检测函数 用的是矩形碰撞检测 因为超级玛丽的图片都是矩形类型
		Rectangle mariorectangle = new Rectangle(x, y, icon.getWidth(null), icon.getHeight(null));// 超级玛丽的形状大小
		Rectangle obstaclerectangle;// 障碍物的形状大小
		for (int j = 0; j < map.maplist.size(); j++) {
			MapAttribute ma = map.maplist.get(j);
			obstaclerectangle = new Rectangle(ma.x + 2, ma.y, ma.width, ma.height);
			// System.out.println(ma.x+2+" "+ ma.y+" "+ ma.width+ " "+ ma.height);
			if (mariorectangle.intersects(obstaclerectangle)) {
				ObstaclesRight = false;
				System.out.println("右边有障碍");
			} else if (mariorectangle.intersects(obstaclerectangle) == false) {
				ObstaclesRight = true;
			}
			// System.out.println(ObstaclesLeft);
			obstaclerectangle = new Rectangle(ma.x - 2, ma.y, ma.width, ma.height);
			if (mariorectangle.intersects(obstaclerectangle)) {
				ObstaclesLeft = false;
			}else if (mariorectangle.intersects(obstaclerectangle) == false) {
				ObstaclesLeft = true;
			}
			obstaclerectangle = new Rectangle(ma.x, ma.y + 2, ma.width, ma.height);
			if (mariorectangle.intersects(obstaclerectangle)) {
				ObstaclesDown = false;
				// System.out.println(ObstaclesUp);
			}
			obstaclerectangle = new Rectangle(ma.x, ma.y - 2, ma.width, ma.height);
			if (mariorectangle.intersects(obstaclerectangle)) {
				ObstaclesUp = false;
				// System.out.println(ObstaclesDown);
			}
		 System.out.println("左："+ObstaclesLeft+"右："+ObstaclesRight+"上："+ObstaclesUp+"下："+ObstaclesDown);
		}
	}
}
