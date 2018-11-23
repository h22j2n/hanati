package project_mini;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class MyP extends JFrame implements ActionListener,MouseListener{
      JTextField id,name,address,point,grade;
      JLabel label1,label2,label3,label4,label5,label6;
      DefaultTableModel model;
      JTable table;
      JScrollPane scroll;
      JPanel jp,jp2,jp3;
      JButton review,exit;
      String myname="";
      //리뷰창
      JFrame rr;
      JTextField comment;
      JComboBox<String> star;
      JButton exit2,review2;
      JPanel pan1,pan2,pp1,pp2,pp3,pp4,pp5;
      
      MyP(String myname){
         this.myname=myname;
         setTitle("마이페이지");
         label1=new JLabel("  아이디");label2=new JLabel("  이름   ");label3=new JLabel("  주소   ");
         label4=new JLabel(" 포인트");label5=new JLabel("   등급  ");
         label6=new JLabel("----------구매내역-----------");
         id=new JTextField(10);name=new JTextField(10);address=new JTextField(16);
         point=new JTextField(10);grade=new JTextField(10);
         
          String[] st= {"종류","이름","가격","갯수"};
         model = new DefaultTableModel(st, 0) {
            public boolean isCellEditable(int row, int col) {
               return false;}
         };
         table = new JTable(model);
         scroll = new JScrollPane(table);
         review=new JButton("상품평 등록");exit=new JButton("닫기");
         review.addActionListener(this);
         exit.addActionListener(this);
         
         JPanel jpp=new JPanel();
         JLabel face=new JLabel(new ImageIcon("src/project_mini/face.jpg"));
         jpp.add(face);
         jpp.setLayout(new GridLayout(1, 2));
         jp=new JPanel(); 
         jp.setLayout(new GridLayout(5, 1));
         
         jpp.add(jp);
         
         
         pp1=new JPanel(new FlowLayout(FlowLayout.LEFT));
         pp2=new JPanel(new FlowLayout(FlowLayout.LEFT));
         pp3=new JPanel(new FlowLayout(FlowLayout.LEFT));
         pp4=new JPanel(new FlowLayout(FlowLayout.LEFT));
         pp5=new JPanel(new FlowLayout(FlowLayout.LEFT));
         pp1.add(label1);pp1.add(id);
         pp2.add(label2);pp2.add(name); 
         pp3.add(label3);pp3.add(address);
         pp4.add(label4);pp4.add(point);
         pp5.add(label5);pp5.add(grade);
         
         jp.add(pp1);jp.add(pp2);jp.add(pp3);jp.add(pp4);jp.add(pp5);
         jp2=new JPanel();
         jp2.add(label6);jp2.add(scroll);
         
         jp3=new JPanel();
      
         jp3.add(review);jp3.add(exit);
      
         //리뷰남기기///////////////////////////////////////////////////////
         rr=new JFrame("상품평 작성");
         pan1=new JPanel();
         comment=new JTextField(25);
         comment.addMouseListener(this);
         init();
         String[] stars= {"★","★★","★★★","★★★★","★★★★★"};
         star=new JComboBox<>(stars);
         pan1.add(comment);pan1.add(star);
         pan2=new JPanel();
         review2=new JButton("등록");exit2=new JButton("닫기");
         pan2.add(review2);pan2.add(exit2);
         review2.addActionListener(this); ////////
         rr.setLayout(new GridLayout(2, 1));
         rr.add(pan1);rr.add(pan2);
         exit2.addActionListener(this);
         
         id.setEditable(false);name.setEditable(false);address.setEditable(false);
         point.setEditable(false);grade.setEditable(false); 
         
         rr.setSize(500, 200);
         rr.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
         pan1.setBackground(Color.WHITE);
         pan2.setBackground(Color.WHITE);
         /////////하얗게////////////////
         review.setBackground(Color.WHITE);exit.setBackground(Color.WHITE);
         jp2.setBackground(Color.WHITE);pp1.setBackground(Color.WHITE);
         pp2.setBackground(Color.WHITE);pp3.setBackground(Color.WHITE);
         pp4.setBackground(Color.WHITE);pp5.setBackground(Color.WHITE);
         jp3.setBackground(Color.WHITE);
         
		setLayout(new GridLayout(3, 1));
		add(jpp);
		add(jp2);
		add(jp3);
		setSize(500, 600);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension f_size = super.getSize();
		int xpos = (int) (screen.getWidth() / 2 - f_size.getWidth() / 2);
		int ypos = (int) (screen.getHeight() / 2 - f_size.getHeight() / 2);
		setLocation(xpos - 250, ypos);
		rr.setLocation(xpos-250, ypos);
   
   }
      
   public void init() {
	   comment.setText("제품에 대한 평가와 별점을 남겨주세요~      요기->");
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      Object obj=e.getSource();
      if(obj==review) {
    	  if(table.getRowCount()==0) {
              JOptionPane.showMessageDialog(this, "구매내역이 없습니다.");
           }else if (table.getSelectedRow()<0){
              JOptionPane.showMessageDialog(this, "제품을 선택하세요.");
           }else
           rr.setVisible(true);
    	   init();
      }if(obj==exit) {
         setVisible(false);
      }
      if(obj==exit2) {
         rr.setVisible(false);
      }if(obj==review2) {
    	  if(comment.getText().equals("제품에 대한 평가와 별점을 남겨주세요~      요기->") || comment.getText().equals("")) {
              JOptionPane.showMessageDialog(this, "제품 리뷰를 입력하세요.");
              comment.setText("제품에 대한 평가와 별점을 남겨주세요~      요기->");
            }else {
           ReviewDTO dto=new ReviewDTO();
           int ko=table.getSelectedRow();
           String product=table.getValueAt(ko, 1).toString();
           dto.setName(myname);dto.setProduct_name(product);
           dto.setStar(star.getSelectedItem().toString());
           dto.setReview(comment.getText());
           CosmeticDAO.getInstance().upReview(dto);
           rr.setVisible(false);
            }
      }
   }

@Override
public void mouseClicked(MouseEvent e) {
	Object obj = e.getSource();
	if(obj == comment)
		comment.setText("");
	
}

@Override
public void mouseEntered(MouseEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void mouseExited(MouseEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void mousePressed(MouseEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void mouseReleased(MouseEvent e) {
	// TODO Auto-generated method stub
	
}



}