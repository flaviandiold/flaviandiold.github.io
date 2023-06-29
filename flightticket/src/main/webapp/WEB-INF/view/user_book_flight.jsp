<%@include file="header.jsp" %>


<c:if test="${message!=null}">
<div class="message">${message}<a href="user_search_flight">here</a>
</div>
</c:if>

<div class="fillform">
<h1>Fill the details for booking</h1>
<a class="homeadmin" href="user_rights">Home</a>
</div>

<% String flightno = request.getParameter("flightno");%>
<% String pnrno = request.getParameter("pnr");%>
<% String from = request.getParameter("from");%>
<% String to = request.getParameter("to");%>
<% String dept_date = request.getParameter("dept_date");%>
<% String arr_date = request.getParameter("arr_date");%>
<% String dept_time = request.getParameter("dept_time");%>
<% String arr_time = request.getParameter("arr_time");%>
<% String status = request.getParameter("status");%>
<% String message ="Tickets booked successfully you can now check your bookings in manage bookings";%>

<form:form modelAttribute="flight" method="post" >
<table class="table" align="center">

<tr><td>Flight Number:</td>
<td><form:input path='p_fno'  value='<%=flightno %>' required="required"/></td>

<td>From:</td>
<td><form:input path='p_from'  value='<%=from %>' required="required"/></td>

<tr><td>To:</td>
<td><form:input path='p_to'  value='<%=to %>' required="required"/></td>

<td>Departure Date:</td>
<td><form:input path='p_dedate'  value='<%=dept_date %>' required="required"/></td></tr>

<tr><td>Arrival Date:</td>
<td><form:input path='p_ardate'  value='<%=arr_date %>' required="required"/></td>

<td>Departure Time:</td>
<td><form:input path='p_detime'  value='<%=dept_time %>' required="required"/></td></tr>

<tr><td>Arrival Time:</td>
<td><form:input path='p_artime'  value='<%=arr_time %>' required="required"/></td>

<td>Cost:</td>
<td><form:input type='double'  path="cost"  value='${cost}' /></td>

<form:hidden  path='p_status' value='<%=status %>'/>

<form:hidden path="pnr_no" value='<%=pnrno%>'/>
<tr>
<td>Passenger Name:</td>
<td><form:input path='p_name' required="required"/></td>

<td>Age:</td>
<td><form:input type="number" path='p_age' required="required"/></td></tr>

<tr>
<td>Gender:</td>
				<td><form:select path="p_sex">
				<form:option value="male"/> 
								<form:option value="female"/> 
								<form:option value="other"/>
								</form:select> 
				
					</td>

<td>Class:</td>
				<td><form:select path="p_class">
				<form:option value="Economy"/> 
								<form:option value="Business"/> 
								</form:select> 
				
					</td></tr>
					<tr>
<td>Email:</td>
<td><form:input type="email" path='p_email' required="required"/></td>
<td>PNR No: <lable><%=pnrno %></lable></td><td> Take note of the PNR No to view your bookings</td>
</tr>


				<tr>
                 <td></td>
                    <td><button  type="submit"  id="submit">Add Passenger</button></td>
                   <td><a href="confirm_payment?&pnr_no=<%=pnrno%>&cost=${cost}">Done</a></td>
                </tr>
                                   <tr><td></td><td>Press 'Done' if you have added all the passengers.</td></tr>
</table>
</form:form>

<%@include file="footer.jsp" %>
