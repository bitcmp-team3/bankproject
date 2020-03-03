package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		AccountListDAO dao = new AccountListDAO();
		HttpSession session = null;

		if (request.getAttribute("login").equals(true)) {//login값이 true면 세션가져오기
			session = request.getSession();
			if (!session.isNew()) {
				session.invalidate();
				session = request.getSession(true);
			}
			session.setMaxInactiveInterval(3*60);
			session.setAttribute("accountList", dao.accountList(request)); //session에 정보 저장
			request.getRequestDispatcher("/accountList").forward(request, response);
		} else {//login값이 false면
			response.sendRedirect("/loginFail");
		}
	}

}
