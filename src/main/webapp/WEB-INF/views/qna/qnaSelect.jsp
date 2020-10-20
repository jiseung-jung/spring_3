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
  <h3>QnA Select Page</h3>
  <hr>
  		<h3 id="num">${dto.num}</h3>
  		<h3>Title : ${dto.title}</h3>
  		<h3>Writer : ${dto.writer}</h3>
  		<h3>Contents : ${dto.contents}</h3>
  <hr>
  		<input type="button" title="${dto.num}" value="Delete" class="btn btn-default" id="del">
		<input type="button" value="Update" class="btn btn-default" id="upd">
</div>

	<script type="text/javascript">
		
		$("#del").click(function(){
			
			var num = $("#del").attr("title");
			alert(num);
			
			location.href="./qnaDelete?num="+num;
			
		});
		
		$("#upd").click(function () {
			location.href="./qnaUpdate?num=${dto.num}";
		});	
	
		
	
	</script>

</body>
</html>