<%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 21/02/2024
  Time: 02:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Chỉnh sửa hoá đơn</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class="container">

    <div class="row justify-content-center mt-4">
        <form class="col-md-6" method="post">
            <h1 class="">Chỉnh sửa hoá đơn</h1>
            <input type="hidden" class="form-control" name="id" id="id" value="${requestScope["invoice"].getId()}">
            <div class="form-group">
                <label for="sale">Ngày Bán</label>
                <input type="text" class="form-control" name="sale" id="sale" value="${requestScope["invoice"].getSale()}">
            </div>

            <div class="form-group">
                <label for="total">Tổng tiền</label>
                <input type="text" class="form-control" name="total" id="total" value="${requestScope["invoice"].getTotal()}">
            </div>
            <div class="form-group">
                <label for="idClient">Tên khách hàng</label>
                <select id="idClient" class="form-control" name="idClient">
                    <c:forEach items="${client}" var="c">
                        <option value="${c.id}">${c.name}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group mt-2">
                <button class="btn btn-success" role="button" type="submit">Lưu thông tin</button>
                <a href="/invoice">Quay lại</a>
            </div>
        </form>
    </div>
</div>
</body>
</html>
