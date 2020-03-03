package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.DeleteDAO;

public class DeleteProcessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		DeleteDAO dao =new DeleteDAO();
		String accNo=request.getParameter("accNo").trim();
		request.setAttribute("delInfo", dao.delInfo(accNo));
		 
		 //response.sendRedirect(nextPage);
		request.getRequestDispatcher("/deleteComplete").forward(request, response);
		
	}

}
