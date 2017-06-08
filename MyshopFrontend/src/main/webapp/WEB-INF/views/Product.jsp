<%@ page language="java" contentType="text/html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Product Page- Myshop</title>
</head>
<body>

	<form:form action="InsertProduct" modelAttribute="product" enctype="multipart/form-data">
		<table align="center">
			<tr>
				<td colspan="2"><center>Product Details</center></td>
			</tr>
			<tr>
				<td>Product ID</td>
				<td><form:input path="prodid" /></td>
			</tr>
			<tr>
				<td>Product Name</td>
				<td><form:input path="prodname" /></td>
			</tr>
			<tr>
				<td>Category</td>
				<td><form:select path="catid">
						<form:option value="0" label="------Select----" />
						<form:options items="${catlist}" />
					</form:select>
				</td>
			</tr>
			<tr>
				<td>Supplier</td>
				<td><form:input path="suppid" /></td>
			</tr>
			<tr>
				<td>Price</td>
				<td><form:input path="price" /></td>
			</tr>
			<tr>
				<td>Stock</td>
				<td><form:input path="stock" /></td>
			</tr>
			<tr>
				<td>Product Desc</td>
				<td><form:textarea path="desc" /></td>
			</tr>
			<tr>
				<td>Product Image</td>
				<td><form:input type="file" path="pimage" /></td>
			</tr>
			<tr>
				<td colspan="2"><center>
						<input type="submit" />
					</center></td>
			</tr>

		</table>
	</form:form>

	<table align="center">
		<tr bgcolor="pink">
			<td>Product ID</td>
			<td>Product Name</td>
			<td>Category ID</td>
			<td>Supplier ID</td>
			<td>Price</td>
			<td>Stock</td>
			<td>Operation</td>
		</tr>

		<c:forEach items="${proddet}" var="prod">
			<tr bgcolor="cyan">
				<td>${prod.prodid}</td>
				<td>${prod.prodname}</td>
				<td>${prod.catid}</td>
				<td>${prod.suppid}</td>
				<td>${prod.price}</td>
				<td>${prod.stock}</td>
				<td><a href="<c:url value="deleteProduct/${prod.prodid}"/>">Delete</a>
					<a href="<c:url value="updateProduct/${prod.prodid}"/>">Update</a>
				</td>
			</tr>
		</c:forEach>

	</table>


</body>
</html>