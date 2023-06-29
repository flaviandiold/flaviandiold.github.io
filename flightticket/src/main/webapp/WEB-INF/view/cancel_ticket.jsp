<%@include file="header.jsp" %>



<div class="fillform"><h1>Confirm Cancellation</h1>
<a class="home" href="user_rights">Home</a>
</div>


<form method="post">
<% String pa_name = request.getParameter("p_name");%>
<% String p_class = request.getParameter("p_class");%>
<% String flightno = request.getParameter("flightno");%>

<br>
<div class="fillform">
Do you want to cancel the ticket booked for the passenger <%=pa_name %>


<% String pnr = request.getParameter("pnr");%>
<input type='hidden'  name='pnr_no'  value='<%=pnr%>'>
<input type='hidden'  name='pa_class'  value='<%=p_class%>'>
<input type='hidden'  name='pa_flightno'  value='<%=flightno%>'>

<input type="submit" value="Cancel" class="button" name="Cancel"></input></div>

</form>
<%@include file="footer.jsp" %>
