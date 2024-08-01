package project.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.Connection.ConnectionProvider;
import project.DAO.OrderDao;
import project.Model.Cart;
import project.Model.Order;
import project.Model.Users;

//@WebServlet("/checkout")
@WebServlet("/checkingout")

public class CheckOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try(PrintWriter out = response.getWriter()){
			 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			 Date date = new Date();
			 
			 @SuppressWarnings("unchecked")
			 ArrayList<Cart> cart_list = (ArrayList<Cart>) request.getSession().getAttribute("cart-list");
			 Users auth = (Users)request.getSession().getAttribute("auth");
			 
			 if(cart_list != null && auth !=  null)
			 {
				 for(Cart c :cart_list)
				 {
					 Order order = new Order();
					 order.setId(c.getId());
					 order.setuId(auth.getId());
					 order.setQuantity(c.getQuantity());
					 order.setDate(formatter.format(date));
					 
					 OrderDao odao = new OrderDao(ConnectionProvider.getConnection());
					 boolean result = odao.insertOrder(order);
					 
					 if(!result) break;
					 
				 }
				 cart_list.clear();
				 response.sendRedirect("orders.jsp");
				 
			 }else {
				 if(auth == null) {response.sendRedirect("Login.jsp");}

			 }

			 }catch(Exception e){
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
