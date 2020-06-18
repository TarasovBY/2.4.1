<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Страница Юзера</title>
</head>
<body>
<a href="/logout">Выйти из системы</a>
<br>
<p>Страница Юзера</p>
<table border="3">
    <tr>
        <td>Айди</td>
        <td>Имя</td>
        <td>Телефон</td>
        <td>Пароль</td>
    </tr>
    <c:set var="user" value="${userSolo}" />
    <tr>
        <td>${user.id}</td>
        <td>${user.name}</td>
        <td>${user.telephone}</td>
        <td>${user.password}</td>
    </tr>
</table>
</body>
</html>
