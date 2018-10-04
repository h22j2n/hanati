import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.HeadlessException;
import java.awt.LayoutManager;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.border.Border;

import org.w3c.dom.events.MouseEvent;

public class UserFrame extends Frame implements MouseListener, WindowListener {
//	String title;
	Button eButton, wButton, sButton, nButton, cButton;

	public UserFrame()  {
		this("이름없음");
		
	}
	
	public UserFrame(String title)  {
		super(title);
		this.eButton = new Button("East");
		this.wButton = new Button("West");
		this.sButton = new Button("South");
		this.nButton = new Button("North");
		this.cButton = new Button("Center");
		
	}
	
	
	//화면 배치
	public void setContents() {
		//레이아웃 매니저 교체
		setLayout(new FlowLayout());
		add(eButton, BorderLayout.EAST);
		add(wButton, BorderLayout.WEST);
		add(sButton, BorderLayout.SOUTH);
		add(nButton, BorderLayout.NORTH);
		add(cButton, BorderLayout.CENTER);
		
		
	}
	
	// 이벤트소스에 이벤트리스너 연결
	public void eventRegist() {
		eButton.addMouseListener(this);
		wButton.addMouseListener(this);
		sButton.addMouseListener(this);
		nButton.addMouseListener(this);
		cButton.addMouseListener(this);
		addWindowListener(this);
				
	}
	
	public static void main(String[] args) {
		UserFrame frame = new UserFrame("타이틀입니다.");
		frame.setContents();
		frame.eventRegist();
		frame.setSize(1000,800);
		frame.setVisible(true);
	}

	@Override
	public void mouseClicked(java.awt.event.MouseEvent e) {
//		System.out.println("마우스 클릭됨");
		Object eventSource = e.getSource();
//		e.getComponent().setBackground(Color.RED);
		Button button = (Button)eventSource;
		int r = (int)(Math.random()*256);
		int g = (int)(Math.random()*256);
		int b = (int)(Math.random()*256);
		button.setBackground(new Color(r,g,b));
		
		if (eventSource == eButton) {
			System.out.println("EAST 클릭");
		}else if(eventSource == wButton) {
			System.out.println("WEST 클릭");
		}else if(eventSource == sButton) {
			System.out.println("SOUTH 클릭");
		}else if(eventSource == nButton) {
			System.out.println("NORTH 클릭");
		}else if(eventSource == cButton) {
			System.out.println("CENTER 클릭");
		}
	}

	@Override
	public void mousePressed(java.awt.event.MouseEvent e) {
		System.out.println("mousePressed() Called..");
	}

	@Override
	public void mouseReleased(java.awt.event.MouseEvent e) {
		System.out.println("mouseReleased() Called..");
	}

	@Override
	public void mouseEntered(java.awt.event.MouseEvent e) {
		System.out.println("mouseEntered() Called..");
	}

	@Override
	public void mouseExited(java.awt.event.MouseEvent e) {
		System.out.println("mouseExited() Called..");
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// 창을 열었을 때
		System.out.println("창이 열림");
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// 창을 종료할 때
		setVisible(false);
		dispose(); // os에 그래픽리소스 반납
		System.exit(0);
		
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// 창을 최소화
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// 화면이 활성화 될 때
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// 비활성화 될 때 (창이 가려질 때 등)
		
	}
	
	

}
