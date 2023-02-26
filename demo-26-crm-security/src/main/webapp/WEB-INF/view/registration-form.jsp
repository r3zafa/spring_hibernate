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
	<title>Register - new User</title>
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

	<nav class="navbar navbar-expand-md navbar-dark bg-dark fixed-top">
		<div class="container px-2 px-md-3 px-lg-5">
			<a
				class="navbar-brand"
				href='${pageContext.request.contextPath}'> Frobese GmbH </a>
			<button
				class="navbar-toggler"
				type="button"
				data-bs-toggle="collapse"
				data-bs-target="#navbarNavDropdown"
				aria-controls="navbarNavDropdown"
				aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div
				class="collapse navbar-collapse"
				id="navbarNavDropdown">
				<ul class="navbar-nav ms-auto">

					<li class="nav-item dropdown mb-2 mb-md-0 text-center"><a
						class="nav-link dropdown-toggle"
						href="#"
						id="navbarDropdownMenuLink"
						role="button"
						data-bs-toggle="dropdown"
						aria-expanded="false"> Hey, <s:authentication
								property="principal.username" />
					</a>
						<ul
							class="dropdown-menu bg-dark text-white text-center text-md-start"
							aria-labelledby="navbarDropdownMenuLink">
							<li><a
								class="dropdown-item disabled"
								href="#"> role(s): </a></li>
							<li><a
								class="dropdown-item disabled"
								href="#"> <s:authentication property="principal.authorities" />
							</a></li>
						</ul></li>

					<li class="nav-item mx-auto my-3 my-md-0"><f:form
							action="${pageContext.request.contextPath}/myLogout"
							method="POST">
							<button
								class="nav-link btn btn-sm btn-danger px-4 fw-bold text-white">Logout</button>
						</f:form></li>

				</ul>
			</div>
		</div>
	</nav>

	<section class=" rounded-lg main-body col-10 col-md-8 col-lg-4 p-4 bg-white shadow">


		<c:if test="${registrationError != null}">
			<div
				class="alert alert-success alert-dismissible fade show col-12 mb-4"
				role="alert">
				<p class="p-0 m-0">${registrationError}</p>
				<button
					type="button"
					class="btn-close"
					data-bs-dismiss="alert"
					aria-label="Close"></button>
			</div>
		</c:if>

		<h2 class="text-center mb-3">Add new user</h2>
		<f:form
			action="${pageContext.request.contextPath}/processRegistration"
			modelAttribute="crmUser"
			class="d-flex flex-column col-12 mt-3">


			<div class="input-group mb-3">
				<span
					class="input-group-text"
					id="username">UN</span>

				<f:input
					path="userName"
					class="form-control"
					placeholder="Username"
					aria-label="Username"
					aria-describedby="username" />
			</div>




			<div class="input-group mb-3">
				<span
					class="input-group-text"
					id="password">PW</span>

				<f:input
					path="password"
					placeholder="Password"
					class="form-control"
					aria-label="Password"
					aria-describedby="password" />
			</div>



			<div class="input-group mb-3">
				<span
					class="input-group-text"
					id="select">Responsibility</span>

				<f:select
					class="form-select"
					path="formRole"
					items="${roles}"
					aria-describedby="select" />
			</div>


			<button
				type="submit"
				class="btn btn-primary col-12 col-md-8 col-lg-6 align-self-center mt-4">Register</button>

		</f:form>

		<a
			href="${pageContext.request.contextPath}"
			class="mt-3 text-muted">Home</a>




	</section>










	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>


</body>
</html>