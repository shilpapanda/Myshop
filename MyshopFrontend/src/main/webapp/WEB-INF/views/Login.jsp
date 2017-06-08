<%@ page language="java" contentType="text/html"%>
<%@include file="GeneralHeader.jsp" %>

<table cellspacing="2" cellpadding="2" align="center">

	<form action="perform_login" method="post">
	<tr><td colspan="2">Login Credential</td></tr>
	<tr>
		<td>User Name</td>
		<td><input type="text" name="username"/></td>
	</tr>
	<tr>
		<td>Password</td>
		<td><input type="password" name="password"/></td>
	</tr>
	<tr>
		<td colspan="2"><input type="submit" value="SUBMIT"/></td>
	</tr>
	</form>

</table>



<%@include file="GeneralFooter.jsp" %>
