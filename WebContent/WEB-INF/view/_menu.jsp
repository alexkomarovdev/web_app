<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<a href="${pageContext.request.contextPath}/EmployeeTaskServlet">
  Employee Task
</a>
||
<a href="${pageContext.request.contextPath}/JurTaskServlet">
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




<article class="accordion">

	<section id="acc1">
		<h2><a href="#acc1">Title One</a></h2>
		<p>This content appears on page 1.</p>
	</section>

	<section id="acc2">
		<h2><a href="#acc2">Title Two</a></h2>
		<p>This content appears on page 2.</p>
	</section>

	<section id="acc3">
		<h2><a href="#acc3">Title Three</a></h2>
		<p>This content appears on page 3.</p>
	</section>

	<section id="acc4">
		<h2><a href="#acc4">Title Four</a></h2>
		<p>This content appears on page 4.</p>
	</section>

	<section id="acc5">
		<h2><a href="#acc5">Title Five</a></h2>
		<p>This content appears on page 5.</p>
	</section>
</article>

