<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="project.Model.product"%>
<%@ page import="project.DAO.ProductDao"%>
<%@ page import="project.Connection.ConnectionProvider"%>

<%
ProductDao pd = new ProductDao(ConnectionProvider.getConnection());
List<product> products = pd.getAllProducts();
%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Child Category</title>
<%@ include file="includes/header.jsp" %>
</head>
<body>
	<%@ include file="includes/all.jsp" %>

    <%@ include file="includes/NavBar.jsp" %>

    <div class="container">
        <div class="card-header my-3">All Products</div>
        <div class="row">
            <%
            if (products != null && !products.isEmpty()) {
                for (product p : products) {
            	 	if(p.getCategory().equals("High Top Sneaker")){ %>
                <div class="col-md-3 col-sm-2">
                    <div class="card w-100" style="width: 18rem; height: 30rem">
                        <div class="d-flex align-self-center justify-content-center mt-2" style="height:17rem; width: 15rem">
                            <img class="card-img-top" src="./project-images/<%= p.getImage() %>" alt="<%= p.getName() %>">
                        </div>
                        <div class="card-body">
                            <h5 class="card-title"><%= p.getName() %></h5>
                            <h6 class="price">Price: $<%= p.getPrice() %></h6>
                            <h6 class="category">Category: <%= p.getCategory() %></h6>
                            <div class="mt-3 d-flex justify-content-between">
                                <a href="addtocart?id=<%= p.getId() %>" class="btn btn-dark">Add to cart</a>
                                <a href="ordernow?quantity=1&id=<%=p.getId() %>" class="btn btn-dark">Buy Now</a>
                            </div>
                        </div>
                    </div>
                </div>
                <br>
                											<%} 
            
                							}
            											} 
            else {
                out.print("No products available.");
            } 
            %>
            
               
            
        </div>
        </div>
    

    <%@ include file="includes/footer.jsp" %>
</body>
</html>