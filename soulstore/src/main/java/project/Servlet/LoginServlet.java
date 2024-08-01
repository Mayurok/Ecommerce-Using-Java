package project.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import com.mysql.cj.Session;

import project.Connection.ConnectionProvider;
import project.DAO.UserDao;
import project.Model.Users;

@WebServlet("/userlogin")

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  
	  response.sendRedirect("Login.jsp"); 
	  }
	 

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//		doGet(request, response);

		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			try {
				UserDao udao = new UserDao(ConnectionProvider.getConnection());
				Users user = udao.userlogin(email, password);
                HttpSession session = request.getSession();
                
				if (user != null) {
					out.print("user Login");
					session.setAttribute("auth", user);
					response.sendRedirect("index.jsp");/* try code */
					
				} else {
					out.print("Login Failed");
				}

			} catch (ClassNotFoundException | SQLException e) {

				e.printStackTrace();
			}

		}
	}

}
