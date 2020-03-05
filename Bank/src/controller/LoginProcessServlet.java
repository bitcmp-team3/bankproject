package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.LoginDAO;

/**
 * Servlet implementation class LoginProcessServlet
 */
public class LoginProcessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = null;
		String id=request.getParameter("id").trim();
		String pw=request.getParameter("pw").trim();
		
		LoginDAO dao=new LoginDAO();
		
		int login=dao.loginProcess(id,pw);
		
		if (login==1) {
			session = request.getSession();
			if (!session.isNew()) {
				session.invalidate();
				session = request.getSession(true);
			}
			session.setMaxInactiveInterval(3*60);
			session.setAttribute("id", dao.userInfo(request).getId()); //dao에서 가져온 userInfo에 저장된 id를 session에 저장
			session.setAttribute("name", dao.userInfo(request).getName()); //dao에서 가져온 userInfo에 저장된 name를 session에 저장
			request.getRequestDispatcher("/mypage").forward(request, response);
		} else {
			response.sendRedirect("/loginFail");
		}
	}

}
