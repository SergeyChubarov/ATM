<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>ATM</title>
    <script type="text/javascript" src="<spring:url value="/js/jquery/jquery-2.1.4.js"/>"></script>
    <script type="text/javascript" src="<spring:url value="/js/jquery/inputmask.js"/>"></script>
    <script type="text/javascript" src="<spring:url value="/js/jquery/jquery.inputmask.js"/>"></script>
    <script type="text/javascript" src="<spring:url value="/js/bootstrap/bootstrap.js"/>"></script>
    <script type="text/javascript" src="<spring:url value="/js/withdrawal.js"/>"></script>
    <link type="text/css" href="<spring:url value="/css/bootstrap/bootstrap.css"/>" rel="stylesheet"/>
    <link type="text/css" href="<spring:url value="/css/app.css"/>" rel="stylesheet"/>
    <jsp:include page="alert-template.jsp"/>
</head>
<body class="content">
<jsp:include page="header.jsp"/>
<div class="container" style="min-height: 800px">
    <div id="card-data-content" style="margin-bottom: 6px">
        <h3 style="width: 400px;"><label for="card-number-holder">Card number</label></h3>
        <input type="text" id="card-number-holder" class="form-control card-data-input" readonly value='${cardNumber}' style="margin-right: 10px">
        <div class="form-inline">
            <h3 style="width: 500px;"><label for="withdrawal-amount">Withdrawal amount</label></h3>
            <input type="text" id="withdrawal-amount" class="form-control withdrawal-amount-input" style="width: 70px;" readonly>
            <div class="form-horizontal withdrawal-btns">
                <button class="btn btn-primary submit-withdraw">OK</button>
                <button class="btn btn-default clear-withdrawal-amount">Clear</button>
            </div>
        </div>
    </div>

    <jsp:include page="numbers.jsp"/>
</div>
</body>
</html>
