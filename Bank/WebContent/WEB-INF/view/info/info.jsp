<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>계좌 정보</title>
</head>
<body>
<h1>(계좌번호) | (이름)</h1>

 거래내역  
<table border = "1">
<tr>
<th>번호</th><th>가입유형></th><th> 날짜</th><th>입금액</th><th>출금액</th><th>남은금액</th>
</tr>
<tbody>
<c:forEach items = "${accList}" var = "accList" varStatus = "stat">
	<tr>
		<td>${stat.count }</td><td>${accList.type}</td><td>${accList.date}</td><td>${accList.deposit}</td><td>${accList.withdraw }</td><td>${accList.amount} </td>
	</tr>
</c:forEach>
</tbody>
</table>
<button onclick = "location='/delete'">해지하시겠습니까?</button>
</body>
</html>