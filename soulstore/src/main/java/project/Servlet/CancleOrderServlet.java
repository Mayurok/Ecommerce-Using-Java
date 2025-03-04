package project.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.Connection.ConnectionProvider;
import project.DAO.OrderDao;

@WebServlet("/cancelorder")


public class CancleOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try (PrintWriter out = response.getWriter()){
			
			String id = request.getParameter("id");
			 if(id != null) {
				 OrderDao odao = new OrderDao(ConnectionProvider.getConnection());	 
				 odao.CancleOrder(Integer.parseInt(id));
			 }
			 response.sendRedirect("orders.jsp");
		} catch (Exception e) {
			
			e.printStackTrace();
		} 
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
