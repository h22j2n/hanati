package project_mini;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;


public class First_find extends JFrame implements ActionListener,ItemListener{
   project_mini.TableP tp; //검색시 append 될 창을 담은 변수
   JLabel numl; JLabel genl; JLabel funcl;
   JLabel catel;
   JLabel pricel;
   JLabel agel;
   JLabel brandl;JLabel brandl2;
   JLabel empty;
   JCheckBox [] catec =new JCheckBox[6];
   JCheckBox [] pricec =new JCheckBox[5];
   JCheckBox [] agec =new JCheckBox[5];
   JCheckBox [] brandc =new JCheckBox[11];
   JCheckBox [] funcc =new JCheckBox[6];
   JPanel table;
   JTextArea ta,tao;
   JRadioButton wo;JRadioButton ma;JRadioButton woma;
   JComboBox<String> brandco;
   JTable table2;
   String[] brands = new String[] {"기타","게리쏭","겔랑","고위드미","궁중비책","그린핑거","글램글로우",
   "니베아","헤라","후","베네피트"};
   JPanel panel1;
   JPanel panel2;
   JPanel pan1;JPanel pan2;JPanel pan3;
   JPanel pan4;JPanel pan5;JPanel pan6;JPanel pan7;
   JButton jb;
   String id="";
   
   First_find(String id){

   this.id = id;
   panel1= new JPanel();
   panel2= new JPanel();
      
      
      
   agel =new JLabel("연령대 :");
   catel =new JLabel("카테고리 :"); brandl =new JLabel("브랜드 :"); brandl2 =new JLabel("기타");
   pricel =new JLabel("가격대 :");  genl =new JLabel("성별 :");
   funcl =new JLabel("기능 :"); 
   
   
   pan1=new JPanel(); //카테고리
   //pan1.add(catel);
   pan1.setBorder(new TitledBorder("카테고리"));
   catec[0]=new JCheckBox("전체");catec[1]=new JCheckBox("스킨");
   catec[2]=new JCheckBox("로션");catec[3]=new JCheckBox("선케어");
   catec[4]=new JCheckBox("클렌징");catec[5]=new JCheckBox("립제품");
   for(int i=0;i<catec.length;i++) 
   {
	  catec[i].setBackground(Color.white);
      pan1.add(catec[i]);
   }
   pan1.setBackground(Color.white);
   
   pan2=new JPanel();//연령대
   //pan2.add(agel);
   pan2.setBorder(new TitledBorder("연령대"));
     agec[0]=new JCheckBox("전연령");agec[1]=new JCheckBox("10대");
      agec[2]=new JCheckBox("20대");agec[3]=new JCheckBox("30대");
      agec[4]=new JCheckBox("40대 이상");
      for(int i=0;i<agec.length;i++) 
      {
    	  agec[i].setBackground(Color.white);
         pan2.add(agec[i]);
      }
   pan2.setBackground(Color.white);
      
   pan3=new JPanel();//가격
   //pan3.add(pricel);
   pan3.setBorder(new TitledBorder("가격대"));
   pricec[1]=new JCheckBox("30000원 ~");pricec[2]=new JCheckBox("40000원 ~");
   pricec[3]=new JCheckBox("50000원 ~");pricec[4]=new JCheckBox("60000원~");
   pricec[0]=new JCheckBox("0원~");
   for(int i=0;i<pricec.length;i++) 
   {
	  pricec[i].setBackground(Color.white);
      pan3.add(pricec[i]);
   }
   pan3.setBackground(Color.white);
   
   pan4=new JPanel();//성별 라디오 박스
   //pan4.add(genl);
   pan4.setBorder(new TitledBorder("성별"));
   wo=new JRadioButton("여성",true); ma=new JRadioButton("남성"); woma=new JRadioButton("공용");
   ButtonGroup genB =new ButtonGroup();
   genB.add(wo);genB.add(ma);genB.add(woma);
   pan4.add(wo);pan4.add(ma);pan4.add(woma);
   pan4.setBackground(Color.white);
   wo.setBackground(Color.white);
   ma.setBackground(Color.white);
   woma.setBackground(Color.white);
   
   //pan4.add(brandl);
   
   pan5=new JPanel();//브랜드
   //pan5.add(brandl);
   pan5.setBorder(new TitledBorder("브랜드"));
   brandc[1]=new JCheckBox("샤넬");brandc[2]=new JCheckBox("디올");brandc[3]=new JCheckBox("시세이도");
   brandc[4]=new JCheckBox("키엘");brandc[5]=new JCheckBox("설화수");brandc[6]=new JCheckBox("입생로랑");
   brandc[7]=new JCheckBox("랑콤");brandc[8]=new JCheckBox("겐조");brandc[9]=new JCheckBox("가네보");brandc[10]=new JCheckBox("에스케이투");
   for(int i=1;i<11;i++) 
   {
	  brandc[i].setBackground(Color.white);
      pan5.add(brandc[i]);
   }
   pan5.setBackground(Color.white);
      
   //pan6=new JPanel();//브랜드 + 기타
   
   empty = new JLabel("             ");//브랜드 간격 맞추기
   /*pan6.add(empty);
   pan6.add(brandc[7]);pan6.add(brandc[8]);pan6.add(brandc[9]);pan6.add(brandc[10]);
   //brand 기타
*/ 
   brandco =new JComboBox<String>(brands); 
   pan5.add(brandco);
   pan5.setLayout(new GridLayout(3, 1));
   
   pan7=new JPanel();//user_type
   //pan7.add(funcl);   
   pan7.setBorder(new TitledBorder("기능"));
   funcc[0]=new JCheckBox("건성");funcc[1]=new JCheckBox("지성");
   funcc[2]=new JCheckBox("복합성");funcc[3]=new JCheckBox("여드름성");
   funcc[4]=new JCheckBox("아토피성");funcc[5]=new JCheckBox("모든피부");
   for(int i=0;i<funcc.length;i++) 
   {
	  funcc[i].setBackground(Color.white);
      pan7.add(funcc[i]);
   }
   pan7.setBackground(Color.white);
   
   jb=new JButton("검색");//검색버튼
   jb.setLocation(250,250);
   ta = new JTextArea(5,50);//sql표시창(invisiable)
   ta.setText(" where user_sex like ( '%" + wo.getText() +"%'");
   ta.setVisible(false);
   tao = new JTextArea(2,40);//선택 항목 표시창
   tao.setText(" 여성전용 ");
   
   panel1.setLayout(new FlowLayout(FlowLayout.LEFT));
   setLayout(new GridLayout(5,1));
   panel1.add(pan1);panel1.add(pan2);//add(pan3);
   panel1.add(pan3);panel1.add(pan4);panel1.add(pan5);
   //panel1.add(pan6);
   panel1.add(pan7);
   panel1.setBackground(Color.white);
   //panel2.add(tao);
   
   //panel2.setLayout();
   panel2.add(jb);
   jb.setBackground(Color.white);
   panel2.setBackground(Color.white);
   //panel2.add(ta);
   
   
   setLayout(new BorderLayout());
   add(panel1,BorderLayout.CENTER);
   add(panel2,BorderLayout.SOUTH);
   
   
  //리스너
   jb.addActionListener(this);
  for(int i=0; i <agec.length; i++) {
   agec[i].addItemListener(this);
  }
  for(int i=0; i <catec.length; i++) {
     catec[i].addItemListener(this);
  }
  
  for(int i=0; i <pricec.length; i++) {
     pricec[i].addItemListener(this);
  }
  for(int i=1; i <brandc.length; i++) {
     brandc[i].addItemListener(this);
  }
  wo.addItemListener(this);
  ma.addItemListener(this);
  woma.addItemListener(this);
  brandco.addItemListener(this);
  for(int i=0; i <funcc.length; i++) {
     funcc[i].addItemListener(this);
  }

   setSize(500, 600);
   setVisible(true);
   setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
   
// 모니터의 가운데 정렬
   Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
   Dimension f_size = super.getSize();
   int xpos = (int) (screen.getWidth() / 2 - f_size.getWidth() / 2);
   int ypos = (int) (screen.getHeight() / 2 - f_size.getHeight() / 2);
   setLocation(xpos+400, ypos);

   }//end first_find()
   
   
   @Override
   public void itemStateChanged(ItemEvent e) {
      // TODO Auto-generated method stub
      ta.setText("");
      int k =0;
      if(wo.isSelected()) {
         
         ta.setText(" where user_sex like ( '%" + wo.getText() +"%'");
         tao.setText("");
         tao.append(" 여성전용 ");
     }else if(ma.isSelected()) {
          ta.setText("");
        ta.append(" where user_sex like ( '%" + ma.getText() +"%'");
        tao.setText("");
        tao.append(" 남성전용 ");
     }else if(woma.isSelected()) {
          ta.setText("");
        ta.append(" where user_sex like ( '%" + woma.getText() +"%'");
        tao.setText("");
        tao.append(" 남여공용 ");
     }
    
      for( int i = 1; i<catec.length;i++) {   
      if(catec[i].isSelected()) {
       tao.append(" " + catec[i].getText()+ " ");
       if(k==0) {
          ta.append(" ) and ( product_category like '%" + catec[i].getText() + "%'");
          
          k++;
       }else {      
                ta.append(" or product_category like '%" + catec[i].getText()+"%'");   
             }
      }
    }
      
    k=0;
    if(catec[0].isSelected()) {
       for(int i=0; i<catec.length;i++)
       catec[i].setSelected(true);
    }
    
    k=0;
  for( int i = 1; i <agec.length;i++) {   
    if(agec[i].isSelected()) {
       tao.append(" " + agec[i].getText()+ " ");
       if(k==0) {
          ta.append(" ) and (user_age like '%" + agec[i].getText().substring(0,2) + "%'");
          k++;
       }else {
           ta.append(" or user_age like '%" + agec[i].getText().substring(0,2) +"%'");

        }   
    }
    }
  
  if(agec[0].isSelected()) {
     for(int i=0; i<agec.length;i++)
     agec[i].setSelected(true);
  }  
  
  k=0;
  
  for(int i = 1; i<pricec.length;i++) {
     if(pricec[i].isSelected()) {
       
        if(k==0) {
          ta.append(" ) and ( product_price >=" + pricec[i].getText().substring(0, 5));
           tao.append(" " + pricec[i].getText().substring(0, 6)+ " " + "이상" +" " );
        }
     }
  }
  k=0;
  
  if(pricec[0].isSelected()) {
     tao.append(" " + "전체가격" + " ");
     if(k==0) {
          ta.append(" ) and ( product_price >=" + 0);
        }else {
           ta.append(" ) or ( product_price >=" + 0);
        }
  }
 
  k=0;
  
  if(brandco.getSelectedIndex() != 0) {
     ta.append(" ) and (brand_name = '" + brandco.getSelectedItem()+"'");
     tao.append(" " + brandco.getSelectedItem()+ " ");
     k++;
  }
  for( int i = 1; i <brandc.length;i++) {   
     if(brandc[i].isSelected()) {
        tao.append(" " + brandc[i].getText()+ " ");
        if(k==0) {
             ta.append(" ) and (brand_name = '" + brandc[i].getText()+"'");
             k++;
          }else {
              ta.append(" or brand_name = '" + brandc[i].getText()+"'");
           }   
       }
       }

  k=0;
  
  for( int i = 0; i<funcc.length;i++) {   
     
     if(funcc[i].isSelected()) {
        tao.append(" " + funcc[i].getText()+ " ");
          if(k==0) {
             ta.append(") and ( user_type like '%" + funcc[i].getText() + "%'");
             k++;
          }else {      
                   ta.append(" or user_type like '%" + funcc[i].getText()+"%'");   
                }
       } 
       }
  
   }//end itemlistner

   @Override
   public void actionPerformed(ActionEvent e) {
      Object obj = e.getSource();
      if(obj == jb) {
    	  
    	  tp = new TableP(id);
    	  tp.setVisible(true);
    	  findMethod();
      }
   }//end actionlistner
   
   private void findMethod() {
     //카테고리 단일
	    
      int i = 0;
      String word;   
      word = ta.getText() + ") order by brand_name asc";
      init();
      
      tp.setVisible(true);
      
      CosmeticDAO dao = CosmeticDAO.getInstance();
     
         dao.searchMethod(word);
         List<CosmeticDTO> aList = dao.searchMethod(word);
         Vector map = null;  
         for(CosmeticDTO dto:aList) {
            map = new Vector(8);
 
            map.add(dto.getProduct_category());
            map.add( dto.getProduct_name());
            map.add(dto.getProduct_price());
            map.add( dto.getBrand_name());
            map.add( dto.getUser_sex());
            tp.model.addRow(map);
         }
         tp.jf.setText("제품명을 입력하세요.");
         if(aList.isEmpty()) {
             //tp.model.setRowCount(0);
             tp.setVisible(false);
             JOptionPane.showMessageDialog(this, "해당 제품이 존재하지 않습니다.");
         }
}//end findMethod

private void init() {
   for(int i=0; i<catec.length;i++)
       catec[i].setSelected(false);
   for(int i=0; i<agec.length;i++)   
   agec[i].setSelected(false);
   for(int i=0; i<pricec.length;i++) {
      pricec[i].setSelected(false);
   }
   wo.setSelected(true);
   for(int i=1; i<brandc.length;i++) {
       brandc[i].setSelected(false);
   }
   for(int i=0; i<funcc.length;i++) {
      funcc[i].setSelected(false);
   }
   brandco.setSelectedIndex(0);
}//end init() 선택항목 초기화
	
	private void clearMethod() {
		tp.model.setRowCount(0);
	}
}//end init() model초기화


 

