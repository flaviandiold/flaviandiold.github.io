<%@include file="header.jsp" %>

<a class="homerights" href="/logout">LogOut</a></div>

<% String message = request.getParameter("message");%>
<c:if test="${message!=null}">
<div class="message"><%=message%></div>
</c:if>

	<div class="bar"></div>
	<div class="description">
		<h1>
			SkyHub<br></h1><br>
		<h2>Your Gateway to the Sky!</h2>
			<ul>
					<li>As the Admin you can Add flight details, Edit flight details and <br>Delete flight details.</li>
					<li>You can select the status option as active or inactive for the flights <br>that are currently available or not.</li>
					<li>Only active flights will be shown to the user.</li>
					<li>You can also view all the bookings made by the customer.</li>
				</ul><br><br>
				<h2>Welcome Admin!</h2>
	</div>

<div class="anchors">
<div id="a1">
<a href="admin_edit_flight_details">Edit Flight Details</a>
</div>
<div id="a1">
<a href="admin_view_booking_details">View All Bookings</a>
</div>
</div>
<%@include file="footer.jsp" %>
