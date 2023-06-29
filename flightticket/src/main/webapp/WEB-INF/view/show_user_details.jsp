<%@include file="header.jsp" %>


<div class="fillform"><h1>Update Your Details</h1>
<a class="home" href="user_rights">Home</a>
</div>
<form method="post">
		<table class="table">
			<tr>
				<td><label for="name">Name</label></td>
				<td><input type="text" id="name" name="name" value="${name}" }></td>
			</tr>
			<tr>
				<td>Gender</td>
				<td><input type="radio" id="male" name="gender" value="male">
					<label for="male">Male</label>
					 <input type="radio"
					id="female" name="gender" value="female"> 
					<label for="female">Female</label>
					<input type="radio" id="other"
					name="gender" value="other"> <label for="other">Other</label></td>
			</tr>
			<tr>
				<td><label for="address">Address</label></td>
				<td><textarea name="address"  id="address"
						rows="4" cols="30">${address}</textarea></td>
			</tr>
			<tr>
				<td><label for="mailid">Email-Id</label></td>
				<td><input type="email" value="${email}" id="email_id" name="email_id"></td>
			</tr>
			<tr>
				<td><label for="contact">Contact</label></td>
				<td><input type="text" id="contact" name="contact" value="${contact}"
					pattern="[7-9]{1}[0-9]{9}"></td>
			</tr>
			<tr>
				
				<td><input type="hidden"  id="username" value="${username}" name="username"></td>
				<td><input type="hidden"  id="password" value="${password}" name="password"></td>
				
			</tr>
		
			<tr>
				<td></td>
				<td><button type="submit" id="submit">Save</button></td>
			</tr>
		</table>

	</form>


<%@include file="footer.jsp" %>
