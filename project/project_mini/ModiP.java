package project_mini;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ModiP extends JFrame implements ActionListener{
	JLabel subL,nameL,passL,adL;
	JTextField jt1,jt2,jt3;
	JButton jb1,jb2;
	JPanel pan1,pan2,pan3,pan4,pan5;
	ModiP(){
		pan1=new JPanel();pan2=new JPanel();pan3=new JPanel();pan4=new JPanel();
		pan5=new JPanel();
		subL=new JLabel("-------------회원정보 수정 -------------");

		nameL=new JLabel("이름");passL=new JLabel("비밀번호");adL=new JLabel("주소");
		
		jt1=new JTextField(10);
		jt2=new JTextField(10);
		jt3=new JTextField(17);
		jb1=new JButton("수정");jb2=new JButton("닫기");
		//패널1 2 3 4 
		pan1.add(subL);pan2.add(nameL);pan2.add(jt1);
		pan3.add(passL);pan3.add(jt2);
		pan4.add(adL);pan4.add(jt3);
		pan5.add(jb1);pan5.add(jb2);
		
		
		//텍스트초기화
		jb1.addActionListener(this);jb2.addActionListener(this);
		
		//하얗게
		pan1.setBackground(Color.WHITE);
		pan2.setBackground(Color.WHITE);
		pan3.setBackground(Color.WHITE);
		pan4.setBackground(Color.WHITE);
		pan5.setBackground(Color.WHITE);
		jb1.setBackground(Color.WHITE);
		jb2.setBackground(Color.WHITE);
		
		setLayout(new GridLayout(5, 1));
		add(pan1);add(pan2);add(pan3);add(pan4);add(pan5);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(500,300);
		
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		   Dimension f_size = super.getSize();
		   int xpos = (int) (screen.getWidth() / 2 - f_size.getWidth() / 2);
		   int ypos = (int) (screen.getHeight() / 2 - f_size.getHeight() / 2);
		   setLocation(xpos-100, ypos);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj=e.getSource();
		if(obj==jb1) {
			jt1.setText("");jt2.setText("");jt3.setText("");
		}if(obj==jb2) {
			setVisible(false);
		}
	}

	
}
