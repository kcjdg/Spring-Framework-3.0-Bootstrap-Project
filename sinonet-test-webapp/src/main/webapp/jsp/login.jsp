<%@page import="com.ph.sinonet.spring.model.entity.User"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE HTML>
<html>
  <head>
    <title>Login</title>
    <meta charset="utf-8">
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
  			<td><spring:message code="label.username" /> : </td>
  			<td><input type='text' name='j_username' /></td>	
  		</tr>
  		<tr>
  			<td><spring:message code="label.password" />: </td>
  			<td><input type='password' name='j_password'></td>
  		</tr>
  		<tr>
  			<td><spring:message code="label.rememberMe" />: </td>
  			<td><input type="checkbox" name="_spring_security_remember_me" /></td>
  		</tr>
  		<tr>
  			<td></td>
  			<spring:message code="label.submit"  var="labelSubmit"/>
  			<td><input type="submit" value="${labelSubmit}" /></td>
  		</tr>
  	</table>
  	</form>
  	
  	
  </body>
</html>
