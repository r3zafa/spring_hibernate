 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

	<link href="${pageContext.request.contextPath}/resources/images/fav.gif" rel="shortcut icon" >
	<!-- reference our style sheet -->

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/styles.css" />

	<title>Add Customer</title>
	
</head>
<body>


<section class="wrapper">
	<div class="header">
		<h2 class="title">
			CRM - Customer Relationship Manager
		</h2>
	</div>
</section>

<section class="container">
	<div>
	
		<!-- add table -->

		<a class="btn" href="${pageContext.request.contextPath}">
			Home
		</a>		
		<a class="btn" href="${pageContext.request.contextPath}/customer/list/">
			Customer List
		</a>
		<br><br>
		
		
		<form:form action="${pageContext.request.contextPath}/customer/new" 
					modelAttribute="customer" 
					method="POST" cssClass="add-customer">
		
			<form:hidden path="id"/>
		
			<table>
				<tbody>
				
						<tr>
							<td> <label for="firstname">First Name</label> </td>
							<td> <form:input id="firstname" path="firstName"/> </td>
						</tr>
						<tr>
							<td> <label for="lastname">Last Name</label> </td>
							<td> <form:input id="lastname" path="lastName"/> </td>
						</tr>
						<tr>
							<td> <label for="email">Email</label> </td>
							<td> <form:input id="email" path="email"/> </td>
						</tr>
						<tr>
							<td></td>
						
							<td> 
								<form:button id="saveBtn">Save</form:button>
							</td>
						</tr>
				</tbody>	
				
				
			</table>
		
		</form:form>

		
		
		
		
	</div>
</section>


</body>
</html>