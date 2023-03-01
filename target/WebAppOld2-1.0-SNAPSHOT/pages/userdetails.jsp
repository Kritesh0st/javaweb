<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css">
    </head>
    <body>
        <%@include file="../include/navbar.jsp" %>
        <h1>User details</h1>
        <table class="table">
      <c:forEach items="${stu}" var="st">
    <tr>
        <th scope="col">id</th>
        <td>${st.id}</td>
    </tr>
    <tr>
      <th scope="col">Full name</th>
      <td>${st.fullname}</td>
      </tr>
    <tr>
      <th scope="col">Username</th>
      <td>${st.username}</td>
      </tr>
    <tr>
      <th scope="col">Password</th>
      <td>${st.password}</td>
    </tr>
    <tr>
        <td>
            <a href="user?page=edituser&id=${st.id}">Edit</a>
        </td>
        <td>
            <a href="user?page=deleteuser&id=${st.id}">Delete</a>
        </td>
    </tr>
    </c:forEach>
</table>
    </body>
</html>
