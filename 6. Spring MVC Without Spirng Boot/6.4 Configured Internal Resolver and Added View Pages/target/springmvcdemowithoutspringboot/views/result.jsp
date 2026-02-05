<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>  <!-- Updated URI for Jakarta JSTL -->
<!DOCTYPE html>
<html>
<head>
    <title>Calculation Result</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
    <div class="container">
        <h1>Calculation Result</h1>
        <%--
        // Scriptlet version (commented out)
        <% if (session.getAttribute("error") != null) { %>
            <p style="color: red;"><%= session.getAttribute("error") %></p>
        <% } else { %>
            <p><%= session.getAttribute("num1") %> <%= session.getAttribute("operation") %> <%= session.getAttribute("num2") %> = <%= session.getAttribute("result") %></p>
        <% } %>
        --%>

        <!-- JSTL version (active) -->
        <c:if test="${not empty error}">
            <p style="color: red;"><c:out value="${error}" /></p>
        </c:if>
        <c:if test="${empty error}">
            <p><c:out value="${num1}" /> <c:out value="${operation}" /> <c:out value="${num2}" /> = <c:out value="${result}" /></p>
        </c:if>
        <a href="/">Back to Calculator</a>
    </div>
</body>
</html>