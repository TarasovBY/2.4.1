
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Страница Админа</title>
</head>
<body>
<a href="/logout">Выйти из системы</a>
<br>
<h1>Страница Админа</h1>
<table border="3">
    <tr>
        <td>Айди</td>
        <td>Имя</td>
        <td>Телефон</td>
        <td>Пароль</td>
        <td>Роль</td>
        <td>Действия</td>
    </tr>
    <c:forEach var="variable" items="${users}">
        <form action="admin/updateuser" method="post">
            <tr>
                <td>
                    <p align="center">${variable.id}</p>
                    <input type="hidden" name="id" value="${variable.id}">
                </td>
                <td>
                    <input type="text" name="name" value="${variable.name}">
                </td>
                <td>
                    <input type="text" name="telephone" value="${variable.telephone}">
                </td>
                <td>
                    <input type="text" name="password" value="${variable.password}">
                </td>
                <td>
                    <p style="margin: 5px" align="center">Текущие роли:</p>
                        <c:forEach var="role" items="${variable.role}">
                            ${role.role == 'Admin' ? "<strong><p align=center>- Admin</p></strong>" : "<strong><p align=center>- User</p></strong>" }
                        </c:forEach>
                    <p align="center">Изменить роль:</p>
                    <select style="width: -moz-available" align="center" multiple size="2" name="roles" >
                        <option name="admin">Admin</option>
                        <option name="user">User</option>
                    </select>
                </td>
                <td>
                    <input type="submit" value="Редактировать">
        </form>
        <form action="admin/deleteuser" method="post">
            <input type="hidden" name="id" value="${variable.id}">
            <input type="hidden" name="name" value="${variable.name}">
            <input type="hidden" name="telephone" value="${variable.telephone}">
            <input type="hidden" name="password" value="${variable.password}">
            <input type="hidden" name="roles" value="${variable.role}">
            <input type="submit" value="Удалить">
        </form>

        </tr>
    </c:forEach>
</table>
<h1>Добавить нового юзера</h1>
<table border="3">
    <form action="admin/adduser" method="post">
        <tr>
            <td>
                <input type="text" name="name" value="Имя юзера">
            </td>
            <td>
                <input type="text" name="telephone" value="Телефон юзера">
            </td>
            <td>
                <input type="text" name="password" value="Пароль юзера">
            </td>
            <td>
                <select multiple size="2" name="roles">
                    <option name="admin">Admin</option>
                    <option name="user">User</option>
                </select>
            </td>
            <td>
                <input type="submit" value="Добавить юзера"></td>
        </tr>
    </form>
</table>
</body>
</html>
