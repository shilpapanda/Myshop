<%@ page language="java" contentType="text/html" import="com.myshop.MyshopBackend.model.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html>
<head>

<title>Category</title>
</head>
<body>

<form action="CategoryAddition" method="get">
<table align="center">
	<tr><td colspan="2"><center>Cateogry Details</center></td></tr>
	
	<tr>
		<td>CategoryID</td>
		<td><input type="text" name="catid"/></td>
	</tr>
	<tr>
		<td>Category Name</td>
		<td><input type="text" name="catname"/></td>
	</tr>
	<tr>
		<td>Category Desc</td>
		<td><textarea name="catdesc" cols="20" rows="5"></textarea></td>
	</tr>
	
	<tr>
		<td colspan="2"><center><input type="submit" value="SUBMIT"/></center></td>
	</tr>
	
</table>

</form>

<table cellspacing="2" cellpadding="2" align="center">

<tr bgcolor="pink">
	<td>Category ID</td>
	<td>Category Name</td>
	<td>Description</td>
	<td>Operation</td>
</tr>

<c:forEach items="${catlist}" var="cat">
<tr bgcolor="cyan">
	<td>${cat.catid}</td>
	<td>${cat.catname}</td>
	<td>${cat.catdesc}</td>
	<td>
		<a href="<c:url value="deleteCategory/${cat.catid}"/>">Delete</a>
		<a href="<c:url value="updateCategory/${cat.catid}"/>">Update</a>
	</td>
</tr>
</c:forEach>


</table>


</body>
</html>