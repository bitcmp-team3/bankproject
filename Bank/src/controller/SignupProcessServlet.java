package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.ConnectionDAO;

/**
 * Servlet implementation class SignupProcessServlet
 */
public class SignupProcessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int count=0;
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ConnectionDAO dao = ConnectionDAO.getInstance();
		PreparedStatement stmt=null;
		Connection conn = dao.getConn();
		ResultSet resultSet=null;
		
		request.setCharacterEncoding("utf-8");
		String id =  request.getParameter("id").trim();
		String pw =  request.getParameter("pw").trim();
		String name=  request.getParameter("name").trim();
		String birthday = request.getParameter("birthday").trim();
		String phoneNo = request.getParameter("phoneNo").trim();
		String addr=  request.getParameter("addr").trim();
		String userNo = null;
		
		String sql ="select id from bank.user where id=?"; 
		
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, id);
			resultSet = stmt.executeQuery();
			
			if(resultSet.next()) {
				response.setCharacterEncoding("UTF-8"); 
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>alert('아이디가 중복되었습니다'); location.href='/';</script>"); 
				out.flush();
				
			} else {
				count++;
				userNo="No"+count+birthday;
				sql =" insert into bank.user(id, pw, name, birthday, phoneNo, addr, userNo) values(?,?,?,?,?,?,?)"; 
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, id);
				stmt.setString(2, pw);
				stmt.setString(3, name);
				stmt.setString(4, birthday);
				stmt.setString(5, phoneNo);
				stmt.setString(6, addr);
				stmt.setString(7, userNo);
				stmt.executeUpdate();
				response.sendRedirect("/signupSuccess.jsp");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
