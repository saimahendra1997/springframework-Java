<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
    <title>Alien Added</title>
    <link rel="stylesheet" type="text/css" href="/css/alienstyle.css">
</head>
<body>
    <div class="container">
        <h1>Welcome to the Alien Family!</h1>
        <p>Welcome to the ${course} world</p>
        <p>Alien added successfully:</p>
        <p>${newAlien}</p>  <!-- Prints the Alien object's toString() -->
        <a href="/alien">Back to Alien Registry</a>
    </div>
</body>
</html>