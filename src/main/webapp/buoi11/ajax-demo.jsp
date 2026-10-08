<%--
  Created by IntelliJ IDEA.
  User: hangnt
  Date: 8/10/26
  Time: 10:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Ajax demo</h1>
<button onclick="clickMe()">Click hiển thị thông tin sinh viên</button>
<p id="result-data">Result</p>
</body>
<script src="https://code.jquery.com/jquery-4.0.0.min.js"
        integrity="sha256-OaVG6prZf4v69dPg6PhVattBXkcOWQB62pdZ3ORyrao=" crossorigin="anonymous"></script>
<script>
    function clickMe() {
        // Cu phap ajax
        $.ajax(
            {
                url: "/api/sinh-vien/hien-thi",
                type: "GET",
                dataType: "json",
                success: function (response) {
                    console.log(response)
                    document.getElementById("result-data").innerHTML =
                        "MSSV: " + response.mssv + " Ten: " + response.ten +" Tuoi: "+ response.tuoi
                },
                errors: function () {
                    alert("API goi loi");
                }
            }
        )
    }
</script>
</html>
