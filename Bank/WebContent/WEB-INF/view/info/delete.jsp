<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>delete</title>
</head>
<body>
정말 해지하시겠습니까?


<c:url var="accInfo" value="/DeleteProcess.do"><c:param name="accNo" value="${accountList.accNo }"/></c:url>
<a href="${accInfo}">네</a> <button onclick = "location= '/AccInfo.do'">아니요</button>
</body>
</html>