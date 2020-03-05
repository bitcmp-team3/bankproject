<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width-device-width, initial-scale=1, shrink-to-fit=no">
<meta charset="UTF-8">
<title>회원가입</title>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
<link rel="stylesheet" href="./css/bootstrap.min.css">
<link rel="stylesheet" href="./css/custom.css">
<link rel="stylesheet" href="./css/style.css">
<script src="./js/jquery.min.js"></script>
<script src="./js/bootstrap.min.js"></script>
<script src="./js/popper.min.js"></script>
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
   <div class="container">
      <div class="col-md-6 mx-auto text-center">
         <div class="header-title">
            <h1 class="wv-heading--title">
            		회원가입 페이지
            </h1>
         </div>
      </div>
      
      <div class="row">
      
         <div class="col-md-4 mx-auto">
     
            <div class="myform form ">
                <form action="/signup.do" method="post">
                  <div class="form-group">
                  
                     <input type="text" name="id" class="form-control my-input" placeholder="ID를 입력하세요">
                  </div>
                  <div class="form-group">
                     <input type="password" name="pw" class="form-control my-input" placeholder="비밀번호를 입력하세요">
                  </div>
                  <div class="form-group">
                     <input type="text" name="name" class="form-control my-input" placeholder="이름을 입력하세요">
                  </div>
                  <div class="form-group">
                     <input type="date" name="birthday" value="1993-04-06" min="1900-01-01" max="2020-03-01" class="form-control my-input">
                  </div>
                  <div class="form-group">
                   <input type="text" name="phoneNo"  class="form-control my-input" placeholder="전화번호를 입력하세요" onKeyup="inputPhoneNumber(this);">
                  </div>
                  <div class="form-group">
                   <input type="text" name="addr"  class="form-control my-input"  placeholder="주소를 입력하세요">
                  </div>
                  <div class="text-center ">
                     <button type="submit" class=" btn btn-outline-success my-2 my-sm-0">확인</button>
                  </div>
               </form>
            </div>
         </div>
      </div>
   </div>
</body>
</html>