<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

</head>
<body class="container">
<ul class="nav nav-tabs">
    <li class="nav-item">
        <a class="nav-link " aria-current="page" href="/ban-hang/hien-thi">Bán Hàng</a>
    </li>
    <li class="nav-item">
        <a class="nav-link " aria-current="page" href="/ban-hang/lich-su-mua-hang">Lịch sử mua hàng</a>
    </li>
    <li class="nav-item">
        <a class="nav-link " aria-current="page" href="/nhan-vien/hien-thi">Nhân viên</a>
    </li>
    <li class="nav-item">
        <a class="nav-link " aria-current="page" href="/san-pham/hien-thi">sản phẩm</a>
    </li>
    <li class="nav-item">
        <a class="nav-link " aria-current="page" href="/chi-tiet-san-pham/hien-thi">chi tiết sản phẩm</a>
    </li>
    <li class="nav-item">
        <a class="nav-link " aria-current="page" href="/chuc-vu/hien-thi">chức vụ</a>
    </li>
    <li class="nav-item">
        <a class="nav-link " aria-current="page" href="/cua-hang/hien-thi">cửa hàng</a>
    </li>
    <li class="nav-item">
        <a class="nav-link active" aria-current="page" href="/dong-san-pham/hien-thi">Dòng sản phẩm</a>
    </li>
    <li class="nav-item">
        <a class="nav-link " aria-current="page" href="/khach-hang/hien-thi">Khách Hàng</a>
    </li>
    <li class="nav-item">
        <a class="nav-link " aria-current="page" href="/mau-sac/hien-thi">màu sắc</a>
    </li>
    <li class="nav-item">
        <a class="nav-link " aria-current="page" href="/nha-san-xuat/hien-thi">Nhà sản xuất</a>
    </li>
</ul>
<h1 class="text-center">Thêm sản phẩm</h1>
<form action="/dong-san-pham/add" method="post">
    <div class="mb-3">
        <label for="tenDem" class="form-label">mã dòng sản phẩm</label>
        <input type="text" class="form-control" id="tenDem" name="ma" value="${dongSp.ma}">
    </div>
    <div class="mb-3">
        <label for="ten" class="form-label">tên dòng sản phẩm</label>
        <input type="text" class="form-control" id="ten" name="ten" value="${dongSp.ten}">
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
</form>
<h1 class="text-center">Danh sách dòng sản phẩm</h1>
<table class="table">
    <thead>
    <tr>
        <th scope="col">stt</th>
        <th scope="col">id</th>
        <th scope="col">mã dòng sản phẩm</th>
        <th scope="col">tên dòng sản sản phẩm</th>
        <th scope="col">action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listDongSp}" var="sp" varStatus="i">
        <tr>
            <th scope="row">${i.index}</th>
            <td>${sp.id}</td>
            <td>${sp.ma}</td>
            <td>${sp.ten}</td>
            <td>
                <a href="/dong-san-pham/remove/${sp.id}" type="button" class="btn btn-danger">delete</a>
                <a href="/dong-san-pham/detail/${sp.id}" type="button" class="btn btn-info">detail</a>
                <a href="/dong-san-pham/view-update/${sp.id}" type="button" class="btn btn-warning">update</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>

