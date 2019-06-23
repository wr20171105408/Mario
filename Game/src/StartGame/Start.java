package StartGame;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Start extends Thread {
	public JFrame jf;
	public Graphics g;
	public KeyEvent e;
	private Mario mario;
	private MarioThread mariothread;
	private ImageIcon bgicon = new ImageIcon(this.getClass().getResource("timgbj.jpg"));
	public int vx = 5;
	public boolean left = false, right = false, jump = false;

	public void run() {
		jf = new JFrame();
		jf.setTitle("超级玛丽");
		jf.setSize(1280, 768);
		jf.setResizable(false);
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(3);
		jf.setVisible(true);
		jf.addKeyListener(kl);
		g = jf.getGraphics();
		g.drawImage(bgicon.getImage(), 0, 0, null);
		Paint();
	}

	KeyListener kl = new KeyListener() {

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			int key = e.getKeyCode();
			System.out.println("走之前的位置" + mario.x);
			if (key == KeyEvent.VK_RIGHT) {
				if (mario.x < 1200) {
					mario.myicon = new ImageIcon(this.getClass().getResource("mario_right.gif"));
					mario.setVx(vx);
				} else if (mario.x >= 1200) {
					mario.vx = 0;
				}
			}
			if (key == KeyEvent.VK_LEFT) {
				if (mario.x >= 100) {
					System.out.println(mario.x);
					mario.myicon = new ImageIcon(this.getClass().getResource("mario_left.gif"));
					mario.setVx(-vx);
				} else if (mario.x <= 100) {
					mario.vx = 0;
				}
			}
			if (key == KeyEvent.VK_UP) {
				Jump();
			}

		}

		private void Jump() {
			// TODO Auto-generated method stub
			for (int i = mario.y; i > 518; i = i - 5) {
				mario.y = i;
				try {
					Thread.sleep(5);
				} catch (InterruptedException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				System.out.println("mario的纵坐标" + mario.y);
			}
			for (int i = mario.y; i < 668; i = i + 5) {
				mario.y = i;
				try {
					Thread.sleep(5);
				} catch (InterruptedException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			int key = e.getKeyCode();
			if (key == KeyEvent.VK_RIGHT) {
				if (mario.x < 1240) {
					mario.myicon = new ImageIcon(this.getClass().getResource("right.png"));
					mario.setVx(0);
				}
			}
			if (key == KeyEvent.VK_LEFT) {
				if (mario.x >= 40) {
					mario.myicon = new ImageIcon(this.getClass().getResource("left.png"));
					mario.setVx(0);
				}
			}
			if (key == KeyEvent.VK_UP) {
				System.out.println("跳完了");
			}
		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			int key = e.getKeyCode();
			if (key == KeyEvent.VK_UP) {
				jump = false;
			}
		}
	};

	public void Paint() {
		mario = new Mario(40, jf.getHeight() - 100); // 2.创建myThread线程
		mariothread = new MarioThread(mario, g, jf); // 3.使用Thread()方法，运行myThread线程
		new Thread(mariothread).start();
	}
}