<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign Up</title>
    <div class="form-style-6">
        <h1>New User</h1>
        <form action="/users" method="post">
            <input type="text" name="firstName" placeholder="Your Name" />
            <input type="text" name="lastName" placeholder="Your Last Name" />
            <input type="text" name="email" placeholder="Email Address" />
            <input type="text" name="address" placeholder="Your address" />
            <input type="text" name="login" placeholder="Your login" />
            <input type="text" name="hashpassword" placeholder="Your password" />
            <input type="submit" value="Sign Up" />
        </form>
    </div>
    <link rel="stylesheet" type="text/css" href="/CSS/style.css">
</head>
<body>
</body>
</html>
