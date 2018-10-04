import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Label;
import java.awt.List;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.MenuShortcut;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

public class ChatFrame extends Frame {
//	String title;
	Label serverL;
	TextField serverTF, inputTF;
	Button connectB, sendB;
	TextArea messageTA;
	List userList;
	
	MenuBar menuBar;
	Menu menu;
	MenuItem newMI, exitMI;

	public ChatFrame() {
		this("이름없음");

	}

	public ChatFrame(String title) {
		super(title);
		serverL = new Label("Server");
		serverTF = new TextField();
		inputTF = new TextField();
		connectB = new Button("연결") /*{
			@Override
			public void paint(Graphics g) {
				g.drawLine(10, 10, 50, 10);
			}
		}*/;
		sendB = new Button("Sned");
		messageTA = new TextArea();
		userList = new List();
		userList.add("말미잘");
		userList.add("꼴뚜기");
		userList.add("미더덕");
		
		menuBar = new MenuBar();
		menu = new Menu("File");
		newMI = new MenuItem("new");
		newMI.setShortcut(new MenuShortcut(KeyEvent.VK_N)); // 단축키 추가
		exitMI = new MenuItem("exit");
		exitMI.setShortcut(new MenuShortcut(KeyEvent.VK_X));
		
	}

	// 화면 배치
	public void setContents() {
		// 색상 설정
//		connectB.setEnabled(false); //활성화(true), 비활성화(false) 시킬 때
		// TextField, TextArea, List 등에도 다 적용 가능
//		connectB.setBackground(new Color(200, 50, 120));
//		connectB.setBackground(Color.RED);
//		connectB.setForeground(Color.YELLOW); // 글자색

//		connectB.setFont(new Font("궁서", Font.BOLD, 20));

		Panel northP = new Panel(); // default는 FlowLayout
		northP.setLayout(new BorderLayout());// 화면에 꽉차게 바꾸려고
		northP.add(serverL, BorderLayout.WEST);
		northP.add(serverTF, BorderLayout.CENTER);
		northP.add(connectB, BorderLayout.EAST);

		Panel southP = new Panel(); // default는 FlowLayout
		southP.setLayout(new BorderLayout());// 화면에 꽉차게 바꾸려고
		southP.add(inputTF, BorderLayout.CENTER);
		southP.add(sendB, BorderLayout.EAST);

		add(northP, BorderLayout.NORTH);
		add(southP, BorderLayout.SOUTH);
		add(messageTA, BorderLayout.CENTER);
		add(userList, BorderLayout.EAST);

		setLocation(100, 100); // Frame이 뜰 때 위치 설정

//		setColorAll(Color.BLUE);
		
		setMenuBar(menuBar);
		menuBar.add(menu);
		menu.add(newMI);
		menu.addSeparator();
		menu.add(exitMI);
		
	}

	public void setCenter() {
//		Runtime.getRuntime().exec(command);
		Toolkit.getDefaultToolkit().beep();
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

		int x = (dim.width - getSize().width) / 2;
		int y = (dim.height - getSize().height) / 2;
		setLocation(x, y);
	}

	private void setColorAll(Color bg) {
		Component[] components = getComponents();
		for (Component component : components) {
			if (component instanceof Panel) {
				Component[] cs = ((Panel) component).getComponents();
				for (Component c : cs) {
					c.setBackground(bg);
				}
			}
			component.setBackground(bg);
		}
	}

	public void finish() {
		setVisible(false);
		dispose();
		System.exit(0);
	}
	
	public void appendMessage() {
		String message = inputTF.getText();
		messageTA.append(message + "\n");
		inputTF.setText("");
	}

	public void eventRegist() {
		/* 이름 있는 지역내부 클래스 */
		/*class Exiter extends WindowAdapter {

			@Override
			public void windowClosing(WindowEvent e) {
				finish(); // 내부클래스라 frame.finish() 안해도 됨

			}
		}*/
		
		
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				finish();
			}
		});
		
		inputTF.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				appendMessage();
			}
		});
		
		serverTF.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				System.out.println(e.getKeyChar());
				System.out.println(KeyEvent.VK_ENTER);
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		inputTF.addTextListener(new TextListener() {
			
			@Override
			public void textValueChanged(TextEvent e) {
				System.out.println(inputTF.getText());
				
			}
		});
		
		userList.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// 아이템 선택할 때의 이벤트
				if (e.getStateChange() == ItemEvent.SELECTED) {
					String name = userList.getSelectedItem();
//					JOptionPane.showMessageDialog(null, name+"님이 선택되었습니다.", "알림", JOptionPane.INFORMATION_MESSAGE);
					JOptionPane.showMessageDialog(null, name+"님이 선택되었습니다.", "알림", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		
		exitMI.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				finish();
			}
		});
	}


	/** 멤버내부 클래스를 이용한 이벤트 처리 */

//	class Exiter extends WindowAdapter{
//	
//		@Override
//		public void windowClosing(WindowEvent e) {
//			finish(); // 내부클래스라 frame.finish() 안해도 됨
//			
//		}
//	}

	public static void main(String[] args) {
		ChatFrame frame = new ChatFrame("Kotalk");
		frame.setContents(); // 배치
		frame.setSize(400, 500);
		frame.setCenter();
		frame.eventRegist();
		frame.setVisible(true);
	

	}

}
