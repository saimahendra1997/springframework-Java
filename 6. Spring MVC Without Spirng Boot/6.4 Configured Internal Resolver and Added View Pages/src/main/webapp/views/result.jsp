<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
    <title>Calculation Result</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
    <div class="container">
        <h1>Calculation Result</h1>
        <%
            String error = (String) request.getAttribute("error");
            if (error != null) {
        %>
            <p style="color: red;"><%= error %></p>
        <%
            } else {
                Object num1 = request.getAttribute("num1");
                Object num2 = request.getAttribute("num2");
                Object operation = request.getAttribute("operation");
                Object result = request.getAttribute("result");
        %>
            <p><%= num1 %> <%= operation %> <%= num2 %> = <%= result %></p>
        <%
            }
        %>
        <a href="/">Back to Calculator</a>
    </div>
</body>
</html>