package project_mini;

import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import javax.swing.*;


public class First_display extends JFrame implements ActionListener, MouseListener {
   JTextField search;
   JButton btnSearch, join, logout;
   JButton ffirbtn, fsebtn, fthbtn, sfirbtn, ssebtn, stnbtn, myBtn, modiBtn, reBtn;
   ImageIcon image;
   JLabel Ilabel, hello;
   JPanel jPanel1, jPanel2, jPanel3, jPanel4, j4nel5;
   GridBagConstraints c;

   Login login;// 로그인버튼
   String myname = "비회원", id = "비회원";// 이름이랑 아이디
   MyP my;// 마이페이지
   ModiP modi;// 회원정보 변경
   SearchP sp;
   TableP tp;
   CosmeticDAO dao = CosmeticDAO.getInstance();
   
   First_display() {

      // 상단
      setTitle("JH COSMETIC");
      search = new JTextField(22);
      btnSearch = new JButton("검색");
      join = new JButton("로그인");
      logout = new JButton("로그아웃");
      myBtn = new JButton("마이페이지");
      modiBtn = new JButton("회원정보수정");
      hello = new JLabel("[JHC] 비회원님 안녕하세요");
      reBtn = new JButton("상품평");
      /////////////////// 로그인 후에 화면뜨기
      myBtn.setVisible(false);
      modiBtn.setVisible(false);
      logout.setVisible(false);
      ////////////////////////////

      ////////////
      join.setBackground(Color.WHITE);
      btnSearch.setBackground(Color.WHITE);
      reBtn.setBackground(Color.WHITE);
      logout.setBackground(Color.WHITE);
      myBtn.setBackground(Color.WHITE);
      modiBtn.setBackground(Color.WHITE);
      
      
      
      // join.setBorderPainted(false);
      //////////
      jPanel1 = new JPanel();
      jPanel1.setLayout(new FlowLayout());
      jPanel1.add(hello);
      jPanel1.add(join);
      jPanel1.add(myBtn);
      jPanel1.add(modiBtn);
      jPanel1.add(reBtn);
      jPanel1.add(logout);
      jPanel1.setBounds(0, 0, 600, 45);

      jPanel1.setBackground(Color.white);
      jPanel2 = new JPanel();
      jPanel2.add(search);
      search.setText("제품명을 입력하세요.");
      jPanel2.add(btnSearch);
      jPanel2.setBounds(0, 50, 600, 50);

      jPanel2.setBackground(Color.pink);

      // jPanel1.setBounds(165, 0, 400, 50);

      jPanel3 = new JPanel();
      // 이미지 넣는거
      image = new ImageIcon("src/project_mini/pink.jpg");
      Ilabel = new JLabel(image);
      jPanel3.add(Ilabel);
      jPanel3.setBounds(0, 99, 600, 400);
      jPanel3.setBackground(Color.white);

      jPanel4 = new JPanel();
      ffirbtn = new JButton(new ImageIcon("src/project_mini/CUSTOM3.jpg"));
      fsebtn = new JButton(new ImageIcon("src/project_mini/RSSIN.jpg"));
      fthbtn = new JButton(new ImageIcon("src/project_mini/RO2.jpg"));
      sfirbtn = new JButton(new ImageIcon("src/project_mini/SUNCARE.jpg"));
      ssebtn = new JButton(new ImageIcon("src/project_mini/RIP.jpg"));
      stnbtn = new JButton(new ImageIcon("src/project_mini/CLEAN.jpg"));

      ffirbtn.setBorderPainted(false);
      fsebtn.setBorderPainted(false);
      fthbtn.setBorderPainted(false);
      sfirbtn.setBorderPainted(false);
      ssebtn.setBorderPainted(false);
      stnbtn.setBorderPainted(false);

      /////// 마우스 리스너
      ffirbtn.addMouseListener(this);
      fsebtn.addMouseListener(this);
      fthbtn.addMouseListener(this);
      sfirbtn.addMouseListener(this);
      ssebtn.addMouseListener(this);
      stnbtn.addMouseListener(this);
      search.addMouseListener(this);
      // 버튼 컬러
      ffirbtn.setBackground(Color.WHITE);
      fsebtn.setBackground(Color.white);
      fthbtn.setBackground(Color.white);
      sfirbtn.setBackground(Color.white);
      ssebtn.setBackground(Color.white);
      stnbtn.setBackground(Color.white);

      jPanel4.setLayout(new GridLayout(2, 3));
      jPanel4.add(ffirbtn);
      jPanel4.add(fsebtn);
      jPanel4.add(fthbtn);
      jPanel4.add(sfirbtn);
      jPanel4.add(ssebtn);
      jPanel4.add(stnbtn);
      jPanel4.setBounds(0, 500, 600, 200);

      add(jPanel1);
      add(jPanel2);
      add(jPanel3);
      add(jPanel4);

      ///////////////////////// 클래스/////////////////////////////////////////
      login = new Login();
      my = new MyP(myname);
      modi = new ModiP();
      sp = new SearchP();
      tp = new TableP(id);

      // 액션리스너
      join.addActionListener(this);
      login.loginB.addActionListener(this);
      login.jt2.addActionListener(this); // 로그인 창 로그인 버튼ㅇㅇ
      logout.addActionListener(this);
      reBtn.addActionListener(this);
      myBtn.addActionListener(this);
      modiBtn.addActionListener(this);
      modi.jb1.addActionListener(this);
      ffirbtn.addActionListener(this);
      fsebtn.addActionListener(this);
      fthbtn.addActionListener(this);
      sfirbtn.addActionListener(this);
      ssebtn.addActionListener(this);
      stnbtn.addActionListener(this);
      btnSearch.addActionListener(this);
      search.addActionListener(this);

      setLayout(null);
      setSize(600, 735);
      setVisible(true);
      // setBackground(Color.white);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      // 모니터의 가운데 정렬
      Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
      Dimension f_size = super.getSize();
      int xpos = (int) (screen.getWidth() / 2 - f_size.getWidth() / 2);
      int ypos = (int) (screen.getHeight() / 2 - f_size.getHeight() / 2);
      setLocation(xpos, ypos);

   }

   @Override
   public void actionPerformed(ActionEvent e) {
      Object obj = e.getSource();
      tp.jf.setText("");
      tp.model.setRowCount(0);
      for (int i = 0; i < tp.sp.catec.length; i++)
         tp.sp.catec[i].setSelected(false);
      if (obj == ffirbtn) {
    	  First_find ffin = new First_find(id);
      }
      if (obj == fsebtn) {
         tp.sqlMethod(dao.searchMethod2(" product_category like '%스%'"));
         tp.setVisible(true);
         tp.sp.catec[0].setSelected(true);
      }
      if (obj == fthbtn) {
         tp.sqlMethod(dao.searchMethod2(" product_category like '%로%'"));
         tp.setVisible(true);
         tp.sp.catec[1].setSelected(true);
      }
      if (obj == sfirbtn) {
         tp.sqlMethod(dao.searchMethod2(" product_category like '%선%'"));
         tp.setVisible(true);
         tp.sp.catec[2].setSelected(true);
      }
      if (obj == ssebtn) {
         tp.sqlMethod(dao.searchMethod2(" product_category like '%립%'"));
         tp.setVisible(true);
         tp.sp.catec[4].setSelected(true);
      }
      if (obj == stnbtn) {
         tp.sqlMethod(dao.searchMethod2(" product_category like '%클%'"));
         tp.setVisible(true);
         tp.sp.catec[3].setSelected(true);
      }
      if (obj == join) {
         login.setVisible(true);
      }
      if (obj == login.loginB || obj == login.jt2) {
         try {
            if (dao.check(login.jt.getText(), login.jt2.getText())) {// 로그인 확인
               id = login.jt.getText();        
               setWithId();
               login.setVisible(false);
               join.setVisible(false);
               myBtn.setVisible(true);
               modiBtn.setVisible(true);
               logout.setVisible(true);
            }else JOptionPane.showMessageDialog(this, "아이디와 비밀번호를 확인해주세요..");
         } catch (ClassNotFoundException | SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
         }

      }
      if (obj == logout) {
         // login.setVisible(true);
         join.setVisible(true);
         myBtn.setVisible(false);
         modiBtn.setVisible(false);
         logout.setVisible(false);
         login.jt.setText("");
         login.jt2.setText("");
         hello.setText("[JHC] 비회원님 안녕하세요");
      }
      if (obj == reBtn) {
         new ReviewP().setVisible(true);
      }
      if (obj == myBtn) {
         setWithId();
    	  my.setVisible(true);
         
      }
      if (obj == modiBtn) {
         modi.setVisible(true);
         modi.jt1.setText(my.name.getText());
         modi.jt3.setText(my.address.getText());
      }
      if (obj == modi.jb1) {// 회원정보 수정 등록
         dao.modiCli(modi.jt1.getText(), modi.jt2.getText(), modi.jt3.getText(), id);
         setWithId();
         modi.setVisible(false);
      }
      if (obj == my.review2) { // 리뷰등록
         ReviewDTO dto = new ReviewDTO();
         int ko = my.table.getSelectedRow();
         String keke = my.table.getValueAt(ko, 2).toString();
         dto.setName(myname);
         dto.setProduct_name(keke);
         dto.setStar(my.star.getSelectedItem().toString());
         dto.setReview(my.comment.getText());
         CosmeticDAO.getInstance().upReview(dto);
         my.rr.setVisible(false);
      }
      if (obj == btnSearch || obj == search) {
    	  tp.sqlMethod(dao.searchMethod2(" product_name like '%" + search.getText() + "%'"));
          if(search.getText().equals("제품명을 입력하세요.") || search.getText().isEmpty() ) {
             JOptionPane.showMessageDialog(this, "제품명을 입력하세요.");
          }else {
          tp.setVisible(true);
          search.setText("");
          }
          
          if(tp.model.getRowCount() == 0) {
             tp.setVisible(false);
             JOptionPane.showMessageDialog(this, "해당하는 제품이 존재하지 않습니다.");
          }
      }
   }

   public void setWithId() {
	   //tableP,myP 이름 비회원에서 변경
	   tp.id=id; my.myname=myname;
       ClientDTO clidto = dao.getCli(id);
       myname = clidto.getName();
       id = clidto.getId();
       // 마이페이지 회원정보,첫화면 인사
       hello.setText(myname + "회원님 안녕하세요^^");
       my.id.setText(id);
       my.name.setText(myname);
       my.address.setText(clidto.getAddress());
       my.point.setText(String.valueOf(clidto.getPoint()));
       my.grade.setText(clidto.getGrade());

      // 마이페이지 구매내역
      List<CosmeticDTO> dto = dao.getBuyList(id);
      String[] kk = new String[4];
      my.model.setRowCount(0);
      int cnt = 0;
      for (CosmeticDTO dd : dto) {
         int ko;
         kk[0] = dd.getProduct_category();
         kk[1] = dd.getProduct_name();
         kk[2] = String.valueOf(ko = dd.getProduct_price());
         kk[3] = String.valueOf(dd.buy.getCount());
         cnt += ko;
         my.model.addRow(kk);
      }
      // 회원업그레이드
      if (cnt >= 500000)
         dao.upgCli("grade ='VVIP 회원'", id);
      else if (cnt >= 300000)
         dao.upgCli("grade ='VIP 회원'", id);
      else if (cnt >= 100000)
         dao.upgCli("grade ='크리스탈회원'", id);

   }

   public static void main(String[] args) {
      new First_display();
   }

   @Override
   public void mouseClicked(MouseEvent arg0) {
      Object obj = arg0.getSource();
      if(obj==search) {
    	  search.setText("");
      }

   }

   @Override
   public void mouseEntered(MouseEvent arg0) {
      Object obj = arg0.getSource();
      if (obj == ffirbtn) {
         URL imageurl = this.getClass().getResource("CCUSTOM.jpg");
         ImageIcon img = new ImageIcon(imageurl);
         ffirbtn.setIcon(img);
         ffirbtn.setText("");
         
      } else if (obj == fsebtn) {
         URL imageurl1 = this.getClass().getResource("CSKIN.jpg");
         ImageIcon img1 = new ImageIcon(imageurl1);
         fsebtn.setIcon(img1);
         fsebtn.setText("");
      } else if (obj == fthbtn) {
         URL imageurl2 = this.getClass().getResource("CROTION.jpg");
         ImageIcon img2 = new ImageIcon(imageurl2);
         fthbtn.setIcon(img2);
         fthbtn.setText("");
      } else if (obj == sfirbtn) {
         URL imageurl3 = this.getClass().getResource("CSUN.jpg");
         ImageIcon img3 = new ImageIcon(imageurl3);
         sfirbtn.setIcon(img3);
         sfirbtn.setText("");
      } else if (obj == ssebtn) {
         URL imageurl4 = this.getClass().getResource("CRIP.jpg");
         ImageIcon img4 = new ImageIcon(imageurl4);
         ssebtn.setIcon(img4);
         ssebtn.setText("");
      } else if (obj == stnbtn) {
         URL imageurl5 = this.getClass().getResource("CCLEAN.jpg");
         ImageIcon img5 = new ImageIcon(imageurl5);
         stnbtn.setIcon(img5);
         stnbtn.setText("");
      }
   }

   @Override
   public void mouseExited(MouseEvent arg0) {
      Object obj = arg0.getSource();
      if (obj == ffirbtn) {
         ffirbtn.setIcon(new ImageIcon("src/project_mini/CUSTOM3.jpg"));
         ffirbtn.setText("");
      } else if (obj == fsebtn) {
         fsebtn.setIcon(new ImageIcon("src/project_mini/RSSIN.jpg"));
         fsebtn.setText("");
      } else if (obj == fthbtn) {
         fthbtn.setIcon(new ImageIcon("src/project_mini/RO2.jpg"));
         fthbtn.setText("");
      } else if (obj == sfirbtn) {
         sfirbtn.setIcon(new ImageIcon("src/project_mini/SUNCARE.jpg"));
         sfirbtn.setText("");
      } else if (obj == ssebtn) {
         ssebtn.setIcon(new ImageIcon("src/project_mini/RIP.jpg"));
         ssebtn.setText("");
      } else if (obj == stnbtn) {
         stnbtn.setIcon(new ImageIcon("src/project_mini/CLEAN.jpg"));
         stnbtn.setText("");
      }
   }

   @Override
   public void mousePressed(MouseEvent arg0) {

   }

   @Override
   public void mouseReleased(MouseEvent arg0) {

   }

}