<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>ATM</title>
    <script type="text/javascript" src="<spring:url value="/js/jquery/jquery-2.1.4.js"/>"></script>
    <script type="text/javascript" src="<spring:url value="/js/jquery/jquery.blockUI.js"/>"></script>
    <script type="text/javascript" src="<spring:url value="/js/jquery/inputmask.js"/>"></script>
    <script type="text/javascript" src="<spring:url value="/js/jquery/jquery.inputmask.js"/>"></script>
    <script type="text/javascript" src="<spring:url value="/js/bootstrap/bootstrap.js"/>"></script>
    <script type="text/javascript" src="<spring:url value="/js/app.js"/>"></script>
    <link type="text/css" href="<spring:url value="/css/bootstrap/bootstrap.css"/>" rel="stylesheet"/>
    <link type="text/css" href="<spring:url value="/css/app.css"/>" rel="stylesheet"/>
</head>
<body class="operations-content">
    <jsp:include page="header.jsp"/>
    <div class="container">
    </div>
</body>
</html>
