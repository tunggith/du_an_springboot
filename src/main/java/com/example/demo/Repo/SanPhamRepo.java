package com.example.demo.Repo;

import com.example.demo.Entity.SanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SanPhamRepo extends JpaRepository<SanPham,Long> {
}
