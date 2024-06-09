package com.example.demo.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "KhachHang")
public class KhachHang {

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
    private Date ngaySinh;
    @Column
    private String sdt;
    @Column
    private String diaChi;
    @Column
    private String  thanhPho;
    @Column
    private String quocGia;
    @Column
    private String matKhau;
}
