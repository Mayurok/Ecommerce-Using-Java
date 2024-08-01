<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="project.Model.*" %>
<%@ page import="java.util.ArrayList" %>

<% 
ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
if (cart_list != null) {
    request.setAttribute("cart-list", cart_list);
}%>
<!DOCTYPE html>
<html>
<head>
<title>Login Pages</title>
<%@include file="includes/header.jsp"%>
</head>
<body>
    <%@ include file="includes/NavBar.jsp" %>

<div class="container">
<div class="card w-50 mx-auto my-5">
<div class="card-header text-center">User Login</div>
<div class="card-body">

	<form action="userlogin" method="post">
	
	
	 <div class="form-code">
	 	<label>Email Id</label>
	 	<input type="email" class="form-control" name="email" placeholder="enter your email-id" required>
	 </div>
	 
	 <div class="form-code">
	 	<label>Password</label>
	 	<input type="password" class="form-control" name="password" placeholder="**********" required>
	 </div>
	 <br>
	 <div class="text-center">
	 
	 <button type="submit" class="btn btn-primary">Login</button>	 
 	 <a href="register.jsp" class="btn btn-primary">Register</a>
	 </div>
	</form>
</div>
</div>
</div>



<%@include file="includes/footer.jsp" %>

</body>
</html>