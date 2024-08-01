package project.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.Model.Cart;

/**
 * Servlet implementation class QunatityIncDecServlet
 */
@WebServlet("/qunatincdec")
public class QunatityIncDecServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            String action = request.getParameter("action");
            int id = Integer.parseInt(request.getParameter("id"));

            @SuppressWarnings("unchecked")
            ArrayList<Cart> cart_list = (ArrayList<Cart>) request.getSession().getAttribute("cart-list");

            if (action != null && id >= 1 && cart_list != null) {
                if (action.equals("inc")) {
                    for (Cart c : cart_list) {
                        if (c.getId() == id) {
                            int quantity = c.getQuantity();
                            quantity++;
                            c.setQuantity(quantity);
                            break; // Exit the loop once the item is found and updated
                        }
                    }
                } 
                if (action.equals("dec")) {
                    for (Cart c : cart_list) {
                        if (c.getId() == id) {
                            int quantity = c.getQuantity();
                            if (quantity > 1) {
                                quantity--;
                                c.setQuantity(quantity);
                            }
                            break; // Exit the loop once the item is found and updated
                        }
                    }
                }
                // Redirect after processing the action
                response.sendRedirect("cart.jsp");
            } else {
                // Redirect if action is null or id is invalid
                response.sendRedirect("cart.jsp");
            }
        }
    }
}
