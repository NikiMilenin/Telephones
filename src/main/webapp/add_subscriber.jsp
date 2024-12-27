<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добавить нового пользователя</title>
</head>
<body>
<form action = "${pageContext.request.contextPath}/show_subscribers" method="post">
    <input required type="text" name="name" placeholder="Имя">
    <input required type="text" name="surname" placeholder="Фамилия">
    <input required type="text" name="phone1" placeholder="Номер 1">
    <input type="text" name="phone2" placeholder="Номер 2">
    <input type="text" name="phone3" placeholder="Номер 3">
    <input type="submit" value="Сохранить">
</form>
</body>
</html>