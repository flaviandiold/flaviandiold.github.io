<%@include file="header.jsp"%>

<div class="fillform">
	<h2>Search Available Flights For Direction</h2>
	<a class="home" href="user_rights">Home</a>
</div>


<form method="post">
	<table class="search">
		<th><label for="from">From</label></th>
		<th><label for="to">To</label></th>
		<th><label for="departure">Departure date</label></th>
		<tr>
			<td><input name="from" type="text" id="from" required=""></td>
			<td><input name="to" type="text" id="to" required=""></td>
			<td><input name="dept_date" type="date" id="dept_date"
				required=""></td>
			<td>
				<button type="submit" id="submit">Search Flights</button>
			</td>
		</tr>
</form>

		<form method="post">
			<c:if test="${FlightNumber!=null}">

				<table class="searchdetail" align="center">
					<thead>
						<tr>
							<th>${FlightNumber}</th>
							<th>${From}</th>
							<th>${To}</th>
							<th>${DepartureDate}</th>
							<th>${ArrivalDate}</th>
							<th>${DepartureTime}</th>
							<th>${ArrivalTime}</th>
							<th>${EconomySeatsAvailable}</th>
							<th>${BusinessSeatsAvailable}</th>
							<th>${EconomySeatPrice}</th>
							<th>${BusinessSeatPrice}</th>
							<th>${FlightCompany}</th>
							<th>${Action}</th>
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
								<td><a
									href="user_book_flight?status=${list.status}&flightno=${list.flightno}&from=${list.from}&to=${list.to}&dept_date=${list.dept_date}&arr_date=${list.arr_date}&dept_time=${list.dept_time}&arr_time=${list.arr_time}&travellers=${travellers}&pnr=${pnr}">BOOK</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:if>
		</form>

<%@include file="footer.jsp"%>