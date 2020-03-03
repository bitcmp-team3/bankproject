<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Account List</title>
</head>
<body>
<h1>${accountList.name }님 환영합니다^^</h1>
<button type="button" onclick="location.href='createAccount.jsp'">신규발급</button>
<button type="button" onclick="location.href='logout.jsp'">로그아웃</button>
<table border='1'>
<thead>
<tr>
<th>계좌 유형</th><th>계좌 번호</th><th>잔액</th>
</tr>
</thead>
<tbody>
<c:forEach var="accountList" items="${accountList }">
<tr>
<td>${accountList.type }</td>
<td>${accountList.accNo }</td>
<td>${accountList.amount }</td>
</tr>
</c:forEach>
</tbody>
</table>

</body>
</html>