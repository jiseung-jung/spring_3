<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
  <h3>Member List</h3>
  	<table class="table table-hober">
  		<tr>
  			<td>Num</td>
  			<td>ID</td>
  			<td>Password</td>
  			<td>Name</td>
  			<td>Email</td>
  		</tr>
  			<c:forEach items="${list}" var="dto">
  		<tr>
  			<td>${dto.num}</td>
  			<td><a href="./memberSelect?num=${dto.num}">${dto.id}</td>
  			<td>${dto.pw}</td>
  			<td>${dto.name}</td>
  			<td>${dto.email}</td>
  		<tr>
  		</c:forEach>
  </table>
  
  <div>
  <c:if test="${pager.beforeCheck}"><a href="./memberList?curPage=${pager.startNum-1}">[이전]</a></c:if>
  	<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
  		<a href="./memberList?curPage=${i}">${i}</a>
  	</c:forEach> 
  	<c:if test="${pager.nextCheck}"><a href="./memberList?curPage=${pager.lastNum+1}">[다음]</a></c:if>
  </div>
  
  
  
</div>
</body>
</html>
