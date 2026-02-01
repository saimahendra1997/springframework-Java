<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Simple JSP Calculator</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
    <div class="container">
    <h1>Welcome to My Simple JSP Calculator!</h1>
    <p>Enter two numbers and select an operation to calculate.</p>

    <form action="calculate" method="post">
        <label for="num1">Enter first number:</label>
        <input type="number" id="num1" name="num1" required><br><br>

        <label for="num2">Enter second number:</label>
        <input type="number" id="num2" name="num2" required><br><br>

        <label for="operation">Select operation:</label>
        <select id="operation" name="operation" required>
            <option value="add">Addition (+)</option>
            <option value="subtract">Subtraction (-)</option>
            <option value="multiply">Multiplication (*)</option>
            <option value="divide">Division (/)</option>
        </select><br><br>

        <button type="submit">Calculate</button>
    </form>

    <p>Current date and time: <%= new java.util.Date() %></p>
    </div>
</body>
</html>