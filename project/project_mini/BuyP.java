package project_mini;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class BuyP extends JFrame implements ActionListener{
      JLabel label,label1,label2,label3,label4,label5;
      JTextField jt,pointF,price,mypoint;
      JComboBox<Integer> count; 
      JPanel bigPan,pan,pan1,pan2,pan3,pan4;
      JButton buy,no,jj;
      Integer[] in= {1,2,3,4,5};
      
      CosmeticDAO dao=CosmeticDAO.getInstance();
      
      String id="";
      String product_name="";
      int product_price;
      int nproduct_price;
      int myP;
      int point;
      int npoint;
   BuyP(String id,String pro){
      this.id=id; this.product_name=pro;
      
      pan=new JPanel();
      label=new JLabel("******구매하기******");
      pan.add(label);
      pan1=new JPanel();
      label1=new JLabel("상품명");jt=new JTextField(20);
      label2=new JLabel("수량");   count=new JComboBox<Integer>(in); 
      pan1.add(label1);pan1.add(jt);pan1.add(label2);pan1.add(count);
      
      
      pan2=new JPanel();
      label3=new JLabel("포인트사용");pointF=new JTextField(7);
      pointF.setText(String.valueOf(0));
      jj=new JButton("적용");
      label5=new JLabel("나의 포인트");mypoint=new JTextField(7);
      pan2.add(label3);pan2.add(pointF);pan2.add(jj);pan2.add(label5);pan2.add(mypoint);
      
      pan3=new JPanel();
      label4 =new JLabel("최종결제금액");
      price =new JTextField(7);
      pan3.add(label4);pan3.add(price);
      
      pan4=new JPanel();
      buy=new JButton("구매");no=new JButton("취소");
      pan4.add(buy);pan4.add(no);
      

      bigPan =new JPanel(); bigPan.setLayout(new GridLayout(4, 1));
      bigPan.add(pan);bigPan.add(pan1);bigPan.add(pan2);bigPan.add(pan3);
      add(bigPan);add(pan4,BorderLayout.SOUTH);
      
      pan.setBackground(Color.WHITE);
      pan1.setBackground(Color.WHITE);
      pan2.setBackground(Color.WHITE);
      pan3.setBackground(Color.WHITE);
      pan4.setBackground(Color.WHITE);
      buy.setBackground(Color.WHITE);
      no.setBackground(Color.WHITE);
      jj.setBackground(Color.WHITE);
      count.setBackground(Color.WHITE);
      ///////////////////////////////////////////////////////////////////////////
      jt.setText(pro);
      myP=dao.getCli(id).getPoint();
      mypoint.setText(String.valueOf(myP));
      product_price=dao.searchCo(pro).getProduct_price();
      price.setText(String.valueOf(product_price));
      
      nproduct_price=product_price;
      npoint=myP;
      
      ///액션리스너///////////////////////////////////////////////////////////////////////////
      count.addActionListener(this);
      jj.addActionListener(this);
      buy.addActionListener(this);
      no.addActionListener(this);
      ////클래스//////////////////////////////////////////////////////////////////////////////////
      
      Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
      Dimension f_size = super.getSize();
      int xpos = (int) (screen.getWidth() / 2 - f_size.getWidth() / 2);
      int ypos = (int) (screen.getHeight() / 2 - f_size.getHeight() / 2);
      setLocation(xpos+100, ypos-250);

      setDefaultCloseOperation(DISPOSE_ON_CLOSE);
      setVisible(true);
      setSize(400,300);
   }
@Override
   public void actionPerformed(ActionEvent e) {
   Object obj=e.getSource();
      if(obj==count) {
         
         
         price.setText(String.valueOf(product_price));
         if(count.getSelectedIndex()==0) {//1개
            nproduct_price=product_price;
         }if(count.getSelectedIndex()==1) {//2개
            nproduct_price=product_price*2;
            price.setText(String.valueOf(nproduct_price));
         }if(count.getSelectedIndex()==2) {//3개
            nproduct_price=product_price*3;
            price.setText(String.valueOf(nproduct_price));
         }if(count.getSelectedIndex()==3) {
            nproduct_price=product_price*4;
            price.setText(String.valueOf(nproduct_price));
         }if(count.getSelectedIndex()==4) {
            nproduct_price=product_price*5;
            price.setText(String.valueOf(nproduct_price));
         }
         
         
      }if(obj==jj) {
         int po =Integer.valueOf(pointF.getText());
         if(po>myP) {
            return;
         }
         price.setText(String.valueOf(nproduct_price-po));
         npoint=npoint-po;
         
      }if(obj==buy) {
    	  dao.upBuy(dao.getCli(id), dao.searchCo(product_name), count.getSelectedIndex()+1,id);
            dao.pointCli(id,(int)(npoint+nproduct_price*0.005));
          
            JOptionPane.showMessageDialog(this, "좋은 상품으로 보내드리겠습니다^^");
            setVisible(false);
         
          
         }
      if(obj==no) {
    	  JOptionPane.showMessageDialog(this, "구매를 취소합니다");
    	  setVisible(false);
      }
   }


}