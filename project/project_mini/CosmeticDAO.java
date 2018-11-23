package project_mini;



import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CosmeticDAO {

   private Connection conn = null;
   private Statement stmt = null;
   private PreparedStatement pstmt = null;
   private ResultSet rs = null;
   
   private static CosmeticDAO dao = new CosmeticDAO();
   private CosmeticDAO() {}
   
   public static CosmeticDAO getInstance() {
      return dao;
   }//end getInstance()//////
   
   private Connection init() throws ClassNotFoundException, SQLException {
      //1.드라이버 로딩
         Class.forName("oracle.jdbc.OracleDriver");
      //2.서버연결
      String url ="jdbc:oracle:thin://@127.0.0.1:1521:xe";
      String username="hr";
      String password="a1234";
      return DriverManager.getConnection(url,username,password);
   }
   
   private void exit(){
      try {   
         if(rs != null)
         rs.close();
          if(stmt != null)
             stmt.close();
         if(pstmt != null)
            pstmt.close();
         if(conn != null)
            conn.close();
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
   }//end exit()////////////////////////
   
   public List<CosmeticDTO>searchMethod(String word){
      List<CosmeticDTO> aList = new ArrayList<CosmeticDTO>();
      
         try {
        	 conn = init();
        	 String sql = "SELECT * from cosmetic " ;  
             sql = sql+word;
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while(rs.next()){
               CosmeticDTO dto = new CosmeticDTO();
               dto.setProduct_id(rs.getInt("product_id"));
               dto.setProduct_category(rs.getString("product_category"));
               dto.setProduct_name(rs.getString("product_name"));
               dto.setProduct_price(rs.getInt("product_price"));
               dto.setUser_age(rs.getString("user_age"));
               dto.setBrand_name(rs.getString("brand_name"));
               dto.setUser_sex(rs.getString("user_sex"));
               dto.setUser_type(rs.getString("user_type"));
               dto.setImage(rs.getString("image"));
               aList.add(dto);
            }
         } catch (ClassNotFoundException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }finally {
               exit();
         }
         return aList;
   }//end searchMethod()
   
   public List<CosmeticDTO> searchMethod2(String sql1){
       List<CosmeticDTO> aList = new ArrayList<CosmeticDTO>();
       
          try {
             conn = init();
             String sql = "SELECT * FROM cosmetic WHERE "+sql1;
             stmt=conn.createStatement();
             rs = stmt.executeQuery(sql);
             while(rs.next()){
                CosmeticDTO dto = new CosmeticDTO();
                dto.setProduct_id(rs.getInt("product_id"));
                dto.setProduct_category(rs.getString("product_category"));
                dto.setProduct_name(rs.getString("product_name"));
                dto.setProduct_price(rs.getInt("product_price"));
                dto.setUser_age(rs.getString("user_age"));
                dto.setBrand_name(rs.getString("brand_name"));
                dto.setUser_sex(rs.getString("user_sex"));
                dto.setUser_type(rs.getString("user_type"));
                dto.setImage(rs.getString("image"));
                aList.add(dto);
                
             }
          } catch (ClassNotFoundException | SQLException e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
          }finally {
                exit();
          }         
          return aList;
    }//end searchMethod()
   public List<ReviewDTO> getReview() {
       List<ReviewDTO> list=new ArrayList<ReviewDTO>();
      try {
      conn=init();
      stmt=conn.createStatement();
      rs=stmt.executeQuery("SELECT * FROM review");
      while(rs.next()) {
         ReviewDTO dto=new ReviewDTO();
         dto.setProduct_name(rs.getString("product_name"));
         dto.setName(rs.getString("name"));
         dto.setStar(rs.getString("star"));
         dto.setReview(rs.getString("review"));
         list.add(dto);
      }
   } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
   }finally {
      exit();
   }
      return list;
  }
   public void upReview(ReviewDTO dto) {
      try {
      conn=init();
      pstmt=conn.prepareStatement("INSERT INTO review VALUES(?,?,?,?)");
      pstmt.setString(1,dto.getProduct_name());
      pstmt.setString(2, dto.getName());
      pstmt.setString(3,dto.getStar());
      pstmt.setString(4, dto.getReview());
      pstmt.executeUpdate();
   } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
   }finally {
      exit();
   }

 }
  
   public void upCli(ClientDTO dto) {
	      try {
	      conn=init();
	      pstmt=conn.prepareStatement("INSERT INTO client VALUES(?,?,?,?,?,?)");
	      pstmt.setString(1,dto.getId());pstmt.setString(2, dto.getPassword());
	      pstmt.setString(3,dto.getName());pstmt.setString(4, dto.getAddress());
	      pstmt.setInt(5, dto.getPoint());pstmt.setString(6, dto.getGrade());
	      pstmt.executeUpdate();
	      
	   } catch (ClassNotFoundException | SQLException e) {
	      e.printStackTrace();
	   }finally {
	      exit();
	   }
	  }
	  public void pointCli(String id,int point) {
	      try {
	      conn=init();
	      pstmt=conn.prepareStatement("UPDATE client SET point =? WHERE id = ?");
	      pstmt.setInt(1,point);
	      pstmt.setString(2,id);
	      pstmt.executeUpdate();
	      
	   } catch (ClassNotFoundException | SQLException e) {
	      e.printStackTrace();
	   }finally {
	      exit();
	   }
	 }
	  
	  public void modiCli(String n,String p,String a,String id) {
	      try {
	      conn=init();
	      pstmt=conn.prepareStatement("UPDATE client SET name=?,password=?,"
	            + "address=? "
	            + "WHERE id=? ");
	      pstmt.setString(1,n);
	      pstmt.setString(2, p);
	      pstmt.setString(3,a);
	      pstmt.setString(4,id);
	      pstmt.executeUpdate();
	   } catch (ClassNotFoundException | SQLException e) {
	      e.printStackTrace();
	   }finally {
	      exit();
	   }
	  }
	  public void upgCli(String set, String id) {
	      try {
	      conn=init();
	      stmt=conn.createStatement();
	      stmt.executeUpdate("UPDATE client SET "+set+"WHERE id='"+id+"'");
	   } catch (ClassNotFoundException | SQLException e) {
	      e.printStackTrace();
	   }finally {
	      exit();
	   }
	  }
	  public ClientDTO getCli(String id) {
	      ClientDTO dto=new ClientDTO();
	      try {
	      conn=init();
	      stmt=conn.createStatement();
	      rs=stmt.executeQuery("SELECT * FROM client WHERE id = '"+id+"' ");
	      while(rs.next()) {
	         dto.setId(rs.getString("id"));
	         dto.setPassword(rs.getString("password"));
	         dto.setName(rs.getString("name"));
	         dto.setAddress(rs.getString("address"));
	         dto.setPoint(rs.getInt("point"));
	         dto.setGrade(rs.getString("grade"));
	      }
	   } catch (ClassNotFoundException | SQLException e) {
	      e.printStackTrace();
	   }finally {
	      exit();
	   }
	      return dto;
	  }
	  
	  
	  
	  public void upBuy(ClientDTO dto,CosmeticDTO dto2,int count,String id) {
	         try {
	         conn=init();
	         pstmt=conn.prepareStatement("INSERT INTO Buy VALUES(?,?,?,?,?)");
	         pstmt.setString(1, dto.getName());
	         pstmt.setString(2, dto.getAddress());
	         pstmt.setString(3, dto2.getProduct_name());
	         pstmt.setInt(4, count);
	         pstmt.setString(5, id);
	         pstmt.executeUpdate();
	         
	//
	         
	      } catch (ClassNotFoundException | SQLException e) {
	         e.printStackTrace();
	      }finally {
	         exit();
	      }
	     }
	         
	  
	  public boolean check(String a,String b) throws SQLException, ClassNotFoundException {
	      conn=init();
	      stmt=conn.createStatement();
	      rs=stmt.executeQuery("SELECT * FROM client WHERE id='"+a+"' and"
	            + " password='"+b+"'");
	      
	      return rs.next();


	  }
	  
	  
	  public List<CosmeticDTO> getList(){
	         List<CosmeticDTO> aList = new ArrayList<CosmeticDTO>();
	            try {
	               conn = init();
	               String sql = "SELECT * FROM cosmetic";
	               stmt=conn.createStatement();
	               rs = stmt.executeQuery(sql);
	               while(rs.next()){
	                  CosmeticDTO dto = new CosmeticDTO();
	                  dto.setProduct_id(rs.getInt("product_id"));
	                  dto.setProduct_category(rs.getString("product_category"));
	                  dto.setProduct_name(rs.getString("product_name"));
	                  dto.setProduct_price(rs.getInt("product_price"));
	                  dto.setUser_age(rs.getString("user_age"));
	                  dto.setBrand_name(rs.getString("brand_name"));
	                  dto.setUser_sex(rs.getString("user_sex"));
	                  dto.setUser_type(rs.getString("user_type"));
	                  aList.add(dto);
	               }
	            } catch (ClassNotFoundException | SQLException e) {
	               // TODO Auto-generated catch block
	               e.printStackTrace();
	            }finally {
	                  exit();
	              }
	                 
	              
	            return aList;
	  
	  }
	  public List<CosmeticDTO> getBuyList(String id){
          List<CosmeticDTO> aList = new ArrayList<CosmeticDTO>();
         
             try {
                conn = init();
                String sql = "SELECT product_category,b.product_name,product_price,b.count"
                      +" FROM cosmetic c,buy b WHERE b.id  in(  SELECT id FROM buy WHERE id ='"+id+"')"
                      +"and b.product_name=c.product_name";
                
                stmt=conn.createStatement();
                rs = stmt.executeQuery(sql);
                while(rs.next()){
                   CosmeticDTO dto = new CosmeticDTO();
                   dto.setProduct_category(rs.getString("product_category"));
                   dto.setProduct_name(rs.getString("product_name"));
                   dto.setProduct_price(rs.getInt("product_price"));
                   dto.buy.setCount(rs.getInt("count"));
                   aList.add(dto);
                }
             } catch (ClassNotFoundException | SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
             }finally {
                   exit();
               }
                  
               
             return aList;
   
   }

	  public CosmeticDTO searchCo(String name) {
	      CosmeticDTO dto = new CosmeticDTO();
	      
	       try {
	         conn = init();
	         stmt=conn.createStatement();
	          String sql = "SELECT * FROM cosmetic WHERE product_name='"+name+"' ";
	          rs = stmt.executeQuery(sql);
	          while(rs.next()) {
	          dto.setProduct_id(rs.getInt("product_id"));
	          dto.setProduct_category(rs.getString("product_category"));
	          dto.setProduct_name(rs.getString("product_name"));
	          dto.setProduct_price(rs.getInt("product_price"));
	          dto.setUser_age(rs.getString("user_age"));
	          dto.setBrand_name(rs.getString("brand_name"));
	          dto.setUser_sex(rs.getString("user_sex"));
	          dto.setUser_type(rs.getString("user_type"));
	          }
	      } catch (ClassNotFoundException | SQLException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      }finally {
	         exit();
	      }

	          return dto;
	  }

	  
	  public ClientDTO searchCli(String ko) {
	      ClientDTO dto = new ClientDTO();
	      
	       try {
	         conn = init();
	         stmt=conn.createStatement();
	          String sql = "SELECT * FROM client WHERE id='"+ko+"'";
	          rs = stmt.executeQuery(sql);
	          while(rs.next()) {
	          dto.setId(rs.getString("id"));
	          dto.setPassword(rs.getString("password"));
	          dto.setName(rs.getString("name"));
	          dto.setAddress(rs.getString("address"));
	          dto.setPoint(rs.getInt("point"));
	          }
	      } catch (ClassNotFoundException | SQLException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      }finally {
	         exit();
	      }

	          return dto;
	  }      

  

  
  
  
  

  
}
   

   
 

   

