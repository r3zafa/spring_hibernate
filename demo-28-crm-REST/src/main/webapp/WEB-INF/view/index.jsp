<%@ page
	language="java"
	contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib
	prefix="c"
	uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib
	prefix="f"
	uri="http://www.springframework.org/tags/form"%>
<%@ taglib
	prefix="s"
	uri="http://www.springframework.org/security/tags"%>


<!DOCTYPE html>
<html>

<head>
<title>Frobese CRM</title>
<meta charset="UTF-8">

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">


<link
	type="text/css"
	rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/app.css" />



</head>

<body class="container-flex p-0 m-0 bg-light">

<s:authorize access="!isAuthenticated()">
	<nav class="navbar navbar-dark bg-dark fixed-top">
	  <div class="container  px-2 px-md-3 px-lg-5">
	    <a class="navbar-brand" href='${pageContext.request.contextPath}'> Frobese GmbH </a>
	  </div>
	</nav>

	<section class="main-body row">
	
		<c:if test="${param.logout != null}">
			<div class="alert alert-success alert-dismissible fade show col-10 col-md-8 mt-5" role="alert">
				<p class="p-0 m-0">logout successful! </p>
				  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
			</div>
		</c:if>
		
		<h2 class="text-center p-0 m-0 col-10 col-md-8 mt-4 ">Welcome to Frobese CRM</h2>
					
			
		<a class="btn btn-lg btn-primary col-6 col-md-3 mt-4 shadow-sm" href="${pageContext.request.contextPath}/loginPage">login</a>
		<p class="text-center p-0 m-0 mt-2 text-muted">
			please login to continue 
		</p>
		
	</section>


</s:authorize>

<s:authorize access="isAuthenticated()">

	<nav class="navbar navbar-expand-md navbar-dark bg-dark fixed-top">
	  <div class="container px-2 px-md-3 px-lg-5">
	    <a class="navbar-brand" href='${pageContext.request.contextPath}'> Frobese GmbH </a>
	    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
	      <span class="navbar-toggler-icon"></span>
	    </button>
	    <div class="collapse navbar-collapse" id="navbarNavDropdown">
	      <ul class="navbar-nav ms-auto">
	
	        <li class="nav-item dropdown mb-2 mb-md-0 text-center">
	          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">
					Hey, <s:authentication property="principal.username" />
	          </a>
	          <ul class="dropdown-menu bg-dark text-white text-center text-md-start" aria-labelledby="navbarDropdownMenuLink">
	             <li>
		            <a class="dropdown-item disabled" href="#">
		            	role(s):
		            </a>
	            </li>
	            <li>
		            <a class="dropdown-item disabled" href="#">
		            	<s:authentication property="principal.authorities"/>
		            </a>
	            </li>
	          </ul>
	        </li>
	        
	        <li class="nav-item mx-auto my-3 my-md-0">
				<f:form  action="${pageContext.request.contextPath}/myLogout" method="POST">
				    <button class="nav-link btn btn-sm btn-danger px-4 fw-bold text-white">Logout</button>
				</f:form>
			</li>
	        
	      </ul>
	    </div>
	  </div>
	</nav>
	
	<section class="main-body row container mx-auto">

			<c:if test="${param.registered != null}">
			<div class="alert alert-success alert-dismissible fade show col-12 mt-3" role="alert">
				<p class="p-0 m-0">new User have been added! </p>
				  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
			</div>
			</c:if>
	
			<h2 class="text-center p-0 m-0 col-12 mt-5 ">Frobese CRM</h2>
				
				<div class="col-12 d-flex flex-row flex-wrap justify-content-evenly align-items-center mt-4 mb-5 ">
				
					<s:authorize access="hasAnyRole('ADMIN','EMPLOYEE','MANAGER') ">
						<div class="card p-1 my-3 mx-2 border-0 shadow" style="width: 14rem;height: 14rem;background-color: #e9edc9">
						  <div class="card-body mt-2">
						    <h4 class="card-title">Customers List</h4>
						    <p class="card-text">Sorted list of all customers with lastname</p>
						    <a href="${pageContext.request.contextPath}/customer/list" class="stretched-link"></a>
						  </div>
						</div>
					</s:authorize>
					
					<s:authorize access="hasAnyRole('ADMIN','EMPLOYEE','MANAGER') ">
						<div class="card p-1 my-3 mx-2 border-0 shadow" style="width: 14rem;height: 14rem;background-color: #e9edc9">
						  <div class="card-body mt-2">
						    <h4 class="card-title">Employees List</h4>
						    <p class="card-text">Sorted list of all employees with username</p>
						    <a href="${pageContext.request.contextPath}/employee/list" class="stretched-link"></a>
						  </div>
						</div>
					</s:authorize>

					<s:authorize access="hasRole('ADMIN') ">
						<div class="card p-1 my-3 mx-2 border-0 shadow" style="width: 14rem;height: 14rem;background-color: #e9edc9">
						  <div class="card-body mt-2">
						    <h4 class="card-title">Add Employee</h4>
						    <p class="card-text">add new Employees with different Role(s) in this page.</p>
						    <a href="${pageContext.request.contextPath}/employee/add" class="stretched-link"></a>
						  </div>
						</div>
					</s:authorize>

					<s:authorize access="hasAnyRole('MANAGER', 'ADMIN')">
						<div class="card p-1 my-3 mx-2 border-0 shadow" style="width: 14rem;height: 14rem;background-color: #e9edc9">
						  <div class="card-body mt-2">
						    <h4 class="card-title">Add Customer</h4>
						    <p class="card-text">You can add new Customers in this page.</p>
						    <a href="${pageContext.request.contextPath}/customer/add" class="stretched-link"></a>
						  </div>
						</div>
						
					</s:authorize>
				
				
				</div>
	
	</section>

</s:authorize>


	

	


	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>


</body>
</html>