<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lovep
  Date: 5/20/2026
  Time: 11:23 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    Bang thong tin:
    <table>
        <thead>
            <tr>
                <th>Id</th>
                <th>Ten</th>
                <th>Tuoi</th>
                <th>Gioi tinh</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${listSinhVien}" var="sv">
                <tr>
                    <td>${sv.id}</td>
                    <td>${sv.ten}</td>
                    <td>${sv.tuoi}</td>
                    <td>${sv.gioiTinh}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
