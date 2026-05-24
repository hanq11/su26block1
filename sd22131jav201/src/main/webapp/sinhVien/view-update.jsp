<%--
  Created by IntelliJ IDEA.
  User: lovep
  Date: 5/24/2026
  Time: 6:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    Sua sinh vien
    <form action="/sinh-vien/sua" method="post">
        Id: <input type="text" name="id" value="${sv.id}"> <br>
        Ten: <input type="text" name="ten" value="${sv.ten}"> <br>
        Tuoi: <input type="text" name="tuoi" value="${sv.tuoi}"> <br>
        Gioi tinh:
        Nam: <input type="radio" name="gioiTinh" value="false" ${sv.gioiTinh == "false" ? "checked" : ""}>
        Nu: <input type="radio" name="gioiTinh" value="true" ${sv.gioiTinh == "true" ? "checked" : ""}>
        <br>
        <button>Sua</button>
    </form>
</body>
</html>
