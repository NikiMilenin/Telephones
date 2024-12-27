<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<html>
<head>
    <title>Список пользователей</title>
    <style>
        TABLE {
            border-collapse: collapse; /* Убираем двойные линии между ячейками */
        }
        TD, TH {
            width: 115px;
            padding: 3px; /* Поля вокруг содержимого таблицы */
            border: 1px solid black; /* Параметры рамки */
        }
        TH {
            background: #b0e0e6; /* Цвет фона */
        }
    </style>
</head>
<body>
<table>
    <tr>
        <th>Имя</th>
        <th>Фамилия</th>
        <th>Телефон 1</th>
        <th>Телефон 2</th>
        <th>Телефон 3</th>
        <th> </th>
    </tr>
    <c:forEach items="${subscribers}" var = "user">
        <tr>
            <td>${user.getName()}</td>
            <td>${user.getSurname()}</td>
            <td>${user.getTelephoneNumber()[0].toString()}</td>
            <td>${user.getTelephoneNumber()[1].toString()}</td>
            <td>${user.getTelephoneNumber()[2].toString()}</td>
            <td>
                <form action="update_subscriber.jsp" method="get">
                    <input type="submit" value="Изменить" style="float:left; width:100px">
                    <input type="hidden" name="name" value="${user.getName()}">
                    <input type="hidden" name="surname" value="${user.getSurname()}">
                    <input type="hidden" name="phone1" value=${user.getTelephoneNumber()[0].toString()}>
                    <input type="hidden" name="phone2" value=${user.getTelephoneNumber()[1].toString()}>
                    <input type="hidden" name="phone3" value=${user.getTelephoneNumber()[2].toString()}>
                </form>
                <form action="delete_subscriber.jsp" method="get">
                    <input type="hidden" name="name" value="${user.getName()}">
                    <input type="hidden" name="surname" value="${user.getSurname()}">
                    <input type="hidden" name="phone" value=${user.getTelephoneNumber()[0].toString()}>
                    <input type="submit" value="Удалить" style="float:left; width:100px">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>

<form action="add_subscriber.jsp">
    <input type="submit" value="Добавить нового абонента" style="padding: 5px; margin: 15px">
</form>
</body>
</html>