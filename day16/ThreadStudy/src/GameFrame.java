import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

public class GameFrame extends Frame implements Runnable {

	int x = 50;
	int x2 = 50;
	int x3 = 50;
	int x4 = 50;
	int distance = (int)(Math.random()*20)+1;
	Toolkit toolkit;
	Image unit;

	public GameFrame(String title) {
		super(title);
		toolkit = Toolkit.getDefaultToolkit();
		unit = toolkit.getImage("C:\\Users\\kosta\\Downloads\\heart.png");
	}
	public void eventRegist() {
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowOpened(WindowEvent e) {
				gameStart();
			}
		});
	}

	public void gameStart() {
		Thread thread = new Thread(this);
		thread.start();
	}

	@Override
	public void paint(Graphics g) {
//		g.fillOval(x, 50, 100, 100);
//		g.fillOval(x2, 100, 100, 100);
		g.drawImage(unit, x, 50, this);
		g.drawImage(unit, x2, 150, this);
		g.drawImage(unit, x3, 250, this);
		g.drawImage(unit, x4, 350, this);
		toolkit.beep();
	}

	@Override
	public void run() {
		Random random = new Random();
		while (true) {

			x += (int)(Math.random()*10)+1;
			x2 += (int)(Math.random()*10)+1;
			x3 += (int)(Math.random()*10)+1;
			x4 += (int)(Math.random()*10)+1;

			repaint();
			try {
				Thread.sleep(random.nextInt(500));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
		
		

	}
}
