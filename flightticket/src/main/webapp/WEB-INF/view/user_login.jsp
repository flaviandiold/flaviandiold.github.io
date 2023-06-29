<%@include file="header.jsp"%>

<div class="message">${message}</div>

<div class="fillform">
	<h1>Login</h1>
	<a class="homeadmin" href="/">Home</a>
</div>

<div class="reg">
	<form:form method="post" modelAttribute="user">
		<table class="table">
			<tr>
				<td>Username:</td>
				<td><form:input path="u_username" /></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><form:password path="u_password" /></td>
			</tr>
			<tr>
				<td></td>
				<td><button type="submit" id="submit">Login</button></td>
			</tr>
			<tr>
			<td></td>
			</tr>
		</table>
	</form:form>
</div>

<%@include file="footer.jsp"%>
