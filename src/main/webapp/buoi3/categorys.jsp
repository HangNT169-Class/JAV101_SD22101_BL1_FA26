<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="">
    Tên: <input name="ten"/>
    <button type="submit">Search</button>
</form>
<br/>
<p>Tesst</p>
<button><a href="/category/view-add">Add Cate</a></button>
<%-- Hien thi du lieu JSP: table/if..else/switch..case
-> JSTL <c:ten ham> --%>
<table border="1" cellspacing="1" cellpadding="10">
    <thead>
    <tr>
        <th>STT</th>
        <th>Cate code</th>
        <th>Cate name</th>
        <th>Hanh dong</th>
    </tr>
    </thead>
    <tbody>
    <%--  for each: c:
    for(SinhVien sv : listSinhVien) {
    }
    ${} => bien goi tu servlet sang
    varStatus: stt trong mang - for i -> index -> bat dau bang 0
    var: doi tuong Object
    items: mang ds
    --%>
    <c:forEach items="${listsCate}" var="cate" varStatus="i">
        <tr>
            <td>${i.index + 1}</td>
                <%-- Copy tu entity -> thuoc tinh bien--%>
            <td>${cate.categoryCode}</td>
            <td>${cate.categoryName}</td>
            <td>
                <%-- Cach truyen gia tri tren duong dan
                1. Neu chi truyen 1 gia tri => dau ?
                2. Neu truyen nhieu hon 1 duong dan:
                gia tri thu 2 tro di => dau &
                --%>
<%--                <a href="/category/detail?a=${cate.id1}&name=${cate.categoryName}">Delete</a>--%>
                <a href="/category/delete?a=${cate.id}">Delete</a>
                <a href="/category/detail?id=${cate.id}">Detail</a>
                <a href="/category/view-update?id=${cate.id}">Update</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
