package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.TransactionDAO;

/**
 * Servlet implementation class AccInfo
 */
public class TransactionProcessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		HttpSession session= request.getSession();
		TransactionDAO dao =new TransactionDAO();
		String accNo=request.getParameter("accNo").trim();
		session.setAttribute("accNo", dao.accountInfo(accNo)); //계좌정보를 불러오기위해 세션에 저장
		request.setAttribute("transaction", dao.transaction(accNo)); 

		request.getRequestDispatcher("/transaction").forward(request, response);
	}

}
