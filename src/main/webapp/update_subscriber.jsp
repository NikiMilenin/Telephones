<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Изменить данные пользователя</title>
</head>
<body>

Редактировать пользователя

<form action="${pageContext.request.contextPath}/update_subscriber" method="post">
    <input type="text" name="name" value=${param.name}>
    <input type="text" name="surname" value=${param.surname}>
    <input type="text" name="phone1" value=${param.phone1}>
    <input type="text" name="phone2" value=${param.phone2}>
    <input type="text" name="phone3" value=${param.phone3}>
    <input type="hidden" name="old_phone" value="${param.phone1}">
    <input type="submit" value="Обновить">
</form>

</body>
</html>