<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

</head>
<body>
<ul class="nav nav-tabs">
    <li class="nav-item">
        <a class="nav-link active" aria-current="page" href="/ban-hang/hien-thi">Bán Hàng</a>
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
<div class="row">
    <div class="col-7">
        <h2>Danh sách hoá đơn</h2>
        <table class="table">
            <thead>
            <tr>
                <td>STT</td>
                <td>Ten khach hang</td>
                <td>Tên nhân viên</td>
                <td>Ngay tao</td>
                <td>Trang Thai</td>
                <td>Action</td>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${hoaDonPage.content}" var="hoaDon" varStatus="i">
            <tr>
                <td>${i.index}</td>
                <td>${hoaDon.khachHang.ho} ${hoaDon.khachHang.tenDem} ${hoaDon.khachHang.ten}</td>
                <td>${hoaDon.nhanVien.ho} ${hoaDon.nhanVien.tenDem} ${hoaDon.nhanVien.ten}</td>
                <td>${hoaDon.ngayTao}</td>
                <td>
                    <c:if test="${hoaDon.tinhTrang==1}">chưa thanh toán</c:if>
                </td>
                <td>
                    <a href="/ban-hang/chon-hoa-don/${hoaDon.id}" type="button" class="btn btn-primary">chọn</a>
                </td>
                </c:forEach>
            </tbody>
        </table>
        <nav aria-label="Page navigation example">
            <ul class="pagination">
                <li class="page-item"><a class="page-link" href="/ban-hang/hien-thi?page=${currentPage-1}">Previous</a>
                </li>
                <c:forEach var="i" begin="0" end="${totalPages-1}">
                    <li class="page-item <c:if test="${i==currentPage}">active</c:if>">
                        <a class="page-link" href="/ban-hang/hien-thi?page=${i}">${i+1}</a>
                    </li>
                </c:forEach>
                <li class="page-item"><a class="page-link" href="/ban-hang/hien-thi?page=${currentPage+1}">Next</a></li>
            </ul>
        </nav>
        <h2>Giỏ hàng</h2>
        <table class="table">
            <thead>
            <tr>
                <td>STT</td>
                <td>ID</td>
                <td>id hóa đơn</td>
                <td>tên sản phẩm</td>
                <td>số lượng</td>
                <td>Đơn giá</td>
                <td>action</td>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${listHoaDonCt.content}" var="hdct" varStatus="i">
                <tr>

                    <td>${i.index}</td>
                    <td>${hdct.id}</td>
                    <td>${hdct.hoaDon.id}</td>
                    <td>${hdct.chiTietSP.sanPham.ten}</td>
                    <td>${hdct.soLuong}</td>
                    <td>${hdct.donGia}</td>
                    <td>
                        <a onclick="return confirm('bạn có muốn xóa không ?')"
                           href="/ban-hang/remove/${hdct.id}?idHd=${hd.id}"
                           type="button" class="btn btn-danger">xóa</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <nav aria-label="Page navigation example">
            <ul class="pagination">
                <li class="page-item"><a class="page-link"
                                         href="/ban-hang/chon-hoa-don/${hd.id}?pageC=${currentPageC-1}">Previous</a>
                </li>
                <c:forEach var="i" begin="0" end="${totalPagesC}">
                    <li class="page-item <c:if test="${i==currentPageC}">active</c:if>">
                        <a class="page-link" href="/ban-hang/chon-hoa-don/${hd.id}?pageC=${i}">${i+1}</a>
                    </li>
                </c:forEach>
                <li class="page-item"><a class="page-link"
                                         href="/ban-hang/chon-hoa-don/${hd.id}?pageC=${currentPageC+1}">Next</a></li>
            </ul>
        </nav>

    </div>
    <div class="col-5">
        <h2>Tạo hoá đơn</h2>
        <div class="row">
            <form action="/ban-hang/tao-hoa-don" method="post">
                <div>
                    <label class="col-3" name="nhanVien" value="3">Hà Thanh Tùng</label>
                    <a href="/logout" type="button" class="btn btn-warning">đăng xuất</a>
                </div>
                <div class="mb-3">
                    <label class="col-3">Ten Khach hang</label>
                    <select class="form-select" name="khachHang">
                        <c:forEach items="${listKh}" var="kh">
                            <option value="${kh.id}"
                                    <c:if test="${khS.id==kh.id}">selected</c:if>
                            >${kh.ho} ${kh.tenDem} ${kh.ten}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="mb-3">
                    <label class="col-3">ID Hoa don</label>
                    <input type="text" class="col-7" name="id" value="${hd.id}" readonly>
                </div>
                <div class="mb-3">
                    <label class="col-3">Tong tien</label>
                    <input type="text" class="col-7" value="${tong}" readonly>
                </div>
                <div>
                    <button type="submit" class="btn btn-primary">Tạo hoá
                        đơn
                    </button>
                    <a onclick="return confirm('vui lòng xác nhận thanh toán?')" href="/ban-hang/thanhToan/${hd.id}"
                       type="button" class="btn btn-primary">Thanh toán</a>
                </div>
            </form>
        </div>

    </div>
</div>
<div>
    <h2>Danh sách chi tiết sản phẩm</h2>
    <table class="table">
        <thead>
        <tr>
            <td>STT</td>
            <td>ID CTSP</td>
            <td>Ten san pham</td>
            <td>màu sắc</td>
            <td>nhà sản xuất</td>
            <td>dòng sản phẩm</td>
            <td>năm bảo hành</td>
            <td>mô tả</td>
            <td>số lượng tồn</td>
            <td>giá nhập</td>
            <td>giá bán</td>
            <td>Chuc nang</td>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${listChiTietSanPham.content}" var="ctsp" varStatus="i">
            <tr>
                <td>${i.index}</td>
                <td>${ctsp.id}</td>
                <td>${ctsp.sanPham.ten}</td>
                <td>${ctsp.mauSac.ten}</td>
                <td>${ctsp.nsx.ten}</td>
                <td>${ctsp.dongSP.ten}</td>
                <td>${ctsp.namBH}</td>
                <td>${ctsp.moTa}</td>
                <td>${ctsp.soLuongTon}</td>
                <td>${ctsp.giaNhap}</td>
                <td>${ctsp.giaBan}</td>
                <td>
                    <a href="/ban-hang/chon-san-pham/${ctsp.id}?idHd=${hd.id}" type="button" class="btn btn-primary">Chọn
                        mua</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <nav aria-label="Page navigation example">
        <ul class="pagination">
            <li class="page-item"><a class="page-link" href="/ban-hang/hien-thi?pageS=${listChiTietSanPham.number-1}">Previous</a>
            </li>
            <c:forEach var="i" begin="0" end="${listChiTietSanPham.numberOfElements-1}">
                <li class="page-item <c:if test="${i==listChiTietSanPham.number}">active</c:if>">
                    <a class="page-link" href="/ban-hang/hien-thi?pageS=${i}">${i+1}</a>
                </li>
            </c:forEach>
            <li class="page-item"><a class="page-link" href="/ban-hang/hien-thi?pageS=${listChiTietSanPham.number+1}">Next</a>
            </li>
        </ul>
    </nav>
</div>
</body>
</html>