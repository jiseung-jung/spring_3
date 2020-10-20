<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/bootStrap.jsp"></c:import>

<style type="text/css">
			table {
	margin-top: 10px;
				}
</style>

</head>
<body>

<c:import url="../template/header.jsp"></c:import>


<div class="container">
  <h3>QnA List</h3>
  <div class="row">
  <div class="col-sm-8">
  <form action="./qnaList" id="searchForm">
  	<input type="hidden" name="curPage" id="curPage">
  	 <div class="input-group">
    	  <select class="input-group-sm" id="kind" name="kind">
 			  <option value="tt">Title</option>
   			  <option value="wr">Writer</option>
  			  <option value="con">Contents</option>
		  </select>
    	<input id="search" type="text" class="form-control" name="search" placeholder="Additional Info">
    	<div class="input-group-btn">
      		<button class="btn btn-default" type="submit">
        	<i class="glyphicon glyphicon-search"></i>
      		</button>
    	</div>
  	</div>
  	
  </form>
  </div>
  </div>
  
  <div>
  <table class="table table-hober">
  		<tr>
  			<td>Num</td>
  			<td>Title</td>
  			<td>Writer</td>
  			<td>Date</td>
  			<td>Hit</td>
  		</tr>
  		<c:forEach items="${list}" var="dto" varStatus="vs">
  		<tr>
  			<td>${dto.num}	: ${vs.index}</td>
  			<td><a href="./qnaSelect?num=${dto.num}">${dto.title}</a></td>
  			<td>${dto.writer}</td>
  			<td>${dto.regDate}</td>
  			<td>${dto.hit}</td>
  		<tr>
  		</c:forEach>
  </table>
  </div>
  
  <a href="./qnaWrite" class="btn btn-default">Write</a>

</body>
</html>