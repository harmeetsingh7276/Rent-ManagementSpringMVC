<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List of Tenants</title>
</head>
<body>
	<h1>Rent Management</h1>
	<h2>List of Tenants</h2>
	<form:form action="createTenant" modelAttribute="tenant">
		Enter Mobile Number:<form:input path="mobileNumber" />
		<p />
		Enter Name:<form:input path="name" />
		<p />
		Document URL:<form:input path="idProof" />
		<p />
		Enter Deposit:<form:input path="deposit" />
		<p />
		Enter Rent:<form:input path="rent" />
		<p />
		Enter Date Of Deposit:<form:input path="dateOfDepositGiven" />
		<p />
		Enter Date Of Living:<form:input path="dateOfLiving" />
		<p />
		<input type="submit" value="Submit" />
	</form:form>
</body>
</html>