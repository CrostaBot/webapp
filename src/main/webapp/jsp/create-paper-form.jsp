<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<title>Create paper Form</title>
	</head>

  <body>
	<h1>Create paper Form</h1>

	<form method="POST" action="<c:url value="/create-paper"/>">
		<label for="title">title:</label>
		<input name="title" type="text"/><br/>

		<label for="authors">authors:</label>
		<input name="authors" type="text"/><br/>

		<label for="year">year:</label>
		<input name="year" type="text"/><br/>

		<label for="mDate">mDate:</label>
		<input name="mDate" type="text"/><br/><br/>

		<button type="submit">Submit</button><br/>
		<button type="reset">Reset the form</button>
	</form>
	</body>
</html>
