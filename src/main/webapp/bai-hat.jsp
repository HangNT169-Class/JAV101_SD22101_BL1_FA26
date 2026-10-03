<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: hangnt
  Date: 3/10/26
  Time: 11:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--Load combobox--%>
<select>
    <c:forEach items="${listCS}" var="cs">
        <option>${cs.tenCaSi}</option>
    </c:forEach>
</select>
<table border="1">
    <thead>
    <tr>
        <th>stt</th>
        <th>tenbaihat</th>
        <th>tentacgia</th>
        <th>thoiluong</th>
        <th>gia</th>
        <th>Ten ca si</th>
        <th>Tuoi</th>
        <th>Que quan</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listBH}" var="baiHat" varStatus="i">
        <tr>
            <td>${i.index + 1}</td>
            <td>${baiHat.tenBaiHat}</td>
            <td>${baiHat.tenTacGia}</td>
            <td>${baiHat.thoiLuong}</td>
            <td>${baiHat.gia}</td>
            <td>${baiHat.caSi1.tenCaSi}</td>
            <td>${baiHat.caSi1.tuoi}</td>
            <td>${baiHat.caSi1.queQuan}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
