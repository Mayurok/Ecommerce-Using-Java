package project.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.Connection.ConnectionProvider;
import project.DAO.UserDao;
import project.Model.Register;


@WebServlet("/user")

public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	  protected void doGet(HttpServletRequest request, HttpServletResponse
	  response) throws ServletException, IOException {
		  response.sendRedirect("register.jsp");
	  }
	 

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {
			String name = request.getParameter("loginname");
			String email = request.getParameter("loginemail");
			String password = request.getParameter("loginpassword");
			UserDao udao = new UserDao(ConnectionProvider.getConnection());
			Register reg = udao.registeruser(name,email, password);
			if (reg != null) {
				out.print("Register Succesfully");
				
				response.sendRedirect("Login.jsp");
			} else {
				out.print("Please try again there are issues at our side ");
				//response.sendRedirect("register.jsp");

			}
	}catch (ClassNotFoundException | SQLException e) {

		e.printStackTrace();
	}

	}
}
