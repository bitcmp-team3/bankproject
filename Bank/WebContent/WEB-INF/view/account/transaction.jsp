<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Transaction</title>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
	function goBack() {
		window.history.back();
	}
</script>
<SCRIPT LANGUAGE = "JavaScript">
function popup(){
	var url = "/delete";
	var name = "popup";
	window.open(url,name,"height=100,width=200,toolbar=no,status=no,location=no,scrollbars=yes,menubar=no,resizable=yes");
	
}
</script>

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
<body>
<div class="container-fluid">
<div class="row">
<div class="col-lg-8 col-md-4 col-sm-6 col-xs-12">
<div class="tile">
<div class="wrapper">                  
<div class="header">${sessionScope.accountInfo.accNo} ${sessionScope.accountInfo.type} 계좌의 거래내역입니다.</div>

<!-- <div class="text-right">    
<button type="button" class="btn btn-primary btn-sm" onclick="location.href='/delete'">해지하기</button> 
</div>  -->
<input onclick="popup()" type="button" class="btn btn-primary btn-sm" value = "해지 ">
		<input type="button" class="btn btn-primary btn-sm" value="돌아가기"onclick="goBack()">


<table class="table table-hover">
<thead>
<tr>
<th scope="col" >날짜</th>
<th scope="col" >입금액</th>
<th scope="col" >출금액</th>
<th scope="col" >잔액</th>
</tr>
</thead>
<tbody>
<c:forEach items = "${transaction}" var = "transaction" >
<tr>
<td>${transaction.date}</td><td>${transaction.deposit}</td><td>${transaction.withdraw}</td><td>${transaction.amount} </td>
</tr>
</c:forEach>
</tbody>
</table>
</div>
</div>
</div>     
</div>
</div>
</body>
</html>