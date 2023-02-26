<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/security/tags"%>


<!DOCTYPE html>
<html>

	<head>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
		<link href='<c:url value="/resources/app.css"/>' rel="stylesheet">
		<meta charset="UTF-8">
		<title >Homepage</title>
	</head>
	
	<body class="container-lg p-0">
	
		<nav class="navbar navbar-dark bg-dark">
		  <div class="container-fluid">
		    <span class="latter-spacing-1 navbar-text fw-bolder ls-2">
		      {LOGO}
		    </span>
		    		
		    <f:form action="${pageContext.request.contextPath}/myLogout" method="POST">
		    	<button class="btn btn-sm btn-danger">
		    		Logout
		    	</button>
		    </f:form>
		
		
		  </div>
		</nav>
		
		
		<div class="alert alert-success alert-dismissible fade show rounded-0 m-1 mx-md-0" role="alert">
			<p class="p-0 m-0"> Welcome, 
				<s:authentication property="principal.username"/>! 
				<s:authentication property="principal.authorities"/> 
			</p>
			<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
		</div>
		
		
		
		
		
		<div class="m-1 mx-4 mx-md-0">
			
			
			<h1 class="text-center py-4">Home</h1>
		
		
			<table class="table table-bordered border-primary">

			  <tbody>
			    <tr>
			      <td class="width-first-column bg-primary text-white border-0 border-bottom border-white">
			      	Profile
			      </td>
			      <td>
			      	<a href="${pageContext.request.contextPath}/profile">Link</a>
			      </td>
			    </tr>
			    <tr>
			      <td class="bg-primary text-white border-0 border-top border-white">
			      Management
			      </td>
			      <td>
			      	<a href="${pageContext.request.contextPath}/management">Link</a>
			      </td>
			    </tr>			    
			    <tr>
			      <td class="bg-primary text-white border-0 border-top border-white">
			      System
			      </td>
			      <td>
			      	<a href="${pageContext.request.contextPath}/system">Link</a>
			      </td>
			    </tr>
		  </tbody>
			
			</table>
		
		
		
		</div>
		
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
			
	
	</body>
</html>