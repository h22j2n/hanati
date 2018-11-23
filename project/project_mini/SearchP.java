package project_mini;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.*;


public class SearchP extends JFrame implements ItemListener{
	 JLabel numl,genl,funcl,catel,pricel,agel,brandl,brandl2;
	   JCheckBox[] catec = new JCheckBox[6];
	   JCheckBox[] pricec = new JCheckBox[5];
	   JCheckBox[] agec = new JCheckBox[5];
	   JCheckBox [] brandc =new JCheckBox[10];
	   JCheckBox[] funcc = new JCheckBox[6];
	   JRadioButton wo, ma, woma;
	   JComboBox<String> brandco;
	   String[] brands = new String[] {"","게리쏭","겔랑","고위드미","궁중비책","그린핑거","글램글로우",
			   "니베아","헤라","후","베네피트"};
	   JPanel panel1,panel2,pan1,pan2,pan3,pan4,pan5,pan6,pan7;
	   
	   
	   JTextArea ja;
	   JButton jb;
	   String sql="";
	   boolean chk=false;
	   boolean chkk=false;
	
		JTable table;
		JScrollPane scroll;
		DefaultTableModel model;
		TableP tp;
	
	SearchP(){
		
	     panel1 = new JPanel();
	      panel2 = new JPanel();

	      agel = new JLabel("연령대   :");
	      catel = new JLabel("카테고리   :");
	      brandl = new JLabel("브랜드");
	      brandl2 =new JLabel("기타");
	      pricel = new JLabel("가격대   :");
	      genl = new JLabel("성별   :");
	      funcl = new JLabel("기능   :");

	      pan1 = new JPanel();
	      //pan1.add(catel);
	      pan1.setBorder(new TitledBorder("카테고리"));
	      catec[0] = new JCheckBox("스킨");
	      catec[1] = new JCheckBox("로션");
	      catec[2] = new JCheckBox("선케어");
	      catec[3] = new JCheckBox("클렌징");
	      catec[4] = new JCheckBox("립제품");
	      catec[5] = new JCheckBox("전체");
	      for (int i = 0; i < catec.length; i++)
	      {
	    	  catec[i].setBackground(Color.white);
	         pan1.add(catec[i]);
	      }
	      pan1.setBackground(Color.white);
	      
	      pan2 = new JPanel();
	      //pan2.add(agel);
	      pan2.setBorder(new TitledBorder("연령대"));
	      agec[0] = new JCheckBox("10대");
	      agec[1] = new JCheckBox("20대");
	      agec[2] = new JCheckBox("30대");
	      agec[3] = new JCheckBox("40대이상");
	      agec[4] = new JCheckBox("전연령");
	      for (int i = 0; i < agec.length; i++)
	      {
	    	 agec[i].setBackground(Color.white);
	         pan2.add(agec[i]);
	      }
	      pan2.setBackground(Color.white);
	      
	      pan3 = new JPanel();
	      //pan3.add(pricel);
	      pan3.setBorder(new TitledBorder("가격대"));
	      pricec[0] = new JCheckBox("~30000원");
	      pricec[1] = new JCheckBox("~40000원");
	      pricec[2] = new JCheckBox("~50000원");
	      pricec[3] = new JCheckBox("~60000원");
	      pricec[4] = new JCheckBox("전체");
	      for (int i = 0; i < pricec.length; i++)
	      {
	    	 pricec[i].setBackground(Color.white);
	         pan3.add(pricec[i]);
	      }
	      pan3.setBackground(Color.white);
	      
	      pan4 = new JPanel();
	      //pan4.add(genl);
	      pan4.setBorder(new TitledBorder("성별"));
	      wo = new JRadioButton("여성", true);
	      ma = new JRadioButton("남성");
	      woma = new JRadioButton("공용");
	      ButtonGroup genB = new ButtonGroup();
	      
	      genB.add(wo);
	      genB.add(ma);
	      genB.add(woma);
	      pan4.add(wo);
	      pan4.add(ma);
	      pan4.add(woma);
	      //pan4.add(brandl);
	      pan4.setBackground(Color.white);
	      wo.setBackground(Color.white);
	      ma.setBackground(Color.white);
	      woma.setBackground(Color.white);

	      pan5=new JPanel();//브랜드
	      //pan5.add(brandl);
	      pan5.setBorder(new TitledBorder("브랜드"));
	      brandc[0]=new JCheckBox("샤넬");brandc[1]=new JCheckBox("디올");brandc[2]=new JCheckBox("시세이도");
	      brandc[3]=new JCheckBox("키엘");brandc[4]=new JCheckBox("설화수");brandc[5]=new JCheckBox("입생로랑");
	      brandc[6]=new JCheckBox("랑콤");brandc[7]=new JCheckBox("겐조");brandc[8]=new JCheckBox("가네보");brandc[9]=new JCheckBox("에스케이투");
	      for(int i=0;i<10;i++) 
	      {
	    	 brandc[i].setBackground(Color.white);
	         pan5.add(brandc[i]);
	      }
	    /*pan6=new JPanel();//브랜드 기타
	      pan6.add(brandc[6]);pan6.add(brandc[7]);pan6.add(brandc[8]);pan6.add(brandc[9]);*/
	      //pan5.add(brandl2);
	      brandco =new JComboBox<String>(brands); 
	      pan5.add(brandco);
	      pan5.setBackground(Color.white);
	      pan5.setLayout(new GridLayout(3, 1));
	      
	      
	      pan7=new JPanel();
	      pan7.setBackground(Color.white);
	      //pan7.add(funcl);   
	      pan7.setBorder(new TitledBorder("기능"));
	      funcc[0]=new JCheckBox("건성");funcc[1]=new JCheckBox("지성");
	      funcc[2]=new JCheckBox("복합성");funcc[3]=new JCheckBox("여드름 성");
	      funcc[4]=new JCheckBox("아토피성");funcc[5]=new JCheckBox("모든피부");
	      for(int i=0;i<funcc.length;i++) 
	      {
	    	  funcc[i].setBackground(Color.white);
	         pan7.add(funcc[i]);
	      }
	     
	      jb = new JButton("결과");
	      jb.setLocation(250,500);
	      ja = new JTextArea(2, 40);
	      ja.setLocation(0,500);
	      
	      panel1.setLayout(new FlowLayout(FlowLayout.LEFT));
	     
	      panel1.add(pan1);
	      panel1.add(pan2);// add(pan3);
	      panel1.add(pan3);
	      panel1.add(pan4);
	      panel1.add(pan5);
	      //panel1.add(pan6);
	      panel1.add(pan7);
	      panel1.setBackground(Color.white);
	      
	      //panel2.setLayout(new GridLayout(2, 1));
	      panel2.add(jb);
	      jb.setBackground(Color.white);
	      panel2.setBackground(Color.white);
	      //panel2.add(new JScrollPane(ja));
	      
	      
	      setLayout(new BorderLayout());
	  
	      
	      add(panel1,BorderLayout.CENTER);
	      add(panel2,BorderLayout.SOUTH);
	      panel2.setSize(500,100);
	      String[] st= {"번호","종류","이름","가격","나이","브랜드","성별","기능"};
	      
			model = new DefaultTableModel(st, 0) {
				public boolean isCellEditable(int row, int col) {
					return false;
				}
			}; 
			
			table = new JTable(model);
			scroll = new JScrollPane(table);
			
		

	      wo.addItemListener(this);
	      ma.addItemListener(this);
	      woma.addItemListener(this);
	      for (int i = 0; i < agec.length; i++)
	    	  agec[i].addItemListener(this);
	      for (int i = 0; i < catec.length; i++)
	    	  catec[i].addItemListener(this);
	      for (int i = 0; i < pricec.length; i++)
	    	 pricec[i].addItemListener(this);
	      for (int i = 0; i < brandc.length; i++)
	    	  brandc[i].addItemListener(this);
	      for (int i = 0; i < funcc.length; i++)
	    	 funcc[i].addItemListener(this);
	      brandco.addItemListener(this);
	      
	      
	      //this.getContentPane().setBackground(Color.WHITE);
	      setSize(500, 600);
	      setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	      
	   // 모니터의 가운데 정렬
	      Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
	      Dimension f_size = super.getSize();
	      int xpos = (int) (screen.getWidth() / 2 - f_size.getWidth() / 2);
	      int ypos = (int) (screen.getHeight() / 2 - f_size.getHeight() / 2);
	      setLocation(xpos+400, ypos);
	      
	}

	@Override
    public void itemStateChanged(ItemEvent e) {
       ja.setText("");
       Object obj = e.getStateChange();

       for (int i = 0; i < agec.length; i++)
          if (agec[i].isSelected()) {
             ja.append(agec[i].getText() + "  ");
          }
       for (int i = 0; i < catec.length; i++)
          if (catec[i].isSelected()) {
             ja.append(catec[i].getText() + "  ");
          }
       for (int i = 0; i < pricec.length; i++)
          if (pricec[i].isSelected()) {
             ja.append(pricec[i].getText() + "  ");
          }
       for (int i = 0; i < brandc.length; i++)
           if (brandc[i].isSelected()) {
              ja.append(brandc[i].getText() + "  ");
           }
       for (int i = 0; i < funcc.length; i++)
          if (funcc[i].isSelected()) {
             ja.append(funcc[i].getText() + "  ");
          }
       // 선택된 항목의 인덱스 가져오기
       int index = brandco.getSelectedIndex();
       // 선택된 항목의 문자열 리턴
       String txt = (String) brandco.getSelectedItem();
       
       ja.append(index + ":" + txt + "  ");
       
       if (wo.isSelected()) // 일반적으로메소드명이is나 has가들어가면 논리값임
          ja.append(wo.getText() + "  ");
       else if (ma.isSelected())
          ja.append(ma.getText() + "  ");
       else if (woma.isSelected())
          ja.append(woma.getText() + "  ");
       
       
       
       if(agec[4].isSelected()) {
          for (int i = 0; i < agec.length-1; i++) {
             agec[i].setSelected(false);

          }}
       
       if(catec[5].isSelected()) {
          for (int i = 0; i < catec.length-1; i++) {
             catec[i].setSelected(false);

          }}
       if(pricec[4].isSelected()) {
          for (int i = 0; i < pricec.length-1; i++) {
             pricec[i].setSelected(false);

          }}
       if(funcc[5].isSelected()) {
          for (int i = 0; i < funcc.length-1; i++) {
             funcc[i].setSelected(false);

          }}
    }

 public String makeSql() {
       //sql만들기
    sql="";
       chk=false; chkk=false; int cnt=0;
       if(wo.isSelected()) {
          

          sql+="user_sex=";
          sql+="'"+wo.getText()+"' ";
          }else if(ma.isSelected()) {
             

             sql+="user_sex=";
             sql+="'"+ma.getText()+"' ";
          
          }else if(woma.isSelected()) {

             sql+="user_sex=";
             sql+="'공용' ";

          }
       chk=true;
       chkk=false;

       
       for(int i=0;i<catec.length-1;i++) {
       if(catec[i].isSelected()) {
          
          
          if(chk) {
             sql+=" and ";
             sql+="(";
             cnt=1;
             chk=false;
          }if(chkk) {
             sql+=" or ";
          }
          sql+="product_category LIKE";
          sql+=" '%"+catec[i].getText()+"' ";
          
          chkk=true;
          }
       }
       
    chk=true;
    chkk=false;
    if(cnt==1)sql+=")";
    cnt=0;
    for(int i=0;i<agec.length-1;i++) {
       if(agec[i].isSelected()) {
          
          if(chk) {
             
             sql+=" and ";
             sql+="(";
             cnt=1;
             chk=false;
          }if(chkk) {
             sql+=" or ";
          }
          sql+="user_age LIKE ";
          sql+="'%"+agec[i].getText()+"%' ";
          chkk=true;
          }
       
       }
    
       if(cnt==1)sql+=")";
          chk=true;
          chkk=false;
          cnt=0;
          
          
          
       for(int i=0;i<pricec.length-1;i++) {
          if(pricec[i].isSelected()) {
             if(chk) {
                
                sql+=" and ";
                sql+="(";
                cnt=1;
                chk=false;
                
             }if(chkk) {
                sql+=" or ";
             }
             sql+="product_price<";
             sql+= "to_number(trim('~' from trim('원'from'"+pricec[i].getText()
                   +"'))) ";
             chkk=true;
             }

          }   
       
          
             chk=true;
             chkk=false;
             if(cnt==1)sql+=")";
             cnt=0;
             
             if(brandco.getSelectedItem()!="")   {
             if(chk) {
             
             sql+=" and ";
             sql+="(";
             cnt=1;
                chk=false;
             }if(chkk) {
             sql+=" or ";
             }
             sql+="brand_name=";
             sql+="'"+brandco.getSelectedItem().toString()+"' ";
             chkk=true;
    
                   chk=true;
                   chkk=false;
                   }
          for(int i=0;i<brandc.length;i++) {
             if(brandc[i].isSelected()) {
                      
                if(brandco.getSelectedItem()!="") {
                   chk=false;
                chkk=true;}
          
             if(chk) {
                sql+=" and ";
                sql+="(";
                cnt=1;
             chk=false;
                }if(chkk) {
                   sql+=" or ";
                }
                sql+="brand_name=";
                sql+="'"+brandc[i].getText()+"' ";
                chkk=true;
             }}
                      
                      
          if(cnt==1)sql+=")";
             chk=true;
             chkk=false;
             cnt=0;
             
             for(int i=0;i<funcc.length-1;i++) {
                if(funcc[i].isSelected()) {
                   if(chk) {
                      sql+=" and ";
                      sql+="(";
                      cnt=1;
                      chk=false;
                   }if(chkk) {
                      sql+=" or ";
                   }
                   sql+="user_type LIKE";
                   sql+="'%"+funcc[i].getText()+"%' ";
                   chkk=true;
                   }
                
                }
                chk=true;
                chkk=false;
          
                if(cnt==1)sql+=")";
                cnt=0;

       return sql;
       
       
 }
	}
	
	  
	
	


