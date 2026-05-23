<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lovep
  Date: 5/19/2026
  Time: 1:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    Them sinh vien
    <form action="/sinh-vien/them" method="post">
        Ten: <input type="text" name="ten"> <br>
        Tuoi: <input type="text" name="tuoi"> <br>
        Gioi tinh:
            Nam: <input type="radio" name="gioiTinh" value="false">
            Nu: <input type="radio" name="gioiTinh" value="true">
        <br>
        <button>Them</button>
    </form>
    <br>
    Bang sinh vien
    <table>
        <thead>
            <tr>
                <th>Id</th>
                <th>Ten</th>
                <th>Tuoi</th>
                <th>Gioi tinh</th>
                <th>Hanh dong</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${listSinhVien}" var="sv">
                <tr>
                    <td>${sv.id}</td>
                    <td>${sv.ten}</td>
                    <td>${sv.tuoi}</td>
                    <td>${sv.gioiTinh == "false" ? "Nam" : "Nu"}</td>
                    <td>
                        <a href="/sinh-vien/view-update?id=${sv.id}">View update</a>
                        <a href="/sinh-vien/xoa?id=${sv.id}">Xoa</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
