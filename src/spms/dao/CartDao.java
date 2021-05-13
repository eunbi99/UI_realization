package spms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import spms.util.DBConnectionPool;
import spms.vo.CartVO;

public class CartDao {
   
   DataSource ds = null;
   
   public void setDataSource(DataSource ds) {
      this.ds = ds;
   }
   
   //장바구니 목록 확인 
   public List<CartVO> selectList() throws Exception{
      Connection connection= null;
      Statement stmt = null;
      ResultSet rs = null;
      
      final String sqlSelect = 
            "SELECT p.p_price, p.p_name, p.p_content, c.amount ,c.p_id "
            + "FROM Cart c inner join Product p "
            + "on c.p_id =p.p_id and c.u_id = #{userId}";
      
      try {
         // 커넥션 풀에서 Connection 객체를 빌려온다
          connection = ds.getConnection();
         stmt = connection.createStatement();
         rs = stmt.executeQuery(sqlSelect);
         ArrayList<CartVO> carts = new ArrayList<CartVO>();
         
         
         while(rs.next()) {
        	 carts.add(new CartVO()
        		.setP_price(rs.getString("p_price"))
        	    .setP_name(rs.getString("p_name"))
        	    .setP_content(rs.getString("p_content"))
        	    .setAmount(rs.getInt("amount"))
        	    .setP_id(rs.getString("p_id"))
        	 );
         }
         
         return carts;
         
      }catch(Exception e) {
         throw e;
      }finally {
         try {if(rs!=null) rs.close();}
         catch(Exception e) {e.printStackTrace();}
         try {if(stmt!=null) stmt.close();}
         catch(Exception e) {e.printStackTrace();}      
         
         // 커넥션 풀로 반납
         connection.close();
      }
   }
   
   //장바구니에 담을 때
   public int cartinsert(CartVO cart) throws Exception{
      Connection connection= null;
      int result = 0;
      PreparedStatement stmt = null;
      final String sqlInsert = "INSERT INTO Cart(u_id,p_id,amount)" + "\r\n" +
                     "VALUES(?, ?, ?)";
      
      try {
         // 커넥션 풀에서 Connection 객체를 빌려온다
          connection = ds.getConnection();
         stmt = connection.prepareStatement(sqlInsert);
         stmt.setString(1, cart.getU_id());
         stmt.setString(2, cart.getP_id());
         stmt.setInt(3, cart.getAmount());
         result = stmt.executeUpdate();   
      }catch(Exception e) {
         throw e;
      }finally {
         try {if(stmt!=null) stmt.close();}
         catch(Exception e) {e.printStackTrace();}   
         connection.close();
      }
      
      //장바구니에 정보를 담아서 결과를 서블릿에 리턴해준다.
      return result;
   }
   
   public int delete(int no) throws Exception{
      Connection connection= null;
      int result = 0;
       Statement stmt = null;
       final String sqlDelete = "DELETE FROM MEMBERS WHERE MNO=";

       try {
          // 커넥션 풀에서 Connection 객체를 빌려온다
          connection = ds.getConnection();
         stmt = connection.createStatement();
         result = stmt.executeUpdate(
               sqlDelete + no);

       } catch (Exception e) {
         throw e;

       } finally {
         try {if (stmt != null) stmt.close();} catch(Exception e) {}
      // 커넥션 풀로 반납
         connection.close();
       }      
      
      return result;
   }
   
//   public CartVO selectOne(int no) throws Exception{
//      Connection connection= null;
//
//      CartVO member = null;
//       Statement stmt = null;
//       ResultSet rs = null;
//       
//       final String sqlSelectOne = "SELECT MNO,EMAIL,MNAME,CRE_DATE FROM MEMBERS" + 
//                 " WHERE MNO=";
//       
//       try {
//          // 커넥션 풀에서 Connection 객체를 빌려온다
//          connection = ds.getConnection();
//         stmt = connection.createStatement();
//         rs = stmt.executeQuery(
//               sqlSelectOne + no);    
//         if (rs.next()) {
//           member = new CartVO()
//           .setNo(rs.getInt("MNO"))
//           .setEmail(rs.getString("EMAIL"))
//           .setName(rs.getString("MNAME"))
//           .setCreatedDate(rs.getDate("CRE_DATE"));
//
//         } else {
//           throw new Exception("해당 번호의 회원을 찾을 수 없습니다.");
//         }
//
//       } catch (Exception e) {
//         throw e;
//       } finally {
//         try {if (rs != null) rs.close();} catch(Exception e) {}
//         try {if (stmt != null) stmt.close();} catch(Exception e) {}
//      // 커넥션 풀로 반납
//         connection.close();
//       }
//       
//      return member;
//   }
//   
//   public int update(CartVO member) throws Exception{
//      Connection connection= null;
//
//      int result = 0;
//       PreparedStatement stmt = null;
//       final String sqlUpdate = "UPDATE MEMBERS SET EMAIL=?,MNAME=?,MOD_DATE=now()"
//                             + " WHERE MNO=?";
//       try {
//          // 커넥션 풀에서 Connection 객체를 빌려온다
//          connection = ds.getConnection();
//         stmt = connection.prepareStatement(sqlUpdate);
//         stmt.setString(1, member.getEmail());
//         stmt.setString(2, member.getName());
//         stmt.setInt(3, member.getNo());
//         result = stmt.executeUpdate();
//
//       } catch (Exception e) {
//         throw e;
//       } finally {
//         try {if (stmt != null) stmt.close();} catch(Exception e) {}
//      // 커넥션 풀로 반납
//         connection.close();
//       }      
//      
//      return result;
//   }
//   
//   public CartVO exist(String email, String password) throws Exception{
//      Connection connection= null;
//
//      CartVO member = null;
//       PreparedStatement stmt = null;
//       ResultSet rs = null;
//       final String sqlExist = "SELECT MNAME,EMAIL FROM MEMBERS"
//                             + " WHERE EMAIL=? AND PWD=?";
//
//       try {
//          // 커넥션 풀에서 Connection 객체를 빌려온다
//          connection = ds.getConnection();
//         stmt = connection.prepareStatement(sqlExist);
//         stmt.setString(1, email);
//         stmt.setString(2, password);
//         rs = stmt.executeQuery();
//         if (rs.next()) {
//            member = new CartVO()
//             .setName(rs.getString("MNAME"))
//             .setEmail(rs.getString("EMAIL"));
//         } else {
//           return null;
//         }
//       } catch (Exception e) {
//         throw e;
//
//       } finally {
//         try {if (rs != null) rs.close();} catch (Exception e) {}
//         try {if (stmt != null) stmt.close();} catch (Exception e) {}
//      // 커넥션 풀로 반납
//         connection.close();
//       }      
//       
//      return member;
//   }


}










