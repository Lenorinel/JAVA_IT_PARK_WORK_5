<#ftl encoding='UTF-8'>
<!doctype html>
<head>
    <meta charset="UTF-8">
    <title>SignUp</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css"/>
</head>
<body>
<div class="form-style-6">
    <form action="signUp" method="post">
        <input type="text" name="login" placeholder="Login"/>
        <input type="text" name="name" placeholder="Name"/>
        <input type="text" name="city" placeholder="City"/>
        <#--<input type="text" name="birthDate" placeholder="Birth Date YYYY-MM-DD"/>-->
        <input type="text" name="role" placeholder="Role"/>
        <input type="password" name="password" placeholder="Password"/>
        <input type="submit" value="SignUp"/>
    </form>
</div>
</body>
</html>