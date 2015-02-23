<%@page import="com.ph.sinonet.spring.model.entity.User"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>Login</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

  </head>
  
  <body>
  
	<form  name="f" action="<c:url value='j_spring_security_check'/>" method="POST">
  	<table>
  		<tr>
  			<td>Username : </td>
  			<td><input type='text' name='j_username' /></td>	
  		</tr>
  		<tr>
  			<td>Password : </td>
  			<td><input type='password' name='j_password'></td>
  		</tr>
  		<tr>
  			<td>Remember me : </td>
  			<td><input type="checkbox" name="_spring_security_remember_me" /></td>
  		</tr>
  		<tr>
  			<td></td>
  			<td><input type="submit" value="Submit" /></td>
  		</tr>
  	</table>
  	</form>
  	
  	
  </body>
</html>
