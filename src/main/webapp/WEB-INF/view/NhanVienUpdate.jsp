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
        <a class="nav-link active" aria-current="page" href="/nhan-vien/hien-thi">Nhân viên</a>
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
<h1 class="text-center">update nhân viên</h1>
<form action="/nhan-vien/update/${nhanVien.id}" method="post">
    <div class="mb-3">
        <label for="maSv" class="form-label">họ</label>
        <input type="text" class="form-control" id="maSv" name="ho" value="${nhanVien.ho}">
    </div>
    <div class="mb-3">
        <label for="maSv" class="form-label">tên đệm</label>
        <input type="text" class="form-control" id="tenDem" name="tenDem" value="${nhanVien.tenDem}">
    </div>
    <div class="mb-3">
        <label for="maSv" class="form-label">tên</label>
        <input type="text" class="form-control" id="ten" name="ten" value="${nhanVien.ten}">
    </div>
    <div class="mb-3">
        <label for="maSv" class="form-label">giới tính</label>
        <div class="form-check">
            <input class="form-check-input" type="radio" name="gioiTinh" id="nam" value="nam"
                   <c:if test="${nhanVien.gioiTinh=='nam'}">checked</c:if>
            >
            <label class="form-check-label" for="nam">
                Nam
            </label>
        </div>
        <div class="form-check">
            <input class="form-check-input" type="radio" name="gioiTinh" id="nu" value="nữ" checked
                   <c:if test="${nhanVien.gioiTinh=='nữ'}">checked</c:if>
            >
            <label class="form-check-label" for="nu">
                Nữ
            </label>
        </div>
    </div>
    <div class="mb-3">
        <label for="maSv" class="form-label">Ngày sinh</label>
        <input type="date" class="form-control" id="ngaySinh" name="ngaySinh" value="${ngaySinh}" pattern="\d{4}-\d{2}-\d{2}">
    </div>
    <div class="mb-3">
        <label for="tenSv" class="form-label">địa chỉ</label>
        <input type="text" class="form-control" id="tenSv" name="diaChi" value="${nhanVien.diaChi}">
    </div>
    <div class="mb-3">
        <label for="tenSv" class="form-label">số điện thoại</label>
        <input type="text" class="form-control" id="sdt" name="sdt" value="${nhanVien.sdt}">
    </div>
    <div class="mb-3">
        <label for="tenSv" class="form-label">cửa hàng</label>
        <select class="form-select" name="cuaHang">
            <c:forEach items="${listCuaHang}" var="ch">
                <option value="${ch.id}"
                        <c:if test="${nhanVien.cuaHang.id==ch.id}">selected</c:if>
                >${ch.ten}</option>
            </c:forEach>
        </select>
    </div>
    <div class="mb-3">
        <label for="tenSv" class="form-label">chức vụ</label>
        <select class="form-select" name="chucVu">
            <c:forEach items="${listChucVu}" var="cv">
                <option value="${cv.id}"
                        <c:if test="${nhanVien.chucVu.id==cv.id}">selected</c:if>
                >${cv.ten}</option>
            </c:forEach>
        </select>
    </div>
    <div class="mb-3">
        <label for="tenSv" class="form-label">trạng thái</label>
        <div class="form-check">
            <input class="form-check-input" type="radio" name="trangThai" id="flexRadioDefault1" value="1"
                   <c:if test="${nhanVien.trangThai==1}">checked</c:if>
            >
            <label class="form-check-label" for="flexRadioDefault1">
                đang làm
            </label>
        </div>
        <div class="form-check">
            <input class="form-check-input" type="radio" name="trangThai" id="flexRadioDefault2" value="0" checked
                   <c:if test="${nhanVien.trangThai==0}">checked</c:if>
            >
            <label class="form-check-label" for="flexRadioDefault2">
                đã nghỉ
            </label>
        </div>
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
</form>
</body>
</html>