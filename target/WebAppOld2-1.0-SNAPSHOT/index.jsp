<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <title>Log In</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/style.css">
    <style>
      .mainbody{height:100vh;}
      .formbody{width:300px;height:400px;padding:20px;}
      .formbody h3{padding-bottom:5px;}
      .formlab{display:block;padding-bottom:5px;padding-top:10px;}
      .formtxt{font-size:16px;padding:4px 8px;}
      .formbtnbox{padding-top: 15px;}
      .formbtnsubmit{font-size:16px;padding:5px 20px;border-radius:3px;cursor: pointer;width:100%;}

      .formforgetpwbox{padding-top:12px;}
      .formforgetpw,.formbtnreset{font-size:15px;color:#000;}
    </style>
  </head>
  <body>
    <div class="mainbody bor flex aic jcc">
      <form class="formbody borx flex fdc" action="user?page=insert" method="post">
        <h3>Log In</h3>
        <lable class="formlab1 formlab bor">Username</lable>
        <input type="text" class="formtxt1 formtxt borx" name="username" value="cat">
        <lable class="formlab2 formlab bor">Password</lable>
        <input type="text" class="formtxt2 formtxt borx" name="password" value="cat">
        <div class="formbtnbox bor flex">
          <input type="submit" class="formbtnsubmit borx" value="Login">
        </div>
        <div class="formforgetpwbox bor flex fdc aic">
            <a href="user?page=register" class="formbtnreset bor">Create an account?</a>
          <a href="#" class="formforgetpw bor">Forget password</a>
        </div>
      </form>
    </div>
  </body>
</html>