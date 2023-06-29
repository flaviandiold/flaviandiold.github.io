<%@include file="header.jsp"%>

<div class="fillform">
	<a class="homerights" href="user_rights">Home</a>
</div>

<form method="post">
	<table>
		<tr>
			<td><label for="pnr">Enter the PNR</label></td>
			<td><input name="pnr" type="text" id="pnr" required=""></td>
		</tr>
		<tr><td></td>
		<td><button type="submit" id="submit">Show Bookings</button></td>
		</tr>
	</table>
</form>

<form>
	<c:if test="${PassengerName!=null}">

		<div class="scrollable">
			<table class="searchdetail" align="center">
				<thead>
					<tr>
						<th>${PassengerName}</th>
						<th>${FlightNo}</th>
						<th>${From}</th>
						<th>${To}</th>
						<th>${DepartureDate}</th>
						<th>${ArrivalDate}</th>
						<th>${DepartureTime}</th>
						<th>${ArrivalTime}</th>
						<th>${Class}</th>
						<th>${SeatNumber}</th>
						<th>Action</th>
				</thead>
				<tbody>
					<c:forEach items="${Booking_list}" var="list">

						<tr>
							<c:set var="B" value="booked" />
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
								<td><c:if
										test="${list.p_bookingdate.before(list.p_dedate)}">
										<a
											href="cancel_ticket?p_name=${list.p_name}&pnr=${pnr}&p_class=${list.p_class}&flightno=${list.p_fno}">Cancel</a>
									</c:if></td>
							</c:if>
						<tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
</form>
</c:if>

<%@include file="footer.jsp"%>
