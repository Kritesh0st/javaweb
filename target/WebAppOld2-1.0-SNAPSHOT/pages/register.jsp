<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <title>Register</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
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
    <div class="mainbody bor flex aic jcc">
        
      <form class="formbody borx flex fdc" action="user?page=newUsers" method="post">
        <h3>Register</h3>
        
        <lable class="formlab1 formlab bor">Username</lable>
        <input type="text" class="formtxt1 formtxt borx" name="username" value="kritesh01">
        
        <lable class="formlab2 formlab bor">Full name</lable>
        <input type="text" class="formtxt2 formtxt borx" name="fullname" value="Kritesh Thapa">
        
        <lable class="formlab2 formlab bor">Password</lable>
        <input type="text" class="formtxt2 formtxt borx" name="password" value="pass1234">
        
        <div class="formbtnbox bor flex">
          <input type="submit" class="formbtnreset borx" value="Register">
        </div>
        <div class="formforgetpwbox bor flex fdc aic">
          <a href="user?page=newLogin" class="formbtnsubmit bor">Already have an account?</a>
          <a href="#" class="formforgetpw bor">Forget password</a>
        </div>
        
      </form>
    </div>
  </body>
</html>