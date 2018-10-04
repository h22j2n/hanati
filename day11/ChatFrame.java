import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.HeadlessException;
import java.awt.Label;
import java.awt.LayoutManager;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.Toolkit;
import java.util.FormatterClosedException;

import javax.swing.border.Border;

public class ChatFrame extends Frame {
//	String title;
	Label serverL;
	TextField serverTF, inputTF;
	Button connectB, sendB;
	TextArea messageTA;
	List userList;
	
	public ChatFrame()  {
		this("이름없음");
		
	}
	
	public ChatFrame(String title)  {
		super(title);
		serverL = new Label("Server");
		serverTF = new TextField();
		inputTF = new TextField();
		connectB = new Button("연결");
		sendB = new Button("Sned");
		messageTA = new TextArea();
		userList = new List(10);
		
	}
	
	//화면 배치
	public void setContents() {
		// 색상 설정
//		connectB.setEnabled(false); //활성화(true), 비활성화(false) 시킬 때
		// TextField, TextArea, List 등에도 다 적용 가능
//		connectB.setBackground(new Color(200, 50, 120));
//		connectB.setBackground(Color.RED);
//		connectB.setForeground(Color.YELLOW); // 글자색
		
//		connectB.setFont(new Font("궁서", Font.BOLD, 20));
		
		
		Panel northP = new Panel(); //default는 FlowLayout
		northP.setLayout(new BorderLayout());//화면에 꽉차게 바꾸려고
		northP.add(serverL, BorderLayout.WEST);
		northP.add(serverTF, BorderLayout.CENTER);
		northP.add(connectB, BorderLayout.EAST);
		
		
		Panel southP = new Panel(); //default는 FlowLayout
		southP.setLayout(new BorderLayout());//화면에 꽉차게 바꾸려고
		southP.add(inputTF, BorderLayout.CENTER);
		southP.add(sendB, BorderLayout.EAST);
		
		add(northP, BorderLayout.NORTH);
		add(southP, BorderLayout.SOUTH);
		add(messageTA,BorderLayout.CENTER);
		add(userList,BorderLayout.EAST);
		
		setLocation(100, 100); // Frame이 뜰 때 위치 설정
	
		
//		setColorAll(Color.BLUE);
		
	}
	
	public void setCenter() {
//		Runtime.getRuntime().exec(command);
		Toolkit.getDefaultToolkit().beep();
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		
		int x = (dim.width - getSize().width)/2;
		int y = (dim.height - getSize().height)/2;
		setLocation(x, y);
	}
	
	private void setColorAll(Color bg) {
		Component[] components = getComponents();
		for (Component component : components) {
			if(component instanceof Panel) {
				Component[] cs = ((Panel) component).getComponents();
				for (Component c : cs) {
					c.setBackground(bg);
				}
			}
			component.setBackground(bg);
		}
	}
	
	
	
	public static void main(String[] args) {
		ChatFrame frame = new ChatFrame("Kotalk");
		frame.setContents(); //배치
		frame.setSize(400,500);
		frame.setCenter();
		frame.setVisible(true);
		
	}

}
