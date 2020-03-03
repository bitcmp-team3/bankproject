package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.UserBean;
import model.dao.AccountListDAO;

/**
 * Servlet implementation class LoginProcessServlet
 */
public class LoginProcessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = null;
		String id=request.getParameter("id").trim();
		String pw=request.getParameter("pw").trim();
		AccountListDAO dao=new AccountListDAO();
		
		int login=dao.loginProcess(id,pw);
		
		if (login==1) {
			UserBean user=new UserBean();
			user.setId(id);
			
			session = request.getSession();
			if (!session.isNew()) {
				session.invalidate();
				session = request.getSession(true);
			}
			session.setMaxInactiveInterval(3*60);
			session.setAttribute("user", user); 
			request.setAttribute("accountList", dao.accountList(id));
			request.getRequestDispatcher("/accountList").forward(request, response);
		} else {
			response.sendRedirect("/loginFail");
		}
	}

}
