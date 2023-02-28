<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>User List</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css">
    </head>
    <body>
    <table class="table">
  <thead>
    <tr>
        <th scope="col">id</th>
      <th scope="col">Full name</th>
      <th scope="col">Username</th>
      <th scope="col">Password</th>
      <th scope="col">User details</th>
    </tr>
  </thead>
  <tbody>
     <c:forEach items="${userlist}" var="usr">
    <tr>
      <td>${usr.id}</td>
      <td>${usr.fullname}</td>
      <td>${usr.username}</td>
      <td>${usr.password}</td>
      <td scope="col">
          <a href="user?page=userdetails&id=${usr.id}">
            User details
          </a>
          
      </td>
    </tr>
    </c:forEach>
  </tbody>
</table>
    </body>
</html>
