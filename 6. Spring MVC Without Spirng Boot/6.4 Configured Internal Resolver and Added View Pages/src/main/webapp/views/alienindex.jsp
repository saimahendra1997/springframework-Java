<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Add Alien</title>
    <link rel="stylesheet" type="text/css" href="/css/alienstyle.css">
</head>
<body>
    <div class="container">
        <h1>Welcome to the Alien Registry!</h1>
        <p>Enter the alien's ID and name to add a new entry.</p>

        <form action="addAlien" method="post">
            <label for="aid">Alien ID:</label>
            <input type="number" id="aid" name="aid" required><br><br>

            <label for="aname">Alien Name:</label>
            <input type="text" id="aname" name="aname" required><br><br>

            <button type="submit">Add Alien</button>
        </form>

        <p>Current date and time: <%= new java.util.Date() %></p>
    </div>
</body>
</html>