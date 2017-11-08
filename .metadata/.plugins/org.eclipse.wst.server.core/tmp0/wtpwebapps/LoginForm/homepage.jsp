<!DOCTYPE html>
<%@page import="java.io.PrintWriter"%>
<html>
<head>
 <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>HomePage</title>
<link rel="stylesheet" href="view/homePageStyle.css">
</head>
<body>
<form action=" " method="get">

	

	<!-- sidebar -->
		<div id="mySidenav" class="sidenav">
			<a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
			<a href="#">about</a>
			<a href="#">Notes</a>
			<a href="#">Archive</a>
			<a href="#">Trash</a>
		</div>
	
		<!-- sidemenu button  -->
		 
		
		<!-- main class -->
		<nav class="navbar navbar-inverse">
			<div class="container-fluid">
				<ul class="nav navbar-nav">
					<li><span style="font-size:25px;cursor:pointer" onclick="openNav()">&#9776;</span></li>
					<li><a href="#"> </a></li>
				</ul>
				<div class="navbar-header">
					<a class="navbar-brand" href="#">ToDo</a>
				</div>
				<ul class="nav navbar-nav">
					<li class="active"><a href="#">Home</a></li>
					<li><a href="#">Notes</a></li>
					<li><a href="#">Archive</a></li>
					<li><a href="#">Trash</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#"><span class="glyphicon glyphicon-user"><%
						if(session.getAttribute("loginusername")!=null){
							String username = (String)session.getAttribute("loginusername");
							out.print("Welcome "+username);
						}
					%></span></a></li>
					<li><a href="index.jsp"><span class="glyphicon glyphicon-log-out">logout
					<%
						session.removeAttribute("loginusername");
						session.invalidate();
					%>
					</span></a></li>
					<li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">option
					<span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="#">option1</a></li>
							<li><a href="#">option1</a></li>
							<li><a href="#">option1</a></li>
						</ul>
					</li>	
				</ul>
			</div>
		</nav>
</form>
	<script>
	function openNav() {
   		 document.getElementById("mySidenav").style.width = "250px";
   		 document.getElementById("container-fluid").style.marginLeft = "250px";
	}

	function closeNav() {
   		 document.getElementById("mySidenav").style.width = "0";
   		document.getElementById("container-fluid").style.marginLeft = "0";
	}
</script>
</body>
</html>