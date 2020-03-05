<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>delete</title>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<style type="text/css">
* { margin: 0px; padding: 0px; }
body {
	background: #ecf1f5;
	font:18px "Open Sans", sans-serif; 
}

.tile{
	width: 100%;
	background:#fff;
	border-radius:50px;
	box-shadow:5px 2px 3px -1px rgba(151, 171, 187, 0.7);
	float:left;
  	transform-style: preserve-3d;
  	margin: 10px 10px;

}

.header{
	border-bottom:1px solid #ebeff2;
	padding:19px 0;
	text-align:center;
	color:#59687f;
	font-size:600;
	font-size:35px;	
	position:relative;
}
</style>
</head>
</head>
<body>
	<form action="/DeleteProcess.do" method="post">
		정말 해지하시겠습니까?<br>
		<button type=submit class="btn btn-primary btn-sm">yes</button>
		<input type="button" class="btn btn-primary btn-sm" value="no"onclick="self.close()">
		
	</form>
</body>
</html>