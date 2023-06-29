<%@include file="header.jsp" %>

<div class="fillform">
<h1>Confirm Deletion</h1>
</div>
<a class="home" href="admin_rights">Home</a>

<br>
<form method="post" class="delete">
<% String flightdetail = request.getParameter("flightno");%>
<div class="fillform">
Do you want to delete the flight details of Flight Numbered as <b><%=flightdetail %></b></div>
<input type='hidden'  name='name'  value='<%=flightdetail %>'>
<br>
<input type="submit" value="Delete" class="button" name="Delete"></input>
</form>

<%@include file="footer.jsp" %>
