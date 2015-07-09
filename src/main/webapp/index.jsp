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
    <script type="text/javascript" src="<spring:url value="/js/app.js"/>"></script>
    <link type="text/css" href="<spring:url value="/css/bootstrap/bootstrap.css"/>" rel="stylesheet"/>
    <link type="text/css" href="<spring:url value="/css/app.css"/>" rel="stylesheet"/>
    <jsp:include page="jsp/alert-template.jsp"/>
</head>
<body class="content">
    <jsp:include page="jsp/header.jsp"/>
    <div class="container" style="min-height: 800px">
        <div id="card-data-content">
            <div class="form-inline" id="card-number-block">
                <h3 style="width: 155px;"><label for="card-number">Card number</label></h3>
                <input type="text" id="card-number" class="form-control card-data-input" placeholder="CARD NUMBER" readonly>
                <div class="form-horizontal card-main-btns" style="left: 115px;">
                    <button class="btn btn-primary submit-card">OK</button>
                    <button class="btn btn-default clear-card-number">Clear</button>
                </div>
            </div>
            <div class="form-inline" id="pin-number-block">
                <h3 style="width: 155px;"><label for="pin-number">Pin number</label></h3>
                <input type="password" id="pin-number" class="form-control card-data-input" placeholder="PIN" readonly>
                <div class="form-horizontal card-main-btns">
                    <button class="btn btn-primary submit-pin">OK</button>
                    <button class="btn btn-default clear-pin-number">Clear</button>
                </div>
            </div>
        </div>

        <jsp:include page="jsp/numbers.jsp"/>
    </div>
</body>
</html>
