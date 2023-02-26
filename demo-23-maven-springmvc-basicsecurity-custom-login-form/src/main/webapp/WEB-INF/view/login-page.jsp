<%@page import="org.springframework.web.servlet.tags.Param"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<html>

<head>
	<meta charset="UTF-8">
	<title>login page</title>
	<link rel="stylesheet"
		href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css"
		integrity="sha512-HK5fgLBL+xu6dm/Ii3z4xhlSUyZgTT9tuc/hSrtw6uzJOvgRr2a9jyxxT1ely+B+xFAmJKVSTbpM/CuL7qxO8w=="
		crossorigin="anonymous" />
			
	<link href='<c:url value="/resources/app.css"/>' rel="stylesheet">
</head>

<body class="login-body">

	<div class="form-body">

		<c:if test="${param.error != null}">

			<p class="error-msg">Sorry! Something went wrong, try again!</p>

		</c:if>

		<h1 class="form-header">Login</h1>


		<form:form
			action="${pageContext.request.contextPath}/authenticateLogin"
			method="POST">

			<input class="form-input" type="text" name="username"
				placeholder="Username">
			<input class="form-input" type="password" name="password"
				placeholder="Password">
			<button class="form-btn form-btn-5">Login</button>

		</form:form>

	</div>


</body>
</html>