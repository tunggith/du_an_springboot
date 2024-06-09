package com.example.demo.Repo;

import com.example.demo.Entity.ChiTietSP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChiTietSanPhamRepo extends JpaRepository<ChiTietSP,Long> {
}
