<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>ATM</title>
    <script type="text/javascript" src="<spring:url value="/js/jquery/jquery-2.1.4.js"/>"></script>
    <script type="text/javascript" src="<spring:url value="/js/jquery/inputmask.js"/>"></script>
    <script type="text/javascript" src="<spring:url value="/js/jquery/jquery.inputmask.js"/>"></script>
    <script type="text/javascript" src="<spring:url value="/js/bootstrap/bootstrap.js"/>"></script>
    <script type="text/javascript" src="<spring:url value="/js/operations.js"/>"></script>
    <link type="text/css" href="<spring:url value="/css/bootstrap/bootstrap.css"/>" rel="stylesheet"/>
    <link type="text/css" href="<spring:url value="/css/app.css"/>" rel="stylesheet"/>
</head>
<body class="operations-content">
    <jsp:include page="header.jsp"/>
    <div class="container" style="min-height: 800px">
        <div id="card-data-content" style="margin-left: 220px">
            <div class="form-inline" id="card-number-block">
                <h3 style="width: 400px;"><label for="card-number-holder">Operations for card</label></h3>
                <input type="text" id="card-number-holder" class="form-control card-data-input" readonly value='${cardNumber}'>
                <div class="form-horizontal card-main-btns" style="left: 250px;">
                    <button class="btn btn-primary withdrawal">Withdrawal</button>
                    <a href='/balance?cardNumber=${cardNumber}&operationCode="Balance"' class="btn btn-primary balance">Balance</a>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
