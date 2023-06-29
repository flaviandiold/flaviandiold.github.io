<%@include file="header.jsp"%>

<a class="homerights" href="/finish">LogOut</a>

<div class="message">${Update_success}</div>

<%
	String message = request.getParameter("message");
%>

<c:if test="message!=null}">
	<div class="message"><%=message%></div>
</c:if>

<div class="bar"></div>
<div class="description">
	<h1>
		SkyHub<br>
	</h1>
	Your Gateway to the Sky!<br>

	<ul>
		<li>You can search for flights between the directions and book a Ticket.</li><li> 'Manage bookings' allows you to check your
		present and past bookings and also you can cancel bookings here.</li>
		<li> You can edit your personal details using the 'Edit Details'
		option</li>
		</ul>
	
	<br> <br> 
	<h2>Have a Great Day!</h2>
</div>

<div class="anchors">
	<div id="user">
		<a href="user_search_flight">Flight Search and Booking</a>
	</div>
	<br>
	<div id="a4">
		<a href="user_bookings">Manage Bookings</a>
	</div>
	<br>
	<div id="a3">
		<a href="show_user_details">Edit Details</a>
	</div>
</div>

<%@include file="footer.jsp"%>
