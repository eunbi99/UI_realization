package spms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MemberDao {
   
   private Connection conn;
   PreparedStatement pstmt;
   ResultSet rs;
   
   public MemberDao() {
      try {
         String url = "jdbc:mysql://112.169.196.142/studydb?serverTimezone=UTC";
         String id = "study";
         String pw = "study";
         Class.forName("com.mysql.cj.jdbc.Driver");
         conn = DriverManager.getConnection(url, id, pw);
      } catch(Exception e) {
         e.printStackTrace();
      }
   }
   
   // 로그인
   public int login(String userId, String userPassword) {
      String SQL = 
            "SELECT u_id,u_pw FROM user WHERE u_id=? AND u_pw=?";
      try {
         pstmt = conn.prepareStatement(SQL);
         pstmt.setString(1, userId);
         pstmt.setString(2, userPassword);
         rs = pstmt.executeQuery();
         
         if(rs.next()) {
            if(rs.getString(2).equals(userPassword)) {
               return 1; //로그인 성공
            } 
            else {
               return 0; // 비밀번호 불일치
            }
         }
         return -1; // ID없음
         
      } catch(Exception e) {
         e.printStackTrace();
      } finally {
         try {
            if(rs != null) rs.close();
            if(pstmt != null) pstmt.close();
         } catch(Exception e) {
            e.printStackTrace();
         }
      }
      return -2; //DB오류
   }
   
   // 중복 아이디 확인
   public int registerCheck(String userID) {
      
      String SQL = "SELECT * FROM user WHERE u_id = ?";
      
      try {
         pstmt = conn.prepareStatement(SQL);
         pstmt.setString(1, userID);  
         rs = pstmt.executeQuery();
         
         if(rs.next()) { // 이미 존재하는 회원
            // userID가 admin일 때, 
            return 0; 
            
         }
         else {
            return 1; // 가입 가능한 회원
         }
      } catch(Exception e) {
         e.printStackTrace();
      } finally {
         try {
            if(rs != null) rs.close();
            if(pstmt != null) pstmt.close();
         } catch(Exception e) {
            e.printStackTrace();
         }
      }
      return -1; // DB 오류
   }
   
   // 새로운 회원 가입
   public int register(String userId, String userPassword, String userName, String userPhoneNum, String userAddress) {
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      String SQL = "INSERT INTO user VALUES (?, ?, ?, ?, ?)";
      
      try {
         // 입력 받은 값을 업데이트 
         pstmt = conn.prepareStatement(SQL);
         pstmt.setString(1, userId);
         pstmt.setString(2, userPassword);
         pstmt.setString(3, userName);
         pstmt.setString(4, userPhoneNum);
         pstmt.setString(5, userAddress);
         return pstmt.executeUpdate(); // 성공적으로 업뎃된 수만큼 리턴
         
      } catch(Exception e) {
         e.printStackTrace();
      } finally {
         try {
            if(rs != null) rs.close();
            if(pstmt != null) pstmt.close();
         } catch(Exception e) {
            e.printStackTrace();
         }
      }
      return -1; // DB 오류
   }

}