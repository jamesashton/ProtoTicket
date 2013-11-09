<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">    
<html>
<head>
<title>Login</title>
</head>
<body>
<c:if test="${not empty param.login_error}">
 <font color="#ff0000">
 Login unsuccessful.<br/>
 <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}"/>.
 </font>
</c:if>
 <form action="j_spring_security_check" method="POST">
 <label for="username">User Name:</label>
 <input id="username" name="j_username" type="text" />
 <label for="password">Password:</label>
 <input id="password" name="j_password" type="password" />
 <input type="submit" value="Log In" />
 </form>
</body>
</html>


