package project_mini;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ReviewP extends JFrame{
	JLabel label;
	JButton btn;
	DefaultTableModel model;
	JTable table;
	JScrollPane scroll;
	ReviewP(){
		 String[] st= {"번호","상품명","한줄평","별점","작성자"};
			model = new DefaultTableModel(st, 0) {
				public boolean isCellEditable(int row, int col) {
					return false;}
			};
			table = new JTable(model);
			scroll = new JScrollPane(table);
			scroll.getViewport().setBackground(Color.white);
			label=new JLabel("회원님들의 소중한 상품리뷰입니다^^");
			
			
			table.getColumnModel().getColumn(0).setPreferredWidth(1); // 번호
			table.getColumnModel().getColumn(1).setPreferredWidth(130); // 상품명
			table.getColumnModel().getColumn(2).setPreferredWidth(140); //한줄평
			table.getColumnModel().getColumn(3).setPreferredWidth(20);//별점
			table.getColumnModel().getColumn(4).setPreferredWidth(6);//작성자

			
			table.getTableHeader().setReorderingAllowed(false); // 컬럼이동불가능.
			
			List<ReviewDTO> list=CosmeticDAO.getInstance().getReview();
			for(int i=0;i<list.size();i++) {
				String[] dd=new String[5];
				dd[0]=String.valueOf(i+1);
				dd[1]=list.get(i).getProduct_name();
				dd[2]=list.get(i).getReview();
				dd[3]=list.get(i).getStar();
				dd[4]=list.get(i).getName();
				model.addRow(dd);
			}
			
			add(label,BorderLayout.NORTH);
			add(scroll,BorderLayout.CENTER);
			setSize(600,500);
			this.getContentPane().setBackground(Color.white);
			setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			
			Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
			Dimension f_size = super.getSize();
			int xpos = (int) (screen.getWidth() / 2 - f_size.getWidth() / 2);
			int ypos = (int) (screen.getHeight() / 2 - f_size.getHeight() / 2);
			setLocation(xpos, ypos);
			
	}

}
