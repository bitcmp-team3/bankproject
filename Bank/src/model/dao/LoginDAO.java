package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.bean.UserBean;

public class LoginDAO {
	private PreparedStatement stmt;
	private Connection conn=ConnectionDAO.getInstance().getConn();
	ResultSet rs;
	HttpSession session;
	
	public LoginDAO() {//디폴트생성자
		
	}
	public int loginProcess(String id, String pw) {
		String sql=" select id, name from user where id=? and pw=? ";
		try {
			stmt=conn.prepareStatement(sql);
			stmt.setString(1, id);
			stmt.setString(2, pw);
			rs=stmt.executeQuery();
			
			if(rs.next()) {
				
				return 1; 
			} 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	public UserBean userInfo(HttpServletRequest request) { //user정보를 가져오기 위함
		UserBean user=null;
		String sqlUserlist="select id, name from user where id=? ";
		String id=request.getParameter("id").trim();
		
		try {
			stmt=conn.prepareStatement(sqlUserlist);
			stmt.setString(1, id);
			rs=stmt.executeQuery();
			user=new UserBean();
			while(rs.next()) {
				user.setId(rs.getString(1));
				user.setName(rs.getString(2)); 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally { 
				try {
					if(rs!=null) rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return user;
	}
	
	@Override
	protected void finalize() throws Throwable {
		try {
			if(stmt!=null) stmt.close();
		} catch(SQLException e){
			e.printStackTrace();
		}
		super.finalize();
	}
	
}
