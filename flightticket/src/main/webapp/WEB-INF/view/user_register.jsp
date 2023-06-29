<%@include file="header.jsp"%>

<div class="fillform">
	<h1>Fill in your details to Register</h1>
	<a class="homeadmin" href="/">Home</a>
</div>

<div class="message">${message}</div>

<div class="message">${Update_success}</div>


<div class="reg">
	<form:form modelAttribute="user" method="post">
		<table class="table">
			<tr>
				<td>Name:</td>
				<td><form:input path="u_name" placeholder="Name" required="required"/></td>
			</tr>
			<tr>
				<td>Gender:</td>
				<td><form:select path="u_gender">
						<form:option value="Male" />
						<form:option value="Female" />
						<form:option value="Other" />
					</form:select></td>
			</tr>
			<tr>
				<td>Address:</td>
				<td><form:textarea path="u_address" rows="3" cols="20" placeholder="#363, Arcot Road, Kodambakkam, Chennai 600 024" required="required"/></td>
			</tr>
			<tr>
				<td>Email ID:</td>
				<td><form:input type="email" path="u_email_id" placeholder="user@mail.com" required="required"/></td>
			</tr>
			<tr>
				<td>Contact:</td>
				<td><form:input path="u_contact" pattern="[7-9]{1}[0-9]{9}" placeholder="9786451235" required="required"/></td> <!-- {Pattern} A phone number usually starts with 7 - 9, which makes up one of its digits, then the remaining 9 digits can take up any value from 0 to 9-->
			</tr>
			<tr>
				<td>Username:</td>
				<td><form:input path="u_username" required="required" /></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><form:password path="u_password" required="required"/></td>
			</tr>
			<tr>
				<td></td>
				<td><button type="submit" id="submit">Register</button></td>
			</tr>
		</table>
	</form:form>
</div>
<%@include file="footer.jsp"%>
