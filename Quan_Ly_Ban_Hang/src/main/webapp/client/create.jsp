<%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 20/02/2024
  Time: 17:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Thêm mới học sinh</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class="container">

    <div class="row justify-content-center mt-4">
        <form class="col-md-6" method="post">
            <h1 class="">Thêm mới khách hàng</h1>

            <div class="form-group">
                <label for="name">Tên khách hàng</label>
                <input type="text" class="form-control" name="name" id="name">
            </div>
            <div class="form-group">
                <label for="phone">Số điện thoại</label>
                <input type="text" class="form-control" name="phone" id="phone">
            </div>
            <div class="form-group">
                <label for="email">Email</label>
                <input type="text" class="form-control" name="email" id="email">
            </div>
            <div class="form-group">
                <label for="address">Địa chỉ</label>
                <input type="text" class="form-control" name="address" id="address">
            </div>
            <div class="form-group mt-2">
                <button class="btn btn-success" role="button" type="submit">Thêm mới</button>
                <button class="btn btn-warning" role="button" type="reset">Xoá hết</button>
                <a href="/client">Quay lại</a>
            </div>
        </form>
    </div>
</div>
</body>
</html>
