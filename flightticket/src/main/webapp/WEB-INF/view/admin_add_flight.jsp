<%@include file="header.jsp"%>

<div class="Home"></div>

<div class="fillform">
	<h1>Add Flight Details</h1>
	<a class="home" href="admin_rights">Home</a>
</div>

<form method="post">
	<table class="addflighttable">
		<tr>
			<td><label for="flightno">Flight Number</label></td>
			<td><input type="text" id="flightno" name="flightno"
				autocomplete="off" required="required"></td>



			<td><label for="from">From</label></td>
			<td><input type="text" autocomplete="off" id="from" name="from"
				required="required"></td>
		</tr>

		<tr>
			<td><label for="to">To</label></td>
			<td><input type="text" autocomplete="off" id="to" name="to"
				required="required"></td>

			<td><label for="dept_date">Departure Date</label></td>
			<td><input type="date" autocomplete="off" id="dept_date"
				name="dept_date" required="required"></td>
		</tr>
		<tr>
			<td><label for="arr_date">Arrival Date</label></td>
			<td><input type="date" autocomplete="off" id="arr_date"
				name="arr_date" required="required"></td>

			<td><label for="dept_time">Departure Time</label></td>
			<td><input type="time" autocomplete="off" id="dept_time"
				name="dept_time" required="required"></td>
		</tr>
		<tr>
			<td><label for="arr_time">Arrival Time</label></td>
			<td><input type="time" autocomplete="off" id="arr_time"
				name="arr_time" required="required"></td>

			<td>Status</td>
			<td><input type="radio" id="active" name="status" value="active"
				required="required"> <label for="active">Active</label> <input
				type="radio" id="inactive" name="status" value="inactive"> <label
				for="inactive">Inactive</label></td>

		</tr>



		<tr>
			<td><label for="b_seats_left">Business Class Seats</label></td>
			<td><input type="number" autocomplete="off" id="b_seats_left"
				name="b_seats_left" required="required"></td>

			<td><label for="e_seats_left">Economy Class Seats</label></td>
			<td><input type="number" autocomplete="off" id="e_seats_left"
				name="e_seats_left" required="required"></td>
		</tr>

		<tr>
			<td><label for="b_seat_price">Price of Business Class
					Seat</label></td>
			<td><input type="number" autocomplete="off" id="b_seat_price"
				name="b_seat_price" required="required"></td>

			<td><label for="e_seat_price">Price of Economy Class
					Seat</label></td>
			<td><input type="number" autocomplete="off" id="e_seat_price"
				name="e_seat_price" required="required"></td>
		</tr>
		<tr>

			<td><label for="flight_company">Company of Flight</label></td>
			<td><input type="text" autocomplete="off" id="flight_company"
				name="flight_company" required="required"></td>
			<td></td>

			<td><button type="submit" id="submit">Add Flight</button></td>
		</tr>
	</table>
</form>

	<%@include file="footer.jsp"%>


	</body>
	</html>