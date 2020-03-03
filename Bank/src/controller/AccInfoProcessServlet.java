package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.AccInfoDAO;

/**
 * Servlet implementation class AccInfo
 */
public class AccInfoProcessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		AccInfoDAO dao =new AccInfoDAO();
		String accNo=request.getParameter("accNo").trim();
		request.setAttribute("accInfo", dao.accInfo(accNo));
		request.setAttribute("accList", dao.accList(accNo)); 
		 
		 //response.sendRedirect(nextPage);
		request.getRequestDispatcher("/info").forward(request, response);
		
	}

}
