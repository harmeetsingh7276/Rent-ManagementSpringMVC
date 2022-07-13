<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List of Tenants</title>
</head>
<body>
	<h1>Rent Management</h1>
	<h2>List of Tenants</h2>
	<form action="createTenant">
		Enter Mobile Number:<input type="text" id="mobileNumber"
			name="mobileNumber" />
		<p />
		Enter Name:<input type="text" id="name" name="name" />
		<p />
		Document URL:<input type="text" id="idProof" name="idProof" />
		<p />
		Enter Deposit:<input type="text" id="deposit" name="deposit" />
		<p />
		Enter Rent:<input type="text" id="rent" name="rent" />
		<p />
		Enter Date Of Deposit:<input type="text" id="dateOfDeposit"
			name="dateOfDeposit" />
		<p />
		Enter Date Of Living:<input type="text" id="dateOfLiving"
			name="dateOfLiving" />
		<p />
		<input type="submit" value="Submit" />
</body>
</html>