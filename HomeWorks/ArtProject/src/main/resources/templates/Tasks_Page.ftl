<#ftl encoding='UTF-8'>
<!doctype html>
<head>
    <meta charset="UTF-8">
    <title>Tasks</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css"/>
    <script
            src="https://code.jquery.com/jquery-3.3.1.min.js"
            integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
            crossorigin="anonymous"></script>
    <script>
        function changeStatus(id, status_element) {
            $.ajax({
                type: "POST",
                url: "/tasks/" + id + "?action=change_status",
                success: function (response) {
                    status_element.innerHTML = response["state"];
                }
            });
        }
    </script>
</head>
<body>
<h1>Добро пожаловать, ${user.name}</h1>
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
            <th>
                Статус
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
                <td>
                    <p id="state_p" onclick="
                    changeStatus(document.getElementById('task_id').innerHTML, this)">${task.state}</p>
                </td>
            </tr>
        </#list>
    </table>
</div>
<div class="form-style-6">
    <form action="/tasks" method="post">
        <input type="text" name="name" placeholder="Task name" />
        <input type="text" name="description" placeholder="Task description" />
        <input type="date" name="deadline" />
        <input type="submit" value="Add Task"/>
    </form>
</div>
</body>
</html>