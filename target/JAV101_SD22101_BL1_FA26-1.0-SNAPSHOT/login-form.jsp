<%--
  Created by IntelliJ IDEA.
  User: hangnt
  Date: 22/9/26
  Time: 10:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--Nhan gia tri duoc truyen servlet--%>
${mess}
<form method="POST" action="/ket-qua">
    <h1>trang login</h1>
    username <input type="text" name="uname"> <br>
    password <input type="password" name="pass"> <br>
    <button type="submit">Login</button>
</form>
</body>
</html>
