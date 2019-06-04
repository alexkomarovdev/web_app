<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<!DOCTYPE html>
<html>
   <head>
      <meta charset="UTF-8">
      <title>ASUP Task</title>
   </head>
   <body>
   
      <jsp:include page="_menu.jsp"></jsp:include>
       
      <h3>ASUP Task</h3>
       
      Hello, This is a ASUP protected page!
       
       
       
<br>
<br>
<form method="GET" accept-charset="UTF-8" action="${pageContext.request.contextPath}/SetRoleServlet">
<input type="submit" value="Страница настройки прав пользователей">  
</form>
       
   </body>
</html>