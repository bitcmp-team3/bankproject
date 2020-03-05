package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.AccountBean;
import model.bean.TransactionBean;
import model.dao.TransactionDAO;

/**
 * Servlet implementation class MemberDeleteServlet
 */
public class DeleteProcessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=utf8");
		request.setCharacterEncoding("utf8");
		
		Connection conn = null;
		PreparedStatement pState = null;
		HttpSession session = request.getSession();
		
		
		try {
			AccountBean delInfo = (AccountBean)session.getAttribute("accNo");
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection("jdbc:mysql://localhost/bank?useUnicode=true&useJDBCCompliantTimezoneShift="
					+ "true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "1234");
			String deleteSQL = "delete from account where accNo=?";
			pState = conn.prepareStatement(deleteSQL);
			pState.setString(1, delInfo.getAccNo() );
			
			pState.executeUpdate();
			request.getRequestDispatcher("/deleteComplete").forward(request, response);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	 
}
