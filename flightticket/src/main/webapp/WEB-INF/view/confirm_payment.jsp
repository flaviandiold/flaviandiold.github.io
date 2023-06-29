<%@include file="header.jsp" %>

 <div class="message">${message}

</div>

	<form method="post">
		<div class="fillform">
		
			<h1>Proceed to pay ${cost } Rs. <button  type="submit"  id="submit">Proceed</button> </h1>
            <a class="homeadmin" href="user_rights">Home</a>
           </div>
	</form>

	<form>
		<table class="searchdetail" align="center">
			<thead>
				<tr>
					<th>Passenger Name</th>
					<th>Flight No</th>
					<th>From</th>
					<th>To</th>
					<th>Departure Date</th>
					<th>Arrival Date</th>
					<th>Departure Time</th>
					<th>Arrival Time</th>
					<th>Class</th>
					<th>Seat Number</th>
			</thead>
			<tbody>
				<c:forEach items="${Booking_list}" var="list">




					<tr>
					<c:set var="B" value="booked"/>
					<c:if test="${list.p_status eq B}">
						<td>${list.p_name}</td>
						<td>${list.p_fno}</td>
						<td>${list.p_from}</td>
						<td>${list.p_to}</td>
						<td>${list.p_dedate}</td>
						<td>${list.p_ardate}</td>
						<td>${list.p_detime}</td>
						<td>${list.p_artime}</td>
						<td>${list.p_class}</td>
						<td>${list.p_seatno}</td>
						
						</c:if>
                 <tr>
				</c:forEach>

			</tbody>
		</table>
	</form>
<%@include file="footer.jsp" %>
