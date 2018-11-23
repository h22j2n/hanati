package project_mini;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;
import javax.swing.border.TitledBorder;

public class RegiP extends JFrame implements ActionListener{
   JLabel label1,label2,label3,label4,label5;
   JTextField jt1,jt2,jt3,jt4;
   JButton regiB,exitB;
   JPanel jp,jp2,jp3;
   Container con;
   RegiP(){
      //label1=new JLabel("아이디");
      //label2=new JLabel("패스워드");
      //label3=new JLabel("이름");label4=new JLabel("주소");
      label5=new JLabel("회원정보등록");
      jt1=new JTextField(10);jt2=new JTextField(10);
      jt1.setSize(50,100);
      jt3=new JTextField(10);jt4=new JTextField(15);
      regiB=new JButton("등록");exitB=new JButton("닫기");
      jp=new JPanel();
      jp.add(label5);
      jp2=new JPanel();
      GridLayout grid =new GridLayout(4,2);
      grid.setVgap(20);
      jp2.setLayout(grid);
      setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
      //jp2.add(label1);
      TitledBorder bodid = new TitledBorder("아이디");
      TitledBorder bodpa = new TitledBorder("패스워드");
      TitledBorder bodna = new TitledBorder("이름");
      TitledBorder bodad = new TitledBorder("주소");
      jt1.setBorder(bodid);
      jp2.add(jt1);
      
      jt2.setBorder(bodpa);
      jp2.add(jt2);
      
      jt3.setBorder(bodna);
      jp2.add(jt3);
      
      jt4.setBorder(bodad);
      jp2.add(jt4);
      
      jp3=new JPanel();
      jp3.add(regiB);jp3.add(exitB);
      regiB.addActionListener(this);
      exitB.addActionListener(this);
      
      jp.setBackground(Color.WHITE);
      jp2.setBackground(Color.WHITE);
      jp3.setBackground(Color.WHITE);
      regiB.setBackground(Color.WHITE);
      exitB.setBackground(Color.WHITE);
      
      add(jp,BorderLayout.NORTH);add(jp2);
      add(jp3,BorderLayout.SOUTH);   
      setSize(400,400);
      setDefaultCloseOperation(DISPOSE_ON_CLOSE);
      
      Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
      Dimension f_size = super.getSize();
      int xpos = (int) (screen.getWidth() / 2 - f_size.getWidth() / 2);
      int ypos = (int) (screen.getHeight() / 2 - f_size.getHeight() / 2);
      setLocation(xpos+200, ypos-125);
   }

public void init() {
   jt1.setText("");
   jt2.setText("");
   jt3.setText("");
   jt4.setText("");
}
   
@Override
public void actionPerformed(ActionEvent e) {
   // TODO Auto-generated method stub
	
	
	
	
	
   Object obj=e.getSource();
   if(obj == regiB) {
	   
	   
   }
    if(obj==exitB)
       setVisible(false);
   
}
   
}