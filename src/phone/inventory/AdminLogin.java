package phone.inventory;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("login") != null)
		request.getRequestDispatcher("/WEB-INF/AdminLogin.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String userName = request.getParameter("user");
			String password = request.getParameter("pwd");
			request.setAttribute("user",userName);
			Database db = new Database();
			try {
				if(db.checkLogin(userName, password))
					request.getRequestDispatcher("/WEB-INF/AdminMenu.jsp").forward(request, response);
				else
					request.getRequestDispatcher("/WEB-INF/AdminWrong.jsp").forward(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
	}

}
