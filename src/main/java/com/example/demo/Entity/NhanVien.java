package com.example.demo.Entity;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Value;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "NhanVien")
public class NhanVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String ma;

    @Column
    private String ten;
    @Column
    private String tenDem;
    @Column
    private String ho;
    @Column
    private String gioiTinh;

    @Column
    private Date ngaySinh;
    @Column
    private String diaChi;

    @Column
    private String sdt;
    @Column
    private String matKhau;

    @ManyToOne
    @JoinColumn(name = "[IdCH]")
    private CuaHang cuaHang;
    @ManyToOne
    @JoinColumn(name = "[IdCV]")
    private ChucVu chucVu;
    @Column
    private Integer trangThai;

}