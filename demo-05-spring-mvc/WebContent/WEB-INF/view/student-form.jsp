<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
	<head>
	<title>StudentForm</title>
	
	<style type="text/css">
		.error {
			color:red;
			font-style: italic;
			font-size:0.8rem
		}
	</style>
	</head>
	
	<body>
	<div style="margin:50px;">
	
		<form:form action="processForm" modelAttribute="student" >
		<p>
			First name* : <form:input path="firstName"/>
			<form:errors path="firstName" cssClass="error"/>
		</p>
		
		<p>
			Last name* : <form:input path="lastName"/>
			<form:errors path="lastName" cssClass="error"/>
			
		</p>		
		
		<p>
			Age* : <form:input path="age"/>
			<form:errors path="age" cssClass="error"/>
		</p>
		<p>
			Country: <form:select path="country">

			<!-- load from properties file -->
			  <form:options items="${theCountryOptions}"/>
			  
			<!-- hard coded values -->
			<!-- 
				<form:option value="Germany" label="Germany"/>
				<form:option value="England" label="England"/>
				<form:option value="USA" label="USA"/>
				<form:option value="Iran" label="IRAN"/>
			 -->
			 
			 <!-- load values from java class -->
			 <!-- 
			 	<form:options items="${student.countryOptions}"/>
			  -->

			</form:select>
		</p>
		
		<p>
			Postal Code: <form:input path="postalCode"/>
			<form:errors path="postalCode" cssClass="error"/>
		</p>
			
		<p>
			Course Code: <form:input path="courseCode"/>
			<form:errors path="courseCode" cssClass="error"/>
		</p>
		
		<h4>
			Select your favorate programming language: 
		</h4>
		<p>
			Java <form:radiobutton path="favoriteLanguage" value="Java"/>
			C/C++ <form:radiobutton path="favoriteLanguage" value="C/C++"/>
			PHP <form:radiobutton path="favoriteLanguage" value="PHP"/>
			Python <form:radiobutton path="favoriteLanguage" value="Python"/>
		</p>

		<h4>
			Operating System 
		</h4>
		<p>
			Linux <form:checkbox path="os" value="linux"/>
			macOS <form:checkbox path="os" value="macOS"/>
			Windows <form:checkbox path="os" value="windows"/>
		</p>




		<input type="submit" value="submit"/>
		
		</form:form>
		
		
		</div>
	</body>
	
</html>



