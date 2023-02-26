<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page import="de.demo.mvc.util.SortUtils" %>

<!DOCTYPE html>

<html>
<head>
	<title>Customer List</title>
	<link href="${pageContext.request.contextPath}/resources/images/fav.gif" rel="shortcut icon" >
	<!-- reference our style sheet -->

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/styles.css" />

</head>

<body>

	<section class="wrapper">
		<h2>
			CRM - Customer Relationship Manager
		</h2>
	</section>

	<section class="container">
	
		<div class="navbar">
			<a class="btn" href="${pageContext.request.contextPath}">
				home
			</a>		
			<a class="btn" href="${pageContext.request.contextPath}/customer/new/">
				Add Customer
			</a>
		</div>

		<div class="searchForm">
			<form:form action="${pageContext.request.contextPath}/customer/search" method="GET" >
				<input type="text" name="searchString" placeholder="Search" />
				<button value="search" type="submit"class="btn">Search</button>
			</form:form>
		
		</div>

		<div class="list">
			<a class="btn floatingBtn" href="${pageContext.request.contextPath}/customer/list/">
				See all
			</a>
			<table class="list-customer">
		
				<!-- construct a sort link for first name -->
				<c:url var="sortLinkFirstName" value="/customer/list">
					<c:param name="sort" value="<%= Integer.toString(SortUtils.FIRST_NAME) %>" />
				</c:url>					

				<!-- construct a sort link for last name -->
				<c:url var="sortLinkLastName" value="/customer/list">
					<c:param name="sort" value="<%= Integer.toString(SortUtils.LAST_NAME) %>" />
				</c:url>					

				<!-- construct a sort link for email -->
				<c:url var="sortLinkEmail" value="/customer/list">
					<c:param name="sort" value="<%= Integer.toString(SortUtils.EMAIL) %>" />
				</c:url>	
			
			
				<tr>
					<th><a href="${sortLinkFirstName}">First Name</a></th>
					<th><a href="${sortLinkLastName}">Last Name</a></th>
					<th><a href="${sortLinkEmail}">Email</a></th>
					<th>Action</th>
				</tr>
				<!-- loop over customers -->
				<c:forEach  var="tempCustomer" items="${customers}">
				
				<!-- construct update/delete link with customer id -->
					<c:url var="updateLink" value="/customer/update">
						<c:param name="customerId" value="${tempCustomer.id}"></c:param>
					</c:url>				
					
					<c:url var="deleteLink" value="/customer/delete">
						<c:param name="customerId" value="${tempCustomer.id}"></c:param>
					</c:url>
					
					<tr>
						<td> ${tempCustomer.firstName} </td>
						<td> ${tempCustomer.lastName} </td>
						<td> ${tempCustomer.email} </td>
						<!-- display update link -->			
						<td> 
							<a href="${updateLink}">Update</a>
							| 
							<a href="${deleteLink}" onclick="if(!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a>
						</td>					
				
					</tr>
				
				
				</c:forEach>
				
			</table>
		</div>
		
	</section>

</body>
</html>
