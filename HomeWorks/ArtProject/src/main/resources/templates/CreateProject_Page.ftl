<#ftl encoding='UTF-8'>
<!doctype html>
<head>
    <meta charset="UTF-8">
    <title>SignUp</title>
    <link rel="stylesheet" type="text/css" href="css/style.css"/>
</head>
<body>
<div class="form-style-6">
    <form action="createNewProject" method="post">
        <input type="text" name="projectName" placeholder="Title"/>
        <input type="text" name="projectDescription" placeholder="Description"/>
        <input type="text" name="releaseDate" placeholder="Release Date"/>
    <#--<input type="text" name="birthDate" placeholder="Birth Date YYYY-MM-DD"/>-->
        <#--<input type="text" name="participant" placeholder="Participants"/>-->
        <input type="submit" value="Create"/>
    </form>
</div>
</body>
</html>
