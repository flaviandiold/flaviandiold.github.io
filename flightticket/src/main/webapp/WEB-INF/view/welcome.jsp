<%@include file="header.jsp"%>
<c:if test="${message!=null}">
<div class="message">${message}</div>
</c:if>
<div class="bar"></div>

<div class="description">
	<h1>
		SkyHub <br>
	</h1>
		Your Gateway to the Sky!<br>

	<p>
		SkyHub allows you to book airtickets from anywhere and anytime.<br>
		If you are a new user first create your account by registering
		yourself.<br>Once registered, you can simply login and book an
		airticket.
	</p>
	<br> <br> <br>
	<h2>Have a Great Day!</h2>
</div>

<div class="anchors">
	<div id=home>
		<a href="user_register">New to SkyHub? Click Here to Register.</a>
	</div>
	<br>
	<div id=a2>
		<a href="user_login">User Login.</a>
	</div>
	<div id="a3">
		<a href="admin_login">Admin Login</a>
	</div>
</div>

<%@include file="footer.jsp"%>

