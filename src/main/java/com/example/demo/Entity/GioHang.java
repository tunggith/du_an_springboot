package com.example.demo.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "GioHang")
public class GioHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "[IdKH]")
    private KhachHang khachHang;

    @ManyToOne
    @JoinColumn(name = "[IdNV]")
    private NhanVien nhanVien;

    @Column
    private String ma;

    @Column
    private Date ngayTao;

    @Column
    private Date ngayThanhToan;


    @Column
    private String tenNguoiNhan;

    @Column
    private String diaChi;
    @Column
    private String sdt;

    @Column
    private Integer tinhTrang;
}