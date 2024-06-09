package com.example.demo.Repo;

import com.example.demo.Entity.HoaDon;
import com.example.demo.Entity.HoaDonChiTiet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HoaDonCtRepo extends JpaRepository<HoaDonChiTiet,Long> {
    @Query("select ct from  HoaDonChiTiet  ct where ct.hoaDon.id = ?1 ")
    Page<HoaDonChiTiet> findHoaDonChiTietByHoaDon(Long id, Pageable pageable);
    List<HoaDonChiTiet> findByHoaDon_Id(Long id);
}
