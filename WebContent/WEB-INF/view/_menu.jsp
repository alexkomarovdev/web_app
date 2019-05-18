<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<a href="${pageContext.request.contextPath}/employeeTask">
  Employee Task
</a>
||
<a href="${pageContext.request.contextPath}/managerTask">
  Manager Task
</a>
||
<a href="${pageContext.request.contextPath}/UserInfoServlet">
  User Info
</a>       
||
<a href="${pageContext.request.contextPath}/LoginPageServlet">
  Login
</a>
||
<a href="${pageContext.request.contextPath}/LogoutPageServlet">
  Logout
</a>
 
&nbsp;
<%-- <span style="color:red">[ ${loginedUser.userName} ]</span> --%>
<span style="color:red">[ ${loginedUser.name} ]</span>