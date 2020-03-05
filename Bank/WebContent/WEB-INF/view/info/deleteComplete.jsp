<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<script type="text/javascript">
        function goBack(){
        	opener.location.href = "/mypage";
        	self.close();		
        }
   </script>
<script>
function popupClose(){
	   
    var theURL = "/mypage"; // 전송 URL
    // 호출 한 부모 페이지에서 URL 호출
    opener.window.location = url;
    // 호출 한 뒤 현재 팝업 창 닫기 이벤트
    close();
} 
</script>
<meta charset="UTF-8">
<title>Insert title here</title>
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
<body>
해지되었습니다.
<input type="button" value="닫기" class="btn btn-primary btn-sm" onclick="goBack()"> <!-- 버튼 -->

</body>
</html>