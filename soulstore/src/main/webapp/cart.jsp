<%@page import="project.Connection.ConnectionProvider"%>
<%@page import="project.DAO.ProductDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="project.Model.*"%>
<%@ page import="java.util.*"%>
<%@ page import="project.Connection.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<% 
    // Declare total at the top
    double total = 0;
    ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list"); 
    List<Cart> cartProducts = null; 

    if (cart_list != null) {
        ProductDao pdao = new ProductDao(ConnectionProvider.getConnection());
        cartProducts = pdao.getCartProducts(cart_list);
        total = pdao.getTotalCartPrice(cart_list);
        request.setAttribute("cart-list", cart_list);
        request.setAttribute("total", total);
    }
%>

<!DOCTYPE html>
<html>
<head>
    <title>Cart Page</title>
    <%@include file="includes/header.jsp"%>
    <style type="text/css">
        .table tbody td {
            vertical-align: middle;
        }
        .btn-incre, .btn-decre {
            box-shadow: none;
            font-size: 20px;
        }
    </style>
</head>
<body>
    <%@include file="includes/NavBar.jsp"%>

    <div class="container">
        <div class="d-flex py-3">
            <!-- Use the total variable here -->
            <h3>Total Price :- $<%= total %></h3>
            <a class="mx-3 p-2 btn-primary" href="checkingout">Check Out</a>
        </div>

        <table class="table table-light">
            <thead>
                <tr>
                    <th scope="col">Name</th>
                    <th scope="col">Category</th>
                    <th scope="col">Price</th>
                    <th scope="col">Buy Now</th>
                    <th scope="col">Cancel</th>
                </tr>
            </thead>
            <tbody>
                <% if (cart_list != null) {
                    for (Cart c : cartProducts) { %>
                        <tr>
                            <td><%= c.getName() %></td>
                            <td><%= c.getCategory() %></td>
                            <td><%= c.getPrice() %></td>
                            <td>
                                <form action="ordernow" method="get" class="form-inline">
                                    <input type="hidden" name="id" value="<%= c.getId() %>" class="form-input">
                                    <div class="form-group d-flex justify-content-between">
                                        <a class="btn btn-sm btn-decre" href="qunatincdec?action=dec&id=<%= c.getId()%>"><i class="fas fa-minus-square"></i></a>                            
                                        <input type="text" value="<%=c.getQuantity() %>" name="quantity" class="form-input" > 
                                        <a class="btn btn-sm btn-incre" href="qunatincdec?action=inc&id=<%= c.getId()%>"><i class="fas fa-plus-square"></i></a>
                                    </div>
                                    <input type="submit" class="btn btn-primary btn-sm" value="Buy">
                                </form>
                            </td>
                            <td><a class="btn btn-sm btn-danger" href="remove?id=<%= c.getId()%>">Remove</a></td>
                        </tr>
                    <% } 
                } %>
            </tbody>
        </table>
    </div>

    <%@include file="includes/footer.jsp"%>
</body>
</html>
