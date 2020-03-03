<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>계좌 정보</title>
</head>
<body>

<h1>${accInfo.accNo} ${accInfo.type} 계좌입니다.</h1>
 거래내역  
<table border = "1">
<thead>
<tr>
<th> 날짜</th><th>입금액</th><th>출금액</th><th>잔액</th>
</tr>
<tbody>
<c:forEach items = "${accList}" var = "accList" >
<tr>
<td>${accList.date}</td><td>${accList.deposit}</td><td>${accList.withdraw}</td><td>${accList.amount} </td>
</tr>
</c:forEach>
</tbody>
</table>
<button onclick = "location='/delete'">해지하시겠습니까?</button>
</body>
</html>