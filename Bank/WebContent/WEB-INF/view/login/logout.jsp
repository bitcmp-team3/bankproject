<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>logout</title>
</head>
<body>
<jsp:useBean id="id" class="java.lang.String" scope="session"/>
${id }님 성공적으로 로그아웃되었습니다.<br>
감사합니다.<br>
<% session.invalidate(); %>
<a href="/login">다시 로그인하기</a>
</body>
</html>