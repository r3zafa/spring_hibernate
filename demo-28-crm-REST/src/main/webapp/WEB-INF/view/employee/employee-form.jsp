<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/security/tags"%>

<!doctype html>

<html lang="en">

	<head>
		<title>Add new Customer</title>
		<meta charset="UTF-8">
		<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
		<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/app.css" />
	</head>

	<body class="container-flex p-0 m-0 bg-light d-flex flex-column justify-content-center align-items-center">

		<nav class="navbar navbar-expand-md navbar-dark bg-dark fixed-top">
			<div class="container px-2 px-md-3 px-lg-5">
				<a class="navbar-brand" href='${pageContext.request.contextPath}'> Frobese GmbH </a>
				<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown" 
						aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
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
									<a class="dropdown-item disabled" href="#"> role(s): </a>
								</li>
								<li>
									<a class="dropdown-item disabled" href="#"> <s:authentication property="principal.authorities" /></a>
								</li>
							</ul>
						</li>
	
						<li class="nav-item mx-auto my-3 my-md-0">
							<f:form action="${pageContext.request.contextPath}/myLogout" method="POST">
								<button class="nav-link btn btn-sm btn-danger px-4 fw-bold text-white">Logout</button>
							</f:form>
						</li>
	
					</ul>
				</div>
			</div>
		</nav>
	
	
		<section class=" main-body col-12 col-md-10 col-lg-8 col-xl-6 py-3 px-0 p-md-4 ">
			<h2 class="text-center mt-4 d-none d-lg-block">New Employee</h2>
			<h3 class="text-center d-none d-md-block d-lg-none m-0">New Employee</h3>
			<h5 class="text-center d-md-none m-0 mt-3">New Employee</h5>
	
			<f:form action="save" modelAttribute="employee" method="POST" class="d-flex flex-column col-12 mt-0 mb-4 mb-md-0">
				
				<div class="d-flex row justify-content-evenly align-items-center m-4 py-3 py-md-4 border rounded bg-white">
					
					<div class="col-12 col-md-6 col-lg-5 col-xl-6">
						
						<f:hidden path="id" />
						
						<div class="input-group mb-3 mt-2">
							<span class="input-group-text" id="username">U</span>
							<f:input path="username" class="form-control" placeholder="Username" aria-label="Username" aria-describedby="username" />
						</div>
	
						<div class="input-group mb-3">
							<span class="input-group-text" id="password">P</span>
							<f:password path="password" class="form-control" placeholder="Password" aria-label="Password" aria-describedby="password" />
						</div>
	
						<div class="input-group mb-3">
							<span class="input-group-text" id="firstname">F</span>
							<f:input path="firstname" class="form-control" placeholder="Firstname" aria-label="Firstname" aria-describedby="firstname" />
						</div>
	
						<div class="input-group mb-3">
							<span class="input-group-text" id="lastname">L</span>
							<f:input path="lastname" placeholder="Lastname" class="form-control" aria-label="Lastname" aria-describedby="lastname" />
						</div>
	
						<div class="input-group mb-3">
							<span class="input-group-text" id="email">E</span>
							<f:input path="email" placeholder="Email" class="form-control" aria-label="email" aria-describedby="email" />
						</div>
	
					</div>
					
					<div class="col-12 col-md-4 ">
	
						<h5 class="border-bottom pb-1 mt-0 d-none d-lg-block">Roles</h5>
						<p class="border-bottom pb-1 mt-2 d-lg-none">Roles</p>
	
						<div class="form-check form-switch">
							<f:checkbox class="form-check-input" path="authorities" value="" role="switch" id="ROLE_EMPLOYEE" checked="checked" disabled="true" />
							<label class="form-check-label" for="ROLE_EMPLOYEE">Employee</label>
							<f:hidden path="authorities" value="ROLE_EMPLOYEE" />
						</div>
						
						<div class="form-check form-switch">
							<f:checkbox class="form-check-input" path="authorities" value="ROLE_MANAGER" role="switch" id="ROLE_MANAGER" />
							<label class="form-check-label" for="ROLE_EMPLOYEE">Manager</label>
						</div>
	
						<div class="form-check form-switch">
							<f:checkbox class="form-check-input" path="authorities" value="ROLE_ADMIN" role="switch" id="ROLE_ADMIN" />
							<label class="form-check-label" for="ROLE_ADMIN">Admin</label>
						</div>
	
						<div class="form-check form-switch">
							<f:checkbox class="form-check-input" path="authorities" value="ROLE_TESTER" role="switch" id="ROLE_TESTER" />
							<label class="form-check-label" for="ROLE_TESTER">Tester</label>
						</div>
	
						<h5 class="border-bottom pb-1 mt-0 d-none d-lg-block">Active</h5>
						<p class="border-bottom pb-1 mt-3 d-lg-none">Active</p>					
						
						<div class="form-check form-switch">
							<f:checkbox class="form-check-input" path="enabled" value="1" role="switch" id="enabled" />
							<label class="form-check-label" for="enabled">Enable Account</label>
						</div>
					
					</div>
	
				</div>
	
				<button type="submit" class="btn btn-primary col-5 col-md-4 col-lg-3 align-self-center ">Add Employee</button>
	
				<div class="text-center mt-2">
					<a href="${pageContext.request.contextPath}" class="text-muted m-2">home</a>
					<a href="${pageContext.request.contextPath}/employee/list" class=" text-muted m-2">Employees</a>
				</div>
				
			</f:form>
		</section>
	
	
	
		<script src="${pageContext.request.contextPath}/resources/js/bootstrap.bundle.js"></script>
	
	
	</body>
</html>







