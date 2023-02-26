<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>home</title>
	<link href="${pageContext.request.contextPath}/resources/images/fav.gif" rel="shortcut icon" >
</head>
<body>

	<ol>
		<li><a target="blank" href="${pageContext.request.contextPath}/TestDbServlet">Db Connection Test</a></li>
		<li><a href="${pageContext.request.contextPath}/customer/list">CRM - Customer List</a></li>
	</ol>

</body>
</html>