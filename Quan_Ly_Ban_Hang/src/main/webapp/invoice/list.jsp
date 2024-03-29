<%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 21/02/2024
  Time: 02:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Quản Lý Hoá Đơn</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>

<nav data-mdb-navbar-init class="navbar navbar-expand-lg bg-body-tertiary">
    <div class="container-fluid">
        <nav aria-label="breadcrumb">
            <ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="/client">Khách Hàng</a></li>
                <li class="breadcrumb-item"><a href="/product">Sản Phẩm</a></li>
                <li class="breadcrumb-item"><a href="/invoice">Hoá Đơn</a></li>
                <li class="breadcrumb-item"><a href="/detail">Chi Tiết HĐ</a></li>

            </ol>
        </nav>
    </div>
</nav>

<div class="container">
    <h1 class="my-3">Quản Lý Hoá Đơn</h1>
    <div class="row d-flex mx-3">
        <div class="col-8">
            <a class="btn btn-warning" role="button" href="/invoice?action=create">Thêm mới</a>
        </div>
        <div class="col-4">
            <form class="d-flex" role="search" action="#" method="post">
                <input name="action" value="find" hidden="">
                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search" name="country">
                <button class="btn btn-outline-secondary" type="submit">Tìm</button>
            </form>
        </div>
    </div>

    <table class="table table-striped">
        <thead>
        <tr>
            <th scope="col">Stt</th>
            <th scope="col">Tên Khách Hàng</th>
            <th scope="col">Số Điện Thoại</th>
            <th scope="col">Ngày Bán</th>
            <th scope="col">Tổng tiền</th>

            <th scope="col">Chỉnh sửa</th>
            <th scope="col">Xoá</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach var="i" items="${invoice}" >
            <tr>
                <td>${i.id}</td>
                <td>${i.client.name}</td>
                <td>${i.client.phone}</td>
                <td>${i.sale}</td>
                <td>${i.total}</td>
                <td>
                    <a class="btn btn-warning" href="/invoice?action=edit&id=${i.id}" role="button">Chỉnh sửa</a>
                </td>
                <td>
                    <a class="btn btn-warning" href="/invoice?action=delete&id=${i.id}" role="button">Xoá</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
