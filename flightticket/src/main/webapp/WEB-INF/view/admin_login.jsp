<%@include file="header.jsp" %>
 <div class="message">${message}</div>
                 
        <div class="fillform"><h1>Login</h1><a class="homeadmin" href="/">Home</a></div> 
  
 <div class="reg">        
<form:form modelAttribute="admin" method="post">		
		<table class="table">
		<tr>
                    <td>Username:</td>
                    <td><form:input path="username" required="required"/></td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td><form:password path="password" required="required"/></td>
                </tr>
				<tr>
                    <td></td>
                    <td><button  type="submit"  id="submit">Login</button></td>
                </tr>
		</table>
		</div>
</form:form>   
<%@include file="footer.jsp" %>
