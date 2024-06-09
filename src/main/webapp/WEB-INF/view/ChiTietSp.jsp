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
        <a class="nav-link active" aria-current="page" href="/chi-tiet-san-pham/hien-thi">chi tiết sản phẩm</a>
    </li>
    <li class="nav-item">
        <a class="nav-link " aria-current="page" href="/chuc-vu/hien-thi">chức vụ</a>
    </li>
    <li class="nav-item">
        <a class="nav-link " aria-current="page" href="/cua-hang/hien-thi">cửa hàng</a>
    </li>
    <li class="nav-item">
        <a class="nav-link " aria-current="page" href="/dong-san-pham/hien-thi">Dòng sản phẩm</a>
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
<h1 class="text-center">Thêm sản phẩm chi tiết</h1>
<form action="/chi-tiet-san-pham/add" method="post">
    <div class="mb-3">
        <label  class="form-label">sản phẩm</label>
        <select class="form-select" name="sanPham">
            <c:forEach items="${listSanPham}" var="sp">
                <option value="${sp.id}"
                        <c:if test="${chiTietSP.sanPham.id==sp.id}">selected</c:if>
                >${sp.ten}</option>
            </c:forEach>
        </select>
    </div>
    <div class="mb-3">
        <label  class="form-label">nhà sản xuất</label>
        <select class="form-select" name="nsx">
            <c:forEach items="${listNSX}" var="n">
                <option value="${n.id}"
                        <c:if test="${chiTietSP.nsx.id==n.id}">selected</c:if>
                >${n.ten}</option>
            </c:forEach>
        </select>
    </div>
    <div class="mb-3">
        <label  class="form-label">màu sắc</label>
        <select class="form-select" name="mauSac">
            <c:forEach items="${listMauSac}" var="m">
                <option value="${m.id}"
                        <c:if test="${chiTietSP.mauSac.id==m.id}">selected</c:if>
                >${m.ten}</option>
            </c:forEach>
        </select>
    </div>
    <div class="mb-3">
        <label class="form-label">dòng sản phẩm</label>
        <select class="form-select" name="dongSP">
            <c:forEach items="${listDongSp}" var="d">
                <option value="${d.id}"
                        <c:if test="${chiTietSP.dongSP.id==d.id}">selected</c:if>
                >${d.ten}</option>
            </c:forEach>
        </select>
    </div>
    <div class="mb-3">
        <label for="tenDem" class="form-label">năm bảo hành</label>
        <input type="text" class="form-control" id="tenDem" name="namBH" value="${chiTietSP.namBH}">
    </div>
    <div class="mb-3">
        <label for="ten" class="form-label">mô tả</label>
        <input type="text" class="form-control" id="ten" name="moTa" value="${chiTietSP.moTa}">
    </div>

    <div class="mb-3">
        <label for="ten" class="form-label">số lượng tồn</label>
        <input type="text" class="form-control" id="soLuonTon" name="soLuongTon" value="${chiTietSP.soLuongTon}">
    </div>

    <div class="mb-3">
        <label for="ten" class="form-label">Giá nhập</label>
        <input type="text" class="form-control" id="giaNhap" name="giaNhap" value="${chiTietSP.giaNhap}">
    </div>

    <div class="mb-3">
        <label for="ten" class="form-label">giá bán</label>
        <input type="text" class="form-control" id="giaBan" name="giaBan" value="${chiTietSP.giaBan}">
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
</form>
<h1 class="text-center">Danh sách chi tiết sản phẩm</h1>
<table class="table">
    <thead>
    <tr>
        <th scope="col">stt</th>
        <th scope="col">id</th>
        <th scope="col">tên sản phẩm</th>
        <th scope="col">nhà sản xuất</th>
        <th scope="col">màu sắc</th>
        <th scope="col">dòng sản phẩm</th>
        <th scope="col">năm bảo hành</th>
        <th scope="col">mô tả</th>
        <th scope="col">số lượng tồn</th>
        <th scope="col">giá bán</th>
        <th scope="col">giá nhập</th>
        <th scope="col">action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listChiTietSp}" var="ctsp" varStatus="i">
        <tr>
            <th scope="row">${i.index}</th>
            <td>${ctsp.id}</td>
            <td>${ctsp.sanPham.ten}</td>
            <td>${ctsp.nsx.ten}</td>
            <td>${ctsp.mauSac.ten}</td>
            <td>${ctsp.dongSP.ten}</td>
            <td>${ctsp.namBH}</td>
            <td>${ctsp.moTa}</td>
            <td>${ctsp.soLuongTon}</td>
            <td>${ctsp.giaBan}</td>
            <td>${ctsp.giaNhap}</td>
            <td>
                <a href="/chi-tiet-san-pham/remove/${ctsp.id}" type="button" class="btn btn-danger">delete</a>
                <a href="/chi-tiet-san-pham/detail/${ctsp.id}" type="button" class="btn btn-info">detail</a>
                <a href="/chi-tiet-san-pham/view-update/${ctsp.id}" type="button" class="btn btn-warning">update</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>