<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="project.Connection.ConnectionProvider"%>
<%@ page import="project.Model.product"%>
<%@ page import="project.DAO.ProductDao"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
// Initialize product DAO and retrieve products
ProductDao pd = new ProductDao(ConnectionProvider.getConnection());
List<product> products = pd.getAllProducts();

/* ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
if (cart_list != null) {
    request.setAttribute("cart-list", cart_list);
} */
%>


<!DOCTYPE html>
<html>
<head>
<title>Welcome to Ecom!</title>
<%@ include file="includes/header.jsp"%>
</head>
<body>
	<%@ include file="includes/all.jsp"%>

	<%@ include file="includes/NavBar.jsp"%>

	<div class="container">
		<div class="card-header my-3">All Products</div>
		<div class="row">
			<%
			product p = null;
			%>
			<div class="col-md-3 col-sm-2 pt-3">
				<div class="card w-100" style="width: 18rem; height: 30rem">
					<div class="d-flex align-self-center justify-content-center mt-2"
						style="height: 17rem; width: 15rem">
						<a href="CategoryHighTop.jsp"> <img class="card-img-top" src="./project-images/HighTop.jpg"
							alt="HighTop shoes image"></a>
					</div>
					<div class="card-body">
						<br>
						<br>
						<br>
						<br>
						<h5 class="card-title align-item-center">High Top Shoes</h5>
						<div class="mt-3 d-flex justify-content-between"></div>
					</div>
				</div>
			</div>

			<div class="col-md-3 col-sm-2 pt-3">
				<div class="card w-100" style="width: 18rem; height: 30rem">
					<div class="d-flex align-self-center justify-content-center mt-2"
						style="height: 17rem; width: 15rem">
						<a href="CategorySneakers.jsp"> <img class="card-img-top" src="./project-images/sneaker.jpg"
							alt="HighTop shoes image"></a>
					</div>
					<div class="card-body">
						<br>
						<br>
						<br>
						<br>
						<h5 class="card-title">Sneaker</h5>
						<div class="mt-3 d-flex justify-content-between"></div>
					</div>
				</div>
			</div>

			<div class="col-md-3 col-sm-2 pt-3">
				<div class="card w-100" style="width: 18rem; height: 30rem">
					<div class="d-flex align-self-center justify-content-center mt-2"
						style="height: 17rem; width: 15rem">
						<a href="CategorySliders.jsp"> <img class="card-img-top" src="./project-images/sliders.jpg"
							alt="HighTop shoes image"></a>
					</div>
					<div class="card-body">
						<br>
						<br>
						<br>
						<br>
						<h5 class="card-title">Sliders</h5>
						<div class="mt-3 d-flex justify-content-between"></div>
					</div>
				</div>
			</div>

			<div class="col-md-3 col-sm-2 pt-3">
				<div class="card w-100" style="width: 18rem; height: 30rem">
					<div class="d-flex align-self-center justify-content-center mt-2"
						style="height: 17rem; width: 15rem">
						<a href="CategoryChild.jsp"> <img class="card-img-top" src="./project-images/child.avif" alt="HighTop shoes image"></a>
					</div>
					<div class="card-body">
						<br>
						<br>
						<br>
						<br>
						<h5 class="card-title">Children's</h5>
						<div class="mt-3 d-flex justify-content-between"></div>
					</div>
				</div>
			</div>

		</div>
	</div>

	<%@ include file="includes/footer.jsp"%>
</body>
</html>
