package com.example.demo.Repo;

import com.example.demo.Entity.HoaDon;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface HoaDonRepo extends JpaRepository<HoaDon,Long> {
    @Query("select hd from HoaDon hd where hd.tinhTrang = ?1")
    Page<HoaDon> findHoaDonByTrangThai(Integer tinhTrang, Pageable pageable);
}
