package project_mini;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TableP extends JFrame implements ActionListener, MouseListener{
	
	
	JTable table;
	JScrollPane scroll;
	DefaultTableModel model;
	JPanel jp,jp2;
	JTextField jf;
	JButton jb1,jb2,jb3,jb4;
	  SearchP sp;
	  BuyP buy;
	String [] dd = new String[8];
	String id;
	
	 TableP(String id){
		 this.id = id;
		//윗 패널 (검색창,검색버튼,상세검색버튼)
		jp=new JPanel();
		jf=new JTextField(20);jb1=new JButton("상품명 검색"); jb2=new JButton("상세검색"); 
		
		jp.add(jf);jp.add(jb1);jp.add(jb2);
		sp=new SearchP();

		
		//테이블
	      String[] st= {"종류","이름","가격","브랜드","성별"};
	      
			model = new DefaultTableModel(st, 0) {
				public boolean isCellEditable(int row, int col) {
					return false;
				}
			}; 
			table = new JTable(model);
			scroll = new JScrollPane(table);
			scroll.getViewport().setBackground(Color.white);
			
			
			table.setRowHeight(20); // 라인의 높이
			table.setBackground(Color.white);
																	
			table.getColumnModel().getColumn(0).setPreferredWidth(30); // 종류
			table.getColumnModel().getColumn(1).setPreferredWidth(200); //이름
			table.getColumnModel().getColumn(2).setPreferredWidth(15);//가격
			table.getColumnModel().getColumn(3).setPreferredWidth(15);//브랜드
			table.getColumnModel().getColumn(4).setPreferredWidth(15);//성별
			
			table.getTableHeader().setReorderingAllowed(false); // 컬럼이동불가능.

			jp2=new JPanel();
			jb3=new JButton("상세정보");jb4=new JButton("구매하기");
			
			
			jp2.add(jb3);
			jp2.add(jb4);
			//액션리스너
			jb1.addActionListener(this);
			jb2.addActionListener(this);
			jb3.addActionListener(this);
			jb4.addActionListener(this);
			jf.addActionListener(this);
			sp.jb.addActionListener(this);
			jf.addMouseListener(this);
			add(jp,BorderLayout.NORTH);
			add(scroll,BorderLayout.CENTER);
			add(jp2,BorderLayout.SOUTH);
			
			jp.setBackground(Color.WHITE);jp2.setBackground(Color.WHITE);
			jb1.setBackground(Color.WHITE);jb2.setBackground(Color.WHITE);
			jb3.setBackground(Color.WHITE);jb4.setBackground(Color.WHITE);
			
			setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			setSize(700,500);
			
			// 모니터의 가운데 정렬
		      Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		      Dimension f_size = super.getSize();
		      int xpos = (int) (screen.getWidth() / 2 - f_size.getWidth() / 2);
		      int ypos = (int) (screen.getHeight() / 2 - f_size.getHeight() / 2);
		      setLocation(xpos-300, ypos);
			
		}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj=e.getSource();
		if(obj==jb1||obj==jf) {//상품명검색
			String sql="lower(product_name) like lower('%"+jf.getText()+"%')";
			List<CosmeticDTO> list=CosmeticDAO.getInstance().searchMethod2(sql);
			sqlMethod(list);
			if(list.isEmpty()) {
				JOptionPane.showMessageDialog(this, "해당 제품이 존재하지 않습니다.");
				jf.setText("제품명을 입력하세요.");
			}else {
				jf.setText("제품명을 입력하세요.");
			}
			
		}if(obj==jb2) {//상세검색
			  inini();
			  sp.setVisible(true);

		}if(obj==sp.jb) {
			List<CosmeticDTO> list=	CosmeticDAO.getInstance().searchMethod2(sp.makeSql());
			sqlMethod(list);
			if(list.isEmpty())
				JOptionPane.showMessageDialog(this, "해당 제품이 존재하지 않습니다.");
			else
				return;
			
		}if(obj ==jb3 ) {
			int check = table.getSelectedRow();
	          //System.out.println(check);
			if(check<0) {
				JOptionPane.showMessageDialog(this, "제품을 선택하세요.");
			}else {
	          String p = String.valueOf(model.getValueAt(check, 1));
	          String sql="product_name like '%" + p +"%'";
	          List<CosmeticDTO> list=CosmeticDAO.getInstance().searchMethod2(sql);
	          //System.out.println(list.get(0).getProduct_id());
	          String ql = String.valueOf(list.get(0).getProduct_id());
	          Info1 ss = new Info1(ql);
			}
		}if(obj ==  jb4) {
			if(table.getSelectedRow()<0) {JOptionPane.showMessageDialog(this, "제품을 선택하세요.");}
			else {
			buy=new BuyP(id,String.valueOf(table.getValueAt(table.getSelectedRow(), 1)));
			}
		}
	}
	
	
	public void sqlMethod(List<CosmeticDTO> list){
		model.setRowCount(0);

		for(CosmeticDTO toto : list) {	
			
		dd[0] =toto.getProduct_category();
		dd[1] =toto.getProduct_name();
		dd[2] =String.valueOf(toto.getProduct_price());
		dd[3] =toto.getBrand_name();
		dd[4] =toto.getUser_sex();
		model.addRow(dd);
		}
		jf.setText("제품명을 입력하세요.");
		
	
	}
	
	 public void inini() {
		 /*      for(int i=0;i<sp.catec.length;i++)
		          sp.catec[i].setSelected(false);*/ 
		       for(int i=0;i<sp.pricec.length;i++)
		       sp.pricec[i].setSelected(false);
		       for(int i=0;i<sp.agec.length;i++)
		          sp.agec[i].setSelected(false);
		       for(int i=0;i<sp.brandc.length;i++)
		          sp.brandc[i].setSelected(false);
		       for(int i=0;i<sp.funcc.length;i++)
		          sp.funcc[i].setSelected(false);
		       sp.wo.setSelected(true);
		       sp.brandco.setSelectedIndex(0);
		       
		       
		    }


	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		jf.setText("");
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
