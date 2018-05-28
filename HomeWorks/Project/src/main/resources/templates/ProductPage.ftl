<#ftl encoding='UTF-8'>
<!doctype html>
<head>
    <meta charset="UTF-8">
    <title>Users</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css"/>
</head>
<body>
<div class="names">
    <table>
        <tr>
            <th>
                Список продуктов:
            </th>
        </tr>
        <#list products as product>
            <tr>
                <td>
                    ${product}
                </td>
            </tr>
        </#list>
    </table>
</div>
<div class="form-style-6">
    <form action="/users" method="post">
        <input type="text" name="productName" placeholder="Product Name" />
        <input type="text" name="description" placeholder="Description" />
        <input type="text" name="type" placeholder="Category" />
        <input type="text" name="price" placeholder="Product Price" />
        <input type="submit" value="Сохранить"/>
    </form>
</div>
</body>
</html>