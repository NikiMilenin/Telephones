<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Телофонный справочник</title>
</head>
<body>
Приветствую<br>
Телефонная книга.


<form action = "${pageContext.request.contextPath}/show_subscribers" method="get">
  <input type="submit" value="Отобразить пользователей">
</form>
</body>
</html>