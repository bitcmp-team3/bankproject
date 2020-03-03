<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>회원가입</title>
<script>
function inputPhoneNumber(obj) {
    var number = obj.value.replace(/[^0-9]/g, "");
    var phone = "";

    if(number.length < 4) {
        return number;
    } else if(number.length < 7) {
        phone += number.substr(0, 3);
        phone += "-";
        phone += number.substr(3);
    } else if(number.length < 11) {
        phone += number.substr(0, 3);
        phone += "-";
        phone += number.substr(3, 3);
        phone += "-";
        phone += number.substr(6);
    } else {
        phone += number.substr(0, 3);
        phone += "-";
        phone += number.substr(3, 4);
        phone += "-";
        phone += number.substr(7);
    }
    obj.value = phone;
}
</script>
</head>
<body>
 <form action="/signup.do" method="post">    

	아이디 : <input type="text" name="id" style="text-align:center;"> <br>
	비밀번호 : <input type="password" name="pw" style="text-align:center;"> <br>
	이&nbsp;&nbsp;&nbsp;름 : <input type="text" name="name" style="text-align:center;"> <br>
	생년월일 : <input type="date" value="1993-04-06" min="1900-01-01" max="2020-03-01"  name="birthday" style="text-align:center;"> <br>
	전화번호 : <input type="text" name="phoneNo" onKeyup="inputPhoneNumber(this);" style="text-align:center;"/> <br>
	주&nbsp;&nbsp;&nbsp;소 : <input type="text" name="addr" style="text-align:center;"> <br>
	<button type="submit">확인</button>
	
 </form>
</body>
</html>