<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>

<html>

	<head>
		<title>List of Employees</title>
		<meta charset="UTF-8">
		<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
		<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/app.css" />
		
	</head>

	<body class="container-flex p-0 m-0">
	
	
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
					    <button class="nav-link btn btn-sm btn-danger px-4 text-white fw-bold">Logout</button>
					</f:form>
				</li>
		        
		      </ul>
		    </div>
		  </div>
		</nav>
				
	
		<section class="main-body row container mx-auto">
		
		<h2 class="col-11 text-center p-0 m-0  my-5">Employees CRM</h2>
	
		<div class="col-11 d-flex flex-row flex-wrap  p-0 m-0 justify-content-between">
		
			<a class="btn btn-md btn-warning" href="${pageContext.request.contextPath}">Home</a>
			
			<s:authorize access="hasRole( 'ADMIN')">
				<a class="btn btn-md btn-primary" href="add"> New Employee </a>
			</s:authorize>
			
		</div>
		
		
		<div class="col-11 d-flex flex-row flex-wrap justify-content-evenly align-items-center p-0 m-0 mt-4 mb-5 ">
	
				
					<table class="customer-table w-100 text-center shadow">
						<thead>
		
							<tr>
								<th>Username</th>
								<th class="d-none d-md-table-cell">Firstname</th>
								<th class="d-none d-md-table-cell">Lastname</th>
								<th>Email</th>
								<th class="d-none d-md-table-cell">Authorities</th>							
								<th>Active</th>
	
		
								<%-- Only show "Action" column for managers or admin --%>
								<s:authorize access="hasRole('ADMIN')">
		
									<th>Action</th>
		
								</s:authorize>
		
							</tr>
		
						</thead>
				
						<tbody>
		
							<!-- loop over and print our customers -->
							<c:forEach
								var="tempCustomer"
								items="${users}">
		
								<!-- construct an "update" link with customer id -->
								<c:url
									var="updateLink"
									value="/employee/update">
									<c:param
										name="username"
										value="${tempCustomer.username}" />
								</c:url>
		
								<!-- construct an "delete" link with customer id -->
								<c:url
									var="deleteLink"
									value="/employee/delete">
									<c:param
										name="username"
										value="${tempCustomer.username}" />
								</c:url>
		
								<tr>
									<td>${tempCustomer.username}</td>
									<td class="d-none d-md-table-cell">${tempCustomer.firstname}</td>
									<td class="d-none d-md-table-cell">${tempCustomer.lastname}</td>
									<td>${tempCustomer.email}</td>
									<td class="d-none d-md-table-cell">${tempCustomer.authorities}</td>
									<td>${tempCustomer.enabled}</td>
	
									<s:authorize access="hasRole('ADMIN')">
		
										<td>
										
											<s:authorize access="hasAnyRole('MANAGER', 'ADMIN')">
												<!-- display the update link -->
											</s:authorize> 
											
											<s:authorize access="hasRole('ADMIN')">
												<a class="m-1" href="${updateLink}">Update</a>
												<a id="deleteBtn" class="m-1" href="${deleteLink}">Delete</a>
											</s:authorize>
			
										</td>
									</s:authorize>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				
			</div>
		
		</section>
		</s:authorize>
	
	
		<script src="${pageContext.request.contextPath}/resources/js/bootstrap.bundle.js"></script>
		<script src="${pageContext.request.contextPath}/resources/js/app.js"></script>
	
	
	</body>

</html>









