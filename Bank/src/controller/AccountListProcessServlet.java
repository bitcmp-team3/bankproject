package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.AccountListDAO;

/**
 * Servlet implementation class AccountListProcessServlet
 */
public class AccountListProcessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AccountListDAO dao=new AccountListDAO();
		
		request.setAttribute("accountList", dao.accountList(request)); //로그인한 id의 accountList목록 저장
		request.getRequestDispatcher("/accountList").forward(request, response);
	}

}
