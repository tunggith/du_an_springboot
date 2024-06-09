package com.example.demo.Repo;

import com.example.demo.Entity.KhachHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KhachHangRepo extends JpaRepository<KhachHang,Long> {
    @Query("select kh from KhachHang  kh where kh.sdt = ?1")
    List<KhachHang> findKhachHangBySdt(String sdt);
}
