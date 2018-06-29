<#ftl encoding='UTF-8'>
<!doctype html>
<head>
    <meta charset="UTF-8">
    <title>Profile</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css"/>
</head>
<body>
<h1> Добро пожаловать ${user.name}</h1>
<table align="right">

    <#list users as user>
        <tr>
            <td>${user.name}</td>
            <td>${user.country}</td>
            <td>${user.age}</td>
            <td>${user.role}</td>
        </tr>
    </#list>
</table>
<div class="names">
    <table>
        <tr>
            <th>
                ID
            </th>
            <th>
                Название
            </th>
            <th>
                Краткое описание
            </th>
            <th>
                Дедлайн
            </th>
        </tr>
        <#list tasks as task>
            <tr>
                <td>
                    <p id="task_id">${task.id}</p>
                </td>
                <td>
                    ${task.name}
                </td>
                <td>
                    ${task.discription}
                </td>
                <td>
                    ${task.deadLine}
                </td>
            </tr>
        </#list>
    </table>
</div>
</body>