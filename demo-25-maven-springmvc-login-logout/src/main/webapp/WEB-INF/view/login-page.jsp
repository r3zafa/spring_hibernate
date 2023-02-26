<%@page import="org.springframework.web.servlet.tags.Param"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<html>

<head>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
	
<link href='<c:url value="/resources/app.css"/>' rel="stylesheet">


<meta charset="UTF-8">
<title>login page</title>

</head>

<body class="loginBody container-lg bg-white d-flex flex-column justify-content-center align-items-center">

	<div class="row bg-white p-2 p-md-3 mx-1 mx-lg-0 rounded-3">
	

	<c:if test="${param.logout != null}">
		<div class="alert alert-success alert-dismissible fade show col-12" role="alert">
			<p class="p-0 m-0">logout successful! </p>
			  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
		</div>
	</c:if>
	
	<c:if test="${param.error != null}">
		<div class="alert alert-warning alert-dismissible fade show col-12" role="alert">
			  <p class="p-0 m-0">Sorry! Something went wrong, try again!</p>
			  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
			</div>

	</c:if>
	
	<div class="bg-light p-3 rounded-3 mt-0">
	
		<h2 class="text-center mb-3">Login</h2>
		
		<form:form class="d-flex flex-column p-3"
			action="${pageContext.request.contextPath}/authenticateLogin"
			method="POST">

			<div class="input-group mb-3">
				<span class="input-group-text text-white bg-primary border-2 border-primary border-end-0" id="username-span"><svg
						xmlns="http://www.w3.org/2000/svg" width="24" height="24"
						fill="currentColor" class="bi bi-person" viewBox="0 0 16 16">
						<path
							d="M8 8a3 3 0 1 0 0-6 3 3 0 0 0 0 6zm2-3a2 2 0 1 1-4 0 2 2 0 0 1 4 0zm4 8c0 1-1 1-1 1H3s-1 0-1-1 1-4 6-4 6 3 6 4zm-1-.004c-.001-.246-.154-.986-.832-1.664C11.516 10.68 10.289 10 8 10c-2.29 0-3.516.68-4.168 1.332-.678.678-.83 1.418-.832 1.664h10z" /></svg></span>
				<input type="text" class="form-control border-2 border-primary border-start-0 bg-light" placeholder="Username" name="username"
					aria-label="Username" aria-describedby="username-span">
			</div>


			<div class="input-group mb-3">
				<span class="input-group-text text-white bg-primary border-2 border-primary border-end-0" id="password-span">
					<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="currentColor" class="bi bi-key" viewBox="0 0 16 16">
	  					<path d="M0 8a4 4 0 0 1 7.465-2H14a.5.5 0 0 1 .354.146l1.5 1.5a.5.5 0 0 1 0 .708l-1.5 1.5a.5.5 0 0 1-.708 0L13 9.207l-.646.647a.5.5 0 0 1-.708 0L11 9.207l-.646.647a.5.5 0 0 1-.708 0L9 9.207l-.646.647A.5.5 0 0 1 8 10h-.535A4 4 0 0 1 0 8zm4-3a3 3 0 1 0 2.712 4.285A.5.5 0 0 1 7.163 9h.63l.853-.854a.5.5 0 0 1 .708 0l.646.647.646-.647a.5.5 0 0 1 .708 0l.646.647.646-.647a.5.5 0 0 1 .708 0l.646.647.793-.793-1-1h-6.63a.5.5 0 0 1-.451-.285A3 3 0 0 0 4 5z"/>
	  					<path d="M4 8a1 1 0 1 1-2 0 1 1 0 0 1 2 0z"/>
					</svg>
				</span>
				<input type="password" class="form-control border-2 border-primary border-start-0 bg-light" placeholder="Password" name="password"
					aria-label="Password" aria-describedby="password-span">
			</div>
			

			<button class="btn btn-primary">Login</button>

		</form:form>

	</div>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js">
	</script>
	


</body>
</html>