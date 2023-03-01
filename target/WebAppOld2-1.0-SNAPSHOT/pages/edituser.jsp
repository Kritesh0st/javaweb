<%-- 
    Document   : edituser
    Created on : Feb 28, 2023, 10:18:32 AM
    Author     : heret
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    <link rel="stylesheet" href="../css/style.css">
    <link rel="stylesheet" href="css/style.css">
    <style>
      .mainbody{height:100vh;}
      .formbody{width:300px;height:400px;padding:20px;}
      .formbody h3{padding-bottom:5px;}
      .formlab{display:block;padding-bottom:5px;padding-top:10px;}
      .formtxt{font-size:16px;padding:4px 8px;}
      .formbtnbox{padding-top: 15px;}
      .formbtnreset{font-size:16px;padding:5px 20px;border-radius:3px;cursor: pointer;width:100%;}
      
      .formforgetpwbox{padding-top:12px;}
      .formforgetpw,.formbtnsubmit{font-size:15px;color:#000;}
    </style>
    </head>
    <body>
        <div class="mainbody bor flex aic jcc fdc">
            <%@include file="../include/navbar.jsp" %>
        <h1>Edit User</h1>
        <c:forEach items="${id}" var="id">
        <form class="formbody borx flex fdc" action="user?page=updateuser&id=${id}" method="post">
        </c:forEach>
        <h3>Register</h3>
        <c:forEach items="${student}" var="student">
        <lable class="formlab1 formlab bor">Username</lable>
        <input type="text" class="formtxt1 formtxt borx" name="username" value="${student.username}">
        
        <lable class="formlab2 formlab bor">Full name</lable>
        <input type="text" class="formtxt2 formtxt borx" name="fullname" value="${student.fullname}">
        
        <lable class="formlab2 formlab bor">Password</lable>
        <input type="text" class="formtxt2 formtxt borx" name="password" value="${student.password}">
        
        <div class="formbtnbox bor flex">
          <input type="submit" class="formbtnreset borx" value="Edit">
        </div>
        
        </div>
        </c:forEach>
      </form>
    </body>
</html>
