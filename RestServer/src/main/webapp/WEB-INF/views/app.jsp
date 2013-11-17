<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>

<!-- Auto Generated with Sencha Architect -->
<!-- Modifications to this file will be overwritten. -->
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>ProtoTicket</title>
    <script>
        var Ext = Ext || {};
        Ext.theme = {
            name: "Default"
        };
    </script>
    <script type="text/javascript">
		var defLoginUrl = '${ctx}/j_spring_security_check';
		var homeUrl = '${ctx}';
	</script>	
    
    <script src="http://cdn.sencha.com/touch/sencha-touch-2.3.0/sencha-touch-all.js"></script>
    <link rel="stylesheet" href="http://cdn.sencha.com/touch/sencha-touch-2.3.0/resources/css/sencha-touch.css">
    <link rel="stylesheet" href="<c:url value="/resources/app/css/senchatouch2_3_0.css" />" id="loginPageCss">
    <script type="text/javascript" src="<c:url value="/resources/app/app.js" />"></script>
</head>
<body>
<!--
<P>  The time on the server is ${serverTime}. </P>
-->

<!-- 
<a href="<c:url value="/j_spring_security_logout"/>">Logout</a>
-->
</body>
</html>