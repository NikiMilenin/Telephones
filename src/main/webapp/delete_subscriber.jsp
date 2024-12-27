<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Удалить пользователя</title>
</head>
<body>

Вы действительно хотите удалить пользователя ${param.name} ${param.surname}?

<form action = "${pageContext.request.contextPath}/delete_user" method="post">
    <input type="hidden" name="phone" value="${param.phone}">
    <input type="submit" value="Удалить">
</form>

</body>
</html>