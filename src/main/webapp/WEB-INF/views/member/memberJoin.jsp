<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
	
	
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

	

</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">WebSiteName</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="#">Home</a></li>
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Page 1 <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="#">Page 1-1</a></li>
          <li><a href="#">Page 1-2</a></li>
          <li><a href="#">Page 1-3</a></li>
        </ul>
      </li>
      <li><a href="./notice/noticeList.notice">Notice</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
 	  <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
      <li><a href="./member/memberJoin.member"><span class="glyphicon glyphicon-user"></span> Join</a></li>
      <li><a href="./member/memberList.member"><span class="glyphicon glyphicon-user"></span> Member List</a></li>
    </ul>
  </div>
</nav>
  

	<div class="container">
  <h2>Member Join Form</h2>
  <form action="./memberJoin" method="post">
    
     <div class="form-group">
      <label for="id">ID:</label>
      <input type="text" class="form-control" id="id" placeholder="Enter ID" name="id">
    </div>
    
      <div class="form-group">
      <label for="pw">Password:</label>
      <input type="text" class="form-control" id="pw" placeholder="Enter Password" name="pw">
    </div>
    
      <div class="form-group">
      <label for="name">Name:</label>
      <input type="text" class="form-control" id="name" placeholder="Enter Name" name="name">
    </div>
    
      <div class="form-group">
      <label for="email">EMAIL:</label>
      <input type="text" class="form-control" id="email" placeholder="Enter Email" name="email">
    </div>
    
    
    <button type="submit" class="btn btn-default">Join</button>
  </form>
</div>


	


</body>
</html>