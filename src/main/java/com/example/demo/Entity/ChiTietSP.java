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

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "ChiTietSP")
public class ChiTietSP {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "[IdSP]")
    private SanPham sanPham;
    @ManyToOne
    @JoinColumn(name = "[IdNsx]")
    private NSX nsx;
    @ManyToOne
    @JoinColumn(name = "[IdMauSac]")
    private MauSac mauSac;
    @ManyToOne
    @JoinColumn(name = "[IdDongSP]")
    private DongSP dongSP;


    @Column
    private Integer namBH;

    @Column
    private String moTa;

    @Column
    private Integer soLuongTon;
    @Column
    private Integer giaNhap;
    @Column
    private Integer giaBan;

}
