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
  <h2>QnA Write Form</h2>
  <form id="frm" action="./qnaWrite" method="post">
    <div class="form-group">
      <label for="title">Title:</label>
      <input type="text" class="form-control" id="title" placeholder="Enter title" name="title">
    </div>
    
     <div class="form-group">
      <label for="writer">Writer:</label>
      <input type="text" class="form-control" id="writer" placeholder="Enter Writer" name="writer">
    </div>
    
     <div class="form-group">
      <label for="contents">Contents:</label>
	  <textarea class="form-control" rows="10" id="contents" name="contents"></textarea>
    </div>
    
    <button type="submit" class="btn btn-default">Write</button>
  </form>
</div>

</body>
</html>