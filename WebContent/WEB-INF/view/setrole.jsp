<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Страница настройки прав пользователей</title>
</head>
<body>
Страница настройки прав пользователей
<br>
<br>
<table>
<tr><th>id</th><th>Имя</th><th>Фамилия</th><th>Login</th><th>Отдел</th><th>Роли</th></tr>
<c:forEach var="user" items="${users}">
 <tr>
 	<td>${user.id}</td>
	<td>${user.name}</td>
	<td>${user.second}</td>
    <td>${user.login}</td>
    <td>${user.id_department}</td>
    <td>${user.roles}</td>
    <td>
    <a href='<c:url value="/SetRoleEditServlet?id=${user.id}" />'>Редактировать</a> |
    <form method="post" action='<c:url value="/delete" />' style="display:inline;">
        <input type="hidden" name="id" value="${user.id}">
        <input type="submit" value="Delete">
    </form>
 </td></tr>
</c:forEach>
</table>
</body>
</html>