package project_mini;
import java.awt.Color;
import java.awt.Graphics;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Info1 extends JFrame { 
   String sql;
   CosmeticDAO dao;
   public Info1(String type) { 
     
	  dao = CosmeticDAO.getInstance();
      setTitle("상세정보");
      sql="product_id like '%" + type +"%'";
      List<CosmeticDTO> list=dao.searchMethod2(sql);
      
     
     //image 
      ImageIcon img = new ImageIcon(list.get(0).getImage());
     JLabel imglab = new JLabel(img);
     setLayout(null);
     int n = 0;
     int m = 10;
     imglab.setBounds(n, m, 500, 280);
     add(imglab);

     //te
      JLabel te1 = new JLabel("이름 : "); 
      setLayout(null); 
      int x = 30; 
      int y = 300; 
      te1.setBounds(x, y, 100, 100); 
      add(te1); 
      
      
      JLabel te2 = new JLabel("카테고리 : "); 
      setLayout(null); 
      int q = 30; 
      int w = 330; 
      te2.setBounds(q, w, 100, 100); 
      add(te2); 
      
      JLabel te3 = new JLabel("가격 : "); 
      setLayout(null); 
      int e = 30; 
      int r = 360; 
      te3.setBounds(e, r, 100, 100); 
      add(te3); 
      
      JLabel te4 = new JLabel("브랜드 : "); 
      setLayout(null); 
      int t = 30; 
      int i = 390; 
      te4.setBounds(t, i, 100, 100); 
      add(te4); 
      
      JLabel te5 = new JLabel("성별 : "); 
      setLayout(null); 
      int a = 30; 
      int s = 420; 
      te5.setBounds(a, s, 100, 100); 
      add(te5); 
      
      JLabel te6 = new JLabel("나이 : "); 
      setLayout(null); 
      int d = 30; 
      int f = 450; 
      te6.setBounds(d, f, 100, 100); 
      add(te6); 
      
      JLabel te7 = new JLabel("피부타입 : "); 
      setLayout(null); 
      int g = 30; 
      int h = 480; 
      te7.setBounds(g, h, 100, 100); 
      add(te7); 
      

      //tf
      JLabel tf1 = new JLabel();
      setLayout(null);
      int v = 110;
      int z = 340;
      tf1.setBounds(v,z,350,20);
      tf1.setText(list.get(0).getProduct_name());
      add(tf1);
      
      JLabel tf2 = new JLabel();
      setLayout(null);
      int aa = 370;
      tf2.setBounds(v,aa,350,20);
      tf2.setText(list.get(0).getProduct_category());
      add(tf2);
      
      JLabel tf3 = new JLabel();
      setLayout(null);
      int ab = 400;
      tf3.setBounds(v,ab,350,20);
      tf3.setText(String.valueOf(list.get(0).getProduct_price()));
      add(tf3);
      
      JLabel tf4 = new JLabel();
      setLayout(null);
      int ac = 430;
      tf4.setBounds(v,ac,350,20);
      tf4.setText(list.get(0).getBrand_name());
      add(tf4);
      
      JLabel tf5 = new JLabel();
      setLayout(null);
      int ad = 460;
      tf5.setBounds(v,ad,350,20);
      tf5.setText(list.get(0).getUser_sex());
      add(tf5);
      
      JLabel tf6 = new JLabel();
      setLayout(null);
      int ae = 490;
      tf6.setBounds(v,ae,350,20);
      tf6.setText(list.get(0).getUser_age());
      add(tf6);
      
      JLabel tf7 = new JLabel();
      setLayout(null);
      int af = 520;
      tf7.setBounds(v,af,350,20);
      tf7.setText(list.get(0).getUser_type());
      add(tf7);
      
      te1.setBackground(Color.white);te2.setBackground(Color.white);te3.setBackground(Color.white);
      te4.setBackground(Color.white);te5.setBackground(Color.white);te6.setBackground(Color.white);
      te7.setBackground(Color.white);
      
      setSize(500, 600); 
      setVisible(true);
      this.getContentPane().setBackground(Color.white); // 프레임의 컨테이너를 받아와서 배경색 변경
      setDefaultCloseOperation(DISPOSE_ON_CLOSE); 

   } 

   } 
