<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Title</title>
  </head>
  <body>
    <form action="/category/add" method="post">
    <%--  De su dung BeanUtils
    => name input trung name trong entity
        --%>
      Cate code: <input type="text" name="categoryCode" />
      <br />
      Cate name: <input type="text" name="categoryName" />
      <br />
      <button type="submit">Add</button>
    </form>
  </body>
</html>
