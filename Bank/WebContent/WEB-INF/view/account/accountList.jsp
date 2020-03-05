<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Account List</title>

</head>
<body>
<div class="container-fluid">
<div class="row">
<div class="col-lg-8 col-md-4 col-sm-6 col-xs-12">
<div class="tile">
<div class="wrapper">                  
<div class="header">${sessionScope.name }님 환영합니다</div>
<div class="text-right">    
<button type="button" class="btn btn-primary btn-sm"
onclick="location.href='/logout.do'">로그아웃</button> 
</div> 
<table class="table table-hover">
<thead>
<tr>
<th scope="col" colspan="2">계좌 번호</th>
<th scope="col" >계좌 유형</th>
<th scope="col" >잔액</th>
</tr>
</thead>
<tbody>
<c:forEach var="accountList"  items="${accountList }">
<c:url var="transaction" value="/transaction.do">
<c:param name="accNo" value="${accountList.accNo }"/></c:url>
<tr>
<th scope="row"colspan="2"><a href="${transaction}">${accountList.accNo }</a></th>
<td>${accountList.type }</td>
<td>${accountList.amount }원</td>
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