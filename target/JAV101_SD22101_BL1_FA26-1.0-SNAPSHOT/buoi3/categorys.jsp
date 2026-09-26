<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Title</title>
  </head>
  <body>
    <form action="">
      Tên: <input name="ten" />
      <button type="submit">Search</button>
    </form>
    <br />
    <button><a href="">Add Cate</a></button>
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
      --%>
      <c:forEach items="${listsCate}" var="cate">
        <tr>
          <td></td>
          <%-- Copy tu entity -> thuoc tinh bien--%>
          <td>${cate.categoryCode}</td>
          <td>${cate.categoryName}</td>
          <td></td>
        </tr>
      </c:forEach>
      </tbody>
    </table>
  </body>
</html>
