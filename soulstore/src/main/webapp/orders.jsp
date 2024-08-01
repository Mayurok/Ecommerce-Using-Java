<%@ page import="project.Connection.ConnectionProvider"%>
<%@ page import="project.DAO.OrderDao"%>
<%@ page import="java.text.DecimalFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="project.Model.*"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>


<%
List<Order> orders = null;

DecimalFormat dcf = new DecimalFormat("#.##");
request.setAttribute("dcf", dcf);

ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
if (cart_list != null) {
	request.setAttribute("cart-list", cart_list);
}
%>

<!DOCTYPE html>
<html>
<head>
<title>Orders Page</title>
<%@ include file="includes/header.jsp"%>
</head>
<body>

	<%@ include file="includes/NavBar.jsp"%>
	<%
	auth = (Users) request.getSession().getAttribute("auth");
	if (auth != null) {
		request.setAttribute("auth", auth);
		orders = new OrderDao(ConnectionProvider.getConnection()).userorder(auth.getId());
	} else {
		response.sendRedirect("Login.jsp");
		//return;
	}
	%>
	<div class="container">
		<div class="d-flex py-3">
    		<div class="card-header my-3">All Orders</div>
    		<div class="ml-auto"><a class="btn btn-primary btn-sm my-3 mr-10" href="bills">Confirm Order's</a></div>
		</div>


		<table class="table table-light">
			<thead>
				<tr>
					<th scope="col">Name</th>
					<th scope="col">Category</th>
					<th scope="col">Price</th>
					<th scope="col">Quantity</th>
					<th scope="col">Cancel</th>
				</tr>
			</thead>
			<tbody>
				<%
				if (orders != null) {
					for (Order o : orders) {
				%>
				<tr>
					<td><%=o.getName()%></td>
					<td><%=o.getCategory()%></td>
					<td><%=dcf.format(o.getPrice())%></td>
					<td><%=o.getQuantity()%></td>
					<td><a class="btn btn-danger btn-sm" href="cancelorder?id=<%=o.getOrderId()%>">Cancel</a></td>
				</tr>
				<%
				}
				}
				%>
			</tbody>
		</table>
	</div>

	<%@ include file="includes/footer.jsp"%>
</body>
</html>
