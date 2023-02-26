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

<!doctype html>
<html lang="en">

<head>
<title>Login</title>
<meta charset="UTF-8">

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">


<link
	type="text/css"
	rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/app.css" />
</head>

<body
	class="container-flex p-0 m-0 bg-light d-flex flex-column justify-content-center align-items-center">


	<section
		class=" rounded-lg col-10 col-md-8 col-lg-4 p-4 bg-white shadow text-center">
		<h2 class=" mb-3">Login</h2>

		<c:if test="${param.error != null}">
			<div
				class="alert alert-danger alert-dismissible fade show col-12 mb-4"
				role="alert">
				<p class="p-0 m-0">something went wrong! try again</p>
				<button
					type="button"
					class="btn-close"
					data-bs-dismiss="alert"
					aria-label="Close"></button>
			</div>
		</c:if>

		<!-- Login Form -->
		<form class="d-flex flex-column col-12 mt-3 mb-3"
			action="${pageContext.request.contextPath}/authenticateTheUser" method="POST">

			<input
				type="hidden"
				name="${_csrf.parameterName}"
				value="${_csrf.token}" />


			<!-- User name -->
			<div class="input-group mb-3">
				<span
					class="input-group-text"
					id="username">UN</span> <input
					type="text"
					name="username"
					placeholder="Username"
					class="form-control"
					aria-label="Username"
					aria-describedby="username">

			</div>


			<!-- Password -->
			<div class="input-group mb-3">
				<span
					class="input-group-text"
					id="password">PW</span> <input
					type="password"
					name="password"
					placeholder="Password"
					aria-label="Password"
					aria-describedby="password"
					class="form-control">
			</div>


			<button
				type="submit"
				class="btn btn-primary col-12 col-md-8 col-lg-6 align-self-center mt-4">Sign in</button>

		</form>

		<a href="${pageContext.request.contextPath}" class="text-muted">Home</a>


	</section>










	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>


</body>
</html>