<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	 付款總額 <br /><br />

    信用卡類型:
    <select name="type">
      <option value="VISA">VISA</option>
      <option value="Mastercard">Mastercard</option>
      <option value="JCB">JCB</option>
    </select>
    <br />
    信用卡卡號: <input type="text" name="number1" />-
    <input type="text" name="number2" />-
    <input type="text" name="number3" />-
    <input type="text" name="number4" /> <br />
    卡片有效期限:<input type="text" name="deadline" /> <br />
    信用卡安全碼:
    <input type="text" name="security" /> <br /><br />
    持卡人資料<br /><br />
    持卡人姓名:<input type="text" name="name" /> <br />
    手機號碼:<input type="text" name="phone" /> <br />
    電子信箱:<input type="text" name="email" /> <br />
    帳單地址:<input type="text" name="address" /> <br />
</body>
</html>