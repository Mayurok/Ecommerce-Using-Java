<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="project.Model.*" %>

<%-- <%
Users auth = (Users) request.getSession().getAttribute("auth");
if(auth != null){
	request.setAttribute("auth", auth);
}%> --%>
<%@ page import="java.util.ArrayList" %>

<% 
ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
if (cart_list != null) {
    request.setAttribute("cart-list", cart_list);
}%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="includes/header.jsp" %>
</head>
<body>
    <%@ include file="includes/NavBar.jsp" %>

<div class="container">
<div class="card w-50 mx-auto my-5">
<div class="card-header text-center">Register</div>
<div class="card-body">

	<form action="user" method="post">
	
	<div class="form-code">
	 	<label>Name</label>
	 	<input type="text" class="form-control" name="loginname" placeholder="enter your user-name" required>
	 </div>
	 
	 <div class="form-code">
	 	<label>Email Id</label>
	 	<input type="email" class="form-control" name="loginemail" placeholder="enter your email-id" required>
	 </div>
	 
	 <div class="form-code">
	 	<label>Password</label>
	 	<input type="password" class="form-control" name="loginpassword" placeholder="**********" required>
	 </div>
	 <br>
	 <div class="text-center">
	 <a href="Login.jsp" class="btn btn-primary">login</a>
	 <button type="submit" class="btn btn-primary">Register</button>
	 
	 </div>
	</form>
</div>
</div>
</div>



<%@include file="includes/footer.jsp" %>
</body>
</html>