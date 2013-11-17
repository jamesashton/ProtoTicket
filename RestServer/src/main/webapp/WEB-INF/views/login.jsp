<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
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
    <link rel="stylesheet" href="<c:url value="/resources/login/css/senchatouch2_3_0.css" />" rel="stylesheet" type="text/css"  id="loginPageCss" />
    <script type="text/javascript" src="<c:url value="/resources/login/app.js" />"></script>
</head>
<body>
</body>
</html>