<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
      <meta charset="UTF-8">
      <title>Login</title>
   </head>
   <body>
 
      <jsp:include page="_menu.jsp"></jsp:include>   
 
      <h3>Login Page</h3>
 
      <p style="color: red;">${errorString}</p>
 <!-- set codepage input data -->
      <form method="POST" accept-charset="UTF-8" action="${pageContext.request.contextPath}/LoginPageServlet">
         <input type="hidden" name="redirectId" value="${param.redirectId}" />
         <table border="1">
            <tr>
               <td>User Name</td>
               <td><input type="text" name="login" value= "${user.login}" /> </td>
            </tr>
            <tr>
               <td>Password</td>
               <td><input type="password" name="password" value= "${user.password}" /> </td>
            </tr>
          
            <tr>
               <td colspan ="2">
                  <input type="submit" value= "Submit" />
                  <a href="${pageContext.request.contextPath}/">Cancel</a>
               </td>
            </tr>
         </table>
      </form>
 
      <p style="color:blue;">Login with:</p>
       
      employee1/123 <br>
      manager1/123 <br>
      Анатолий Николаевич<br> 1 <br>
      Наталья Алексеевна<br> 3 <br>
  
 
   </body>
</html>