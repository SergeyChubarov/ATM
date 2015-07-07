<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>ATM</title>
    <script type="text/javascript" src="<spring:url value="/js/jquery-2.1.4.js"/>"></script>
    <script type="text/javascript" src="<spring:url value="/js/bootstrap.js"/>"></script>
    <script type="text/javascript" src="<spring:url value="/js/app.js"/>"></script>
    <script type="text/javascript" src="<spring:url value="/js/jquery.blockUI.js"/>"></script>
    <link type="text/css" href="<spring:url value="/css/bootstrap.css"/>" rel="stylesheet"/>
    <link type="text/css" href="<spring:url value="/css/app.css"/>" rel="stylesheet"/>
</head>
<body>
    <div>
        <div>
            <div id="card-number-block">
                <label for="card-number">Card number</label>
                <input type="text" id="card-number">
                <button class="btn btn-default submit-card">OK</button>
            </div>
            <div id="pin-number-block">
                <label for="pin-number">Pin number</label>
                <input type="text" id="pin-number">
                <button class="btn btn-default submit-pin">OK</button>
            </div>
            <button class="btn btn-default clear">Clear</button>
        </div>
        <div>
            <div class="numbers">
                <button class="btn btn-default number-btn">1</button>
                <button class="btn btn-default number-btn">2</button>
                <button class="btn btn-default number-btn">3</button>
                <button class="btn btn-default number-btn">4</button>
                <button class="btn btn-default number-btn">5</button>
                <button class="btn btn-default number-btn">6</button>
                <button class="btn btn-default number-btn">7</button>
                <button class="btn btn-default number-btn">8</button>
                <button class="btn btn-default number-btn">9</button>
                <button class="btn btn-default number-btn">0</button>
            </div>
        </div>
    </div>
</body>
</html>
