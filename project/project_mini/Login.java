package project_mini;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener{
      JButton loginB,regiB;
      JLabel loginL,passL;
      JTextField jt,jt2;
      JFrame jj, jj2;
      JPanel panel1,pan1,pan2,pan3;   
      RegiP re;
      String id=""; String myname="";
      
      
   Login(){
      setTitle("로그인");
      panel1=new JPanel();
      GridLayout gri =new GridLayout(2, 1);
      gri.setVgap(10);
      panel1.setLayout(gri);
      pan1=new JPanel(); pan2=new JPanel(); pan3=new JPanel();
      loginL=new JLabel("아이디");passL=new JLabel("비밀번호");
      panel1.add(new JLabel(new ImageIcon("src/project_mini/logo.jpg")));
      jt =new JTextField(10);
      jt2 =new JPasswordField(10);
      loginB=new JButton("로그인");
      loginB.setSize(10,10);
      regiB=new JButton("회원가입");
      regiB.addActionListener(this);
      GridLayout grid=new GridLayout(3, 1);
      grid.setVgap(15);
      pan1.setLayout(grid);
      pan1.add(loginL);pan1.add(jt);
      pan1.add(passL);pan1.add(jt2);
      pan1.add(loginB);pan1.add(regiB);
      panel1.add(pan1);
      //등록
      re=new RegiP();
      re.regiB.addActionListener(this);
      
      loginB.setBackground(Color.WHITE);
      regiB.setBackground(Color.WHITE);
      pan1.setBackground(Color.WHITE);
      panel1.setBackground(Color.WHITE);
      
      add(panel1);
      setDefaultCloseOperation(DISPOSE_ON_CLOSE);
      setSize(400, 250);
      
      Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
      Dimension f_size = super.getSize();
      int xpos = (int) (screen.getWidth() / 2 - f_size.getWidth() / 2);
      int ypos = (int) (screen.getHeight() / 2 - f_size.getHeight() / 2);
      setLocation(xpos+10, ypos-100);
   }
   
@Override
   public void actionPerformed(ActionEvent e) {
      Object obj=e.getSource();
      
      if(obj==regiB) { //회원가입 창
         re.setVisible(true);
         
      }if(obj==re.regiB) {//등록
    	 String id = re.jt1.getText(); 
    	 ClientDTO cdto = CosmeticDAO.getInstance().getCli(id);
    	 
    	 if(cdto.getId() != null) {    		 
        		 JOptionPane.showMessageDialog(this, "아이디중복");
    	 }
    	 else if(re.jt1.getText().equals("")) {
  		   JOptionPane.showMessageDialog(this, "아이디를 입력해주세요");
  	   }
  	   else if(re.jt2.getText().equals("")) {
  		   JOptionPane.showMessageDialog(this, "비밀번호를 입력해주세요");
  	   }
  	   else if(re.jt3.getText().equals("")) {
  		   JOptionPane.showMessageDialog(this, "이름을 입력해주세요");
  	   }
  	   else if(re.jt4.getText().equals("")) {
  		   JOptionPane.showMessageDialog(this, "주소를 입력해주세요");
  	   }
    	 else {
         ClientDTO dto=new ClientDTO();
         dto.setId(re.jt1.getText());
         dto.setPassword(re.jt2.getText());
         dto.setName(re.jt3.getText());
         dto.setAddress(re.jt4.getText());
         
         dto.setPoint(3000);
         dto.setGrade("일반회원");
         CosmeticDAO.getInstance().upCli(dto);
         
         JOptionPane.showMessageDialog(this, "회원가입을 축하합니다.");
         re.dispose();
         re.init();
    	 }
      }
}



}