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

import project.Connection.ConnectionProvider;
import project.DAO.ProductDao;
import project.DAO.UserDao;
import project.Model.Users;
import project.Model.product;

@WebServlet("/nakona")
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  


	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {
			String name = request.getParameter("nigaa");
			String category = request.getParameter("cat");
			String price = request.getParameter("pri");
			String image = request.getParameter("ima");
            
			

			try {
				ProductDao pdao = new ProductDao(ConnectionProvider.getConnection());
				product p = pdao.AddProduct(name,category,price,image);
                
                
				if (p != null) {
					out.print("Product Added Succesfully");	
					response.sendRedirect("index.jsp");
				} else {
					out.print("There is an issue at our side please try again after some times "+image+price+category+name);
				}

			} catch (Exception e) {

				e.printStackTrace();
			}

	}

	
	/*
	 * protected void doPost(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException {
	 * 
	 * 
	 * }
	 */

	}
	}
