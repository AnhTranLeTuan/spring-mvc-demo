<!-- This line is require for using Spring MVC form tags -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>

<!-- Define a simple CSS style for marking errors if prerperties are not satisfied with validation rules -->
<style>
	.error{color:red}
</style>

<head>
	<title>Student Form</title>
</head>

<body>
	<!-- the main benefit of Spring VMC form tags is data binding that include in the model attribute 
	(also generating HTML code) -->
	<!-- When the form is loaded, the object stored in the model attribute will call getter methods to 
	retrieve and display the data. When the form is submitted, the object will call setter methods store 
	the new information -->
	<form:form action="processFormWithModelTagsValidation" modelAttribute="student">
		<!-- the "path" attribute of the tags is corresponding for the object field of the model attribute -->
		First name: <form:input path="firstName"/>
		<form:errors path="firstName" cssClass="error"/>
		<br>
		Last name: <form:input path="lastName"/>
		<form:errors path="lastName" cssClass="error"/>
		<br>
		Point: <form:input path="point" />
		<form:errors path="point" cssClass="error"/>
		<br>
		Country:     
		<form:select path="country">
			<!-- We can either hard code the drop-down list by using form:option or
			using form:options and reading the list (from the object, database,...) utilize the model attribute -->
			<!-- 
			<form:option value="US" label="United States"/>
			<form:option value="GB" label="Great Britain"/>
			<form:option value="VN" label="VietNam"/>
			-->
			<!-- The getter method for the corresponding field will be called for retrieving the data 
			(fields are all private either way) -->
			<form:options items="${student.countryOptions}"/>
		</form:select>
		<br>
		Postal Code: <form:input path="postalCode" />
		<form:errors path="postalCode" cssClass="error"/>
		<br>
		<!-- Hard code version -->
		<!--
		Walking <form:radiobutton path="major" value="Computer Science"/>
		Cooking <form:radiobutton path="major" value="Psychology"/>
		Shopping <form:radiobutton path="major" value="Biology"/>
		-->
		<!-- Reading from the source (in this case the Java object) version -->
		<!-- For radio buttons, Spring MVC also add the label that corresponding to the value, so
		we don't have to manually add the label like the hard code version -->
		Major: 
		<form:radiobuttons path="major" items="${student.majorOptions}"/>
		<form:errors path="major" cssClass="error"/>
		<br>
		Hobbies: 
		<br>
		Walking <form:checkbox path="hobbies" value="Walking"/>
		<br>
		Cooking <form:checkbox path="hobbies" value="Cooking"/>
		<br>
		Shopping <form:checkbox path="hobbies" value="Shopping"/>
		<br>
		Book Voucher: <form:input path="bookVoucher" />
		<form:errors path="bookVoucher" cssClass="error"/>
		<br>
		<input type="submit" value="Submit"/>
	
	</form:form>
</body>

</html>


