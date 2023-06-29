<%@include file="header.jsp" %>

<div class="fillform"><h1>Edit Flight Details</h1>
<a class="home" href="admin_rights">Home</a></div>
<form:form name="flightdetailForm"  modelAttribute="flight" method="post">

<table class="table">
<tr>
<td>
<form:label path="flightno">Flight Number</form:label>
</td>

<td>
<form:input path="flightno" type="text" required="required"/>
<form:errors path="flightno" cssClass="text-warning" />
</td>

<td>
<form:label path="from">From</form:label>
</td>

<td>
<form:input path="from" type="text" required="required"/>
<form:errors path="from" cssClass="text-warning" />
</td>
</tr>

<tr>
<td>
<form:label path="to">To</form:label>
</td>

<td>
<form:input path="to" type="text" required="required"/>
<form:errors path="to" cssClass="text-warning" />
</td>


<td>
<form:label path="dept_date">Departure Date</form:label>
</td>

<td>
<form:input path="dept_date" type="date" required="required"/>
<form:errors path="dept_date" cssClass="text-warning" />
</td>
</tr>


<tr>
<td>
<form:label path="arr_date">Arrival Date</form:label>
</td>

<td>
<form:input path="arr_date" type="date" required="required"/>
<form:errors path="arr_date" cssClass="text-warning" />
</td>

<td>
<form:label path="dept_time">Departure Time</form:label>
</td>

<td>
<form:input path="dept_time" type="time" required="required"/>
<form:errors path="dept_time" cssClass="text-warning" />
</td>
</tr>

<tr>
<td>
<form:label path="arr_time">Arrival Time</form:label>
</td>

<td>
<form:input path="arr_time" type="time" required="required"/>
<form:errors path="arr_time" cssClass="text-warning" />
</td>

<td>
<form:label path="e_seats_left">Economy Class Seats</form:label>
</td>

<td>
<form:input path="e_seats_left" type="int" required="required"/>
<form:errors path="e_seats_left" cssClass="text-warning" />
</td>
</tr>
<tr>
<td>
<form:label path="b_seats_left">Business Class Seats</form:label>
</td>

<td>
<form:input path="b_seats_left" type="int" required="required"/>
<form:errors path="b_seats_left" cssClass="text-warning" />
</td>

<td>
<form:label path="e_seat_price">Price of Economy Class Seat</form:label>
</td>

<td>
<form:input path="e_seat_price" type="int" required="required"/>
<form:errors path="e_seat_price" cssClass="text-warning" />
</td>
</tr>


<tr>
<td>
<form:label path="b_seat_price">Price of Business Class Seat</form:label>
</td>

<td>
<form:input path="b_seat_price" type="int" required="required"/>
<form:errors path="b_seat_price" cssClass="text-warning" />
</td>

<td>
<form:label path="flight_company">Company of Flight</form:label>
</td>

<td>
<form:input path="flight_company" type="text" required="required"/>
<form:errors path="flight_company" cssClass="text-warning" />
</td>
</tr>
<tr>
<td><form:label path="status">Status</form:label></td>

<td><form:radiobutton path="status" value="active"/>Active
<form:radiobutton path="status" value="inactive"/>Inactive
<form:errors path="status" cssClass="text-warning" /></td>
<tr>
<td>
<input type="submit" value="Save" class="button" name="save"></input>
</td>
</tr>
</table>

</form:form>

<%@include file="footer.jsp" %>
