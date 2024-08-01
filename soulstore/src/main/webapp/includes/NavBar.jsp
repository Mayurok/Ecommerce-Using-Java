<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="project.Model.Users"%>
<%@ page import="project.Model.*"%>
<%@ page import="java.util.*"%>

<%
Users auth = (Users) request.getSession().getAttribute("auth");
if(auth != null){
	request.setAttribute("auth", auth);
}%>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container">
			<a class="navbar-brand" href="index.jsp"> Soul Store </a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				  <span class="navbar-toggler-icon"></span> 
			</button>

     
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				 <ul class="navbar-nav ml-auto">
                <li class="nav-item"><a class="nav-link" href="index.jsp">Home</a></li>
                <li class="nav-item"><a class="nav-link" href="cart.jsp">Cart<span class="badge badge-danger"></span></a></li>
                <li class="nav-item"><a class="nav-link" href="orders.jsp">Orders</a></li>
<!--                 <li class="nav-item"><a class="nav-link" href="CategoryChild.jsp">Child Category</a></li>                
 -->                <%if(auth != null && "admin@123".equals(auth.getEmail())){%>
                 <li class="nav-item"><a class="nav-link" href="AddProducts.jsp">Add Product<span class="badge badge-danger"></span></a></li>
                <%}%>
                
                <%if(auth == null ){%>
                  <li class="nav-item"><a class="nav-link" href="Login.jsp">Login</a></li>
                
                <%}%>
                
                <%if(auth != null ){%>
                 <li class="nav-item"><a class="nav-link" href="userlogout" onclick="ConfirmLogout">Logout</a></li>
                
                <%}%>
            </ul>
			</div>
		</div>
	</nav>