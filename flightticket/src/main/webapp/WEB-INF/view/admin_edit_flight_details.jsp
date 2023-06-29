<%@include file="header.jsp" %>

	<div class="addflight"><a href="admin_add_flight">ADD FLIGHT DETAILS </a></div>

<a class="home" href="admin_rights">Home</a>

<br>
<form:form modelAttribute="admin">
<div class="scrollable">
	<table class="searchdetail" >
		<thead>
			<tr>
				<th>Flight Number</th>
				<th>From</th>
				<th>To</th>
				<th>Departure Date</th>
				<th>Arrival Date</th>
				<th>Departure Time</th>
				<th>Arrival Time</th>
				<th>Economy Seats Available</th>
				<th>Business Seats Available</th>
				<th>Economy Seat Price</th>
				<th>Business Seat Price</th>
				<th>Flight Company</th>
				<th>Status</th>
				<th>Action1</th>
				<th>Action2</th>

			</tr>
		</thead>
		<tbody>
			<c:forEach items="${Flight_list}" var="list">
				<tr>

					<td>${list.flightno}</td>
					<td>${list.from}</td>
					<td>${list.to}</td>
					<td>${list.dept_date}</td>
					<td>${list.arr_date}</td>
					<td>${list.dept_time}</td>
					<td>${list.arr_time}</td>
					<td>${list.e_seats_left}</td>
					<td>${list.b_seats_left}</td>
					<td>${list.e_seat_price}</td>
					<td>${list.b_seat_price}</td>
					<td>${list.flight_company}</td>
					<td>${list.status}</td>
					<td><a href="edit_flight_details?flightno=${list.flightno}">Edit</a></td>
					<td><a href="delete_flight_details?flightno=${list.flightno}">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
</form:form>
<%@include file="footer.jsp" %>
