<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Rent Management</h1>
	<h2>List of Details of Tenants</h2>
	<table border="1">
		<tr>
			<th>Mobile Number</th>
			<th>Basic Information</th>
			<th>Update Information</th>
			<th>Operations</th>
		</tr>
		<c:forEach var="tenant" items="${listOfTenants}">
			<tr>
				<td><c:out value="${tenant.getMobileNumber()}" /></td>
				<td>
					<ul>
						<li>Name:<c:out value="${tenant.getName()}" /></li>
						<li>Date Of Deposit Given:<c:out
								value="${tenant.getDateOfDepositGiven()}" /></li>
						<li>Date of Living:<c:out value="${tenant.getDateOfLiving()}" /></li>
						<li>Document URL:<c:out value="${tenant.getIdProof()}" /></li>
						<li>Deposit:<c:out value="${tenant.getDeposit()}" /></li>
						<li>Rent:<c:out value="${tenant.getRent()}" /></li>
					</ul>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>