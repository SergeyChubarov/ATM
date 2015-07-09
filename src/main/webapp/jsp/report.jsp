<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>ATM</title>
  <script type="text/javascript" src="<spring:url value="/js/jquery/jquery-2.1.4.js"/>"></script>
  <script type="text/javascript" src="<spring:url value="/js/bootstrap/bootstrap.js"/>"></script>
  <link type="text/css" href="<spring:url value="/css/bootstrap/bootstrap.css"/>" rel="stylesheet"/>
  <link type="text/css" href="<spring:url value="/css/app.css"/>" rel="stylesheet"/>
</head>
<body class="operations-content">
<jsp:include page="header.jsp"/>
<div class="container" style="min-height: 800px">
  <table class="table balance-info">
    <thead>
    <tr>
      <th>Card number</th>
      <th>Today date</th>
      <th>Balance</th>
      <th>Withdrawal Amount</th>
    </tr>
    </thead>
    <tbody>
    <tr class="success">
      <td>${cardNumber}</td>
      <%java.text.DateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm"); %>
      <td><%= df.format(new java.util.Date()) %></td>
      <td>${balance}</td>
      <td style="text-align: center">${withdrawalAmount}</td>
    </tr>
    </tbody>
  </table>
  <div class="report-back-btn">
    <a href='/withdrawal?cardNumber=${cardNumber}' class="btn btn-primary withdrawal">Back</a>
  </div>
</div>
</body>
</html>
