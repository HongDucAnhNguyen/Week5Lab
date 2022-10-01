<%-- 
    Document   : login
    Created on : 30-Sep-2022, 7:02:16 PM
    Author     : nguye
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <h1>Hello from login!</h1>
        <form method="POST" action="login" >
            <label>Username: </label>
            <input type="text"  name="username"value="${username}">
            <br>
            <label>Password: </label>
            <input type="password"  name="password" value="${password}">
            <br>
            <input type="submit" value="Login">
        </form>
        <p>${message}</p>
    </body>

</html>
