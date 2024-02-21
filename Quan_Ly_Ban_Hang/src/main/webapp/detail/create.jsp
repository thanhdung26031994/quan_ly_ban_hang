<%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 21/02/2024
  Time: 15:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Thêm mới hoá đơn</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class="container">

    <div class="row justify-content-center mt-4">
        <form class="col-md-6" method="post">
            <div class="form-group">
                <label for="idProduct">Tên sản phẩm</label>
                <select id="idProduct" class="form-control" name="idProduct">
                    <c:forEach items="${product}" var="p">
                        <option value="${p.id}">${p.name}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group">
                <label for="idClient">Tên khách hàng</label>
                <select id="idClient" class="form-control" name="idClient">
                    <c:forEach items="${invoice}" var="i">
                        <option value="${c.id}">${c.client}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group">
                <label for="quantity">Số lượng</label>
                <input type="text" class="form-control" name="quantity" id="quantity">
            </div>
            <div class="form-group mt-2">
                <button class="btn btn-success" role="button" type="submit">Thêm mới</button>
                <a href="/invoice">Quay lại</a>
            </div>
        </form>
    </div>
</div>
</body>
</html>
