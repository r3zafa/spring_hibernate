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


<title>Add new Customer</title>
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


	<section
		class=" rounded-lg main-body col-10 col-md-8 col-lg-4 p-4 bg-white shadow">

		<h2 class="text-center mb-3">Add new Customer</h2>

		<f:form
			action="saveCustomer"
			modelAttribute="customer"
			method="POST"
			class="d-flex flex-column col-12 mt-3">

			<f:hidden path="id" />


			<div class="input-group mb-3">
				<span
					class="input-group-text"
					id="firstname">FN</span>

				<f:input
					path="firstName"
					class="form-control"
					placeholder="Firstname"
					aria-label="Firstname"
					aria-describedby="firstname" />
			</div>


			<div class="input-group mb-3">
				<span
					class="input-group-text"
					id="lastname">LN</span>

				<f:input
					path="lastName"
					placeholder="Lastname"
					class="form-control"
					aria-label="Lastname"
					aria-describedby="lastname" />
			</div>

			<div class="input-group mb-3">
				<span
					class="input-group-text"
					id="email">@</span>

				<f:input
					path="email"
					placeholder="Email"
					class="form-control"
					aria-label="email"
					aria-describedby="email" />
			</div>



			<button
				type="submit"
				class="btn btn-primary col-12 col-md-8 col-lg-6 align-self-center mt-4">Register</button>

		</f:form>
		
		<a href="${pageContext.request.contextPath}" class="mt-3 text-muted">Home</a>
		

	</section>



	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>


</body>
</html>







