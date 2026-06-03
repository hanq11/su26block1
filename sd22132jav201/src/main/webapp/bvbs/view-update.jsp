<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lovep
  Date: 6/3/2026
  Time: 11:20 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    Sua bac si:
    <form action="/bac-si/sua" method="post">
        Id: <input type="text" name="id" value="${bacSi.id}"> <br>
        Ten bac si: <input type="text" name="tenBacSi" value="${bacSi.tenBacSi}"> <br>
        Tuoi: <input type="text" name="tuoi" value="${bacSi.tuoi}"> <br>
        Gioi tinh:
        Nam: <input type="radio" value="false" name="gioiTinh" ${bacSi.gioiTinh == "false" ? "checked" : ""}>
        Nu: <input type="radio" value="true" name="gioiTinh" ${bacSi.gioiTinh == "true" ? "checked" : ""}> <br>
        Benh vien:
        <select name="benhVien">
            <c:forEach items="${listBenhVien}" var="bv">
                <option value="${bv.id}" label="${bv.tenBenhVien}" ${bacSi.benhVien.id == bv.id ? "selected" : ""}></option>
            </c:forEach>
        </select>
        <br>
        <button>Save</button>
    </form>
</body>
</html>
