
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta charset="UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
 <meta name="description" content="">
<title>Insert title here</title>
<link rel="stylesheet" href="signUpStyle.css"/>

</head>
<body>
	 <div class="wrapper">
	 <p>${error}</p>
    <form class="form-signin" action="loginController" method="post"> 
    <img alt="" src="images/Google.png" width="100px" height="30px"> 
    <div style="color: #FF0000;" id="errorMessage"></div>     
      <h2 class="form-signin-heading">Please login</h2>
      <h5>with your account</h5>
      <img alt="" src="images/user.png" width="20px" height="20px">
      <input type="email" 
      		 class="form-control"
      		 name="username" 
      		 placeholder="Email Address"
      		 title="Username should only contain lowercase letters. e.g. john"
      		 ><br>
      <div id="errfn">   </div>
      <br>
      <img alt="" src="images/key.jpg" width="20px" height="20px">
      <input type="password" 
      		 class="form-control" 
      		 name="password" 
      		 placeholder="Password" 
      		 pattern="[A-Za-z0-9]{8,16}"
      		 title="Username should only contain lowercase,uppercase  letters and numbers with min6 to max16 digit. e.g. John123"
      		 >      
      <label class="checkbox"><br><br>
        <input type="checkbox" value="remember-me" id="rememberMe" name="rememberMe"> Remember me
      </label>
      <br>
      <input type="submit" value="submit" name="submit">
        <br><br>
      	
      	<div class="forgote">
      		 <span> Forgot <a href="#">password?</a></span>   OR <br><br>
       		 <a href="registration" >Registration</a>
      	</div>
      	
    </form>
  </div>
</body>
</html>