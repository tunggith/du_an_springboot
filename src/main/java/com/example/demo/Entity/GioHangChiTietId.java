package com.example.demo.Entity;

import java.io.Serializable;
import java.util.Objects;

public class GioHangChiTietId implements Serializable {
    private Long gioHang;
    private Long chiTietSP;

    // Constructors, getters, setters, equals, and hashCode methods
    public GioHangChiTietId() {
    }

    public GioHangChiTietId(Long gioHang, Long chiTietSP) {
        this.gioHang = gioHang;
        this.chiTietSP = chiTietSP;
    }

    public Long getGioHang() {
        return gioHang;
    }

    public void setGioHang(Long gioHang) {
        this.gioHang = gioHang;
    }

    public Long getChiTietSP() {
        return chiTietSP;
    }

    public void setChiTietSP(Long chiTietSP) {
        this.chiTietSP = chiTietSP;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GioHangChiTietId that = (GioHangChiTietId) o;
        return Objects.equals(gioHang, that.gioHang) &&
                Objects.equals(chiTietSP, that.chiTietSP);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gioHang, chiTietSP);
    }
}
