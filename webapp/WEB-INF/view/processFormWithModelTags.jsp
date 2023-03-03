<!-- This line is required for using the for for-each loop in JSP file (only on JSP file, not HTML file) -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

<body>
	Information
	
	<br>
	<br>
	<!-- Retrieve data from the model attribute by ${attributeName.fieldName} -->
	First name: ${student.firstName}
	<br>
	Last name: ${student.lastName}
	<br>
	Point: ${student.point}
	<br>
	Country: ${student.country}
	<br>
	Postal Code: ${student.postalCode}
	<br>
	Major: ${student.major}
	<br>
	Hobbies: 
	<ul>
	<c:forEach var="temp" items="${student.hobbies}"> 
	<li>${temp}</li>
	</c:forEach>
	</ul>
	<br>
	Book voucher: ${student.bookVoucher}
</body>

</html>