<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
        <meta charset="utf-8">
        <title>authority login</title>
        <link rel="stylesheet" href="style.css">
</head>
<body>
 <div class="box">
        <h2> AUTHORITY LOGIN </h2>
        <form action="Authlogin" method="post">
            <div class="inputBox">
                <input type="text" name="username">
                <label>Username</label>
            </div>
            <div class="inputBox">
                    <input type="password" name="password">
                    <label>Password</label>
                </div>
                <input type="submit" value="Log in" >
               
                </form>
                 <h1><font color="white">${message}</font></h1> 
                </div>

</body>
</html>