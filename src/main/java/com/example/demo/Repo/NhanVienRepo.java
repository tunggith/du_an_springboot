package com.example.demo.Repo;

import com.example.demo.Entity.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NhanVienRepo extends JpaRepository<NhanVien,Long> {
}
