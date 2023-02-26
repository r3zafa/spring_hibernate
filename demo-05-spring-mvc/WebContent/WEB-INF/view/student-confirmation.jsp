<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>confirmed!</title>
</head>
<body>
<div style="margin:50px;">

	<H1 style="color:red;">Confirmation</H1>
	First name: ${student.firstName} <br/>
	Last name: ${student.lastName} <br/>
	Age: ${student.age} <br/>
	Region: ${student.country} <br/>
	Postal Code: ${student.postalCode} <br/>
	Course Code: ${student.courseCode} <br/>
	Favorite Language: ${student.favoriteLanguage}<br/>
	Operating System(s): 
		<c:forEach var="temp" items="${student.os}"> 
			- ${temp}
		</c:forEach>


</div>


	
</body>
</html>
