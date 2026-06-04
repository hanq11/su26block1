<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lovep
  Date: 5/29/2026
  Time: 3:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    Them bac si:
    <form action="/bac-si/them" method="post">
        Ten bac si: <input type="text" name="tenBacSi"> <br>
        Tuoi: <input type="text" name="tuoi"> <br>
        Gioi tinh:
        Nam: <input type="radio" value="false" name="gioiTinh">
        Nu: <input type="radio" value="true" name="gioiTinh"> <br>
        Benh vien:
        <select name="benhVien">
            <c:forEach items="${listBenhVien}" var="bv">
                <option value="${bv.id}" label="${bv.tenBenhVien}"></option>
            </c:forEach>
        </select>
        <br>
        <button>Save</button>
    </form>
    <br>
    Bang thong tin:
    <table>
        <tr>
            <th>Id</th>
            <th>Ten bac si</th>
            <th>Tuoi</th>
            <th>Gioi tinh</th>
            <th>Ten benh vien</th>
            <th>Dia chi benh vien</th>
            <th>Hanh dong</th>
        </tr>
        <c:forEach items="${listBacSi}" var="bs">
            <tr>
                <td>${bs.id}</td>
                <td>${bs.tenBacSi}</td>
                <td>${bs.tuoi}</td>
                <td>${bs.gioiTinh == "false" ? "Nam" : "Nu"}</td>
                <td>${bs.benhVien.tenBenhVien}</td>
                <td>${bs.benhVien.diaChi}</td>
                <td>
                    <a href="/bac-si/view-update?id=${bs.id}">View update</a>
                    <a href="/bac-si/xoa?id=${bs.id}">Xoa</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
