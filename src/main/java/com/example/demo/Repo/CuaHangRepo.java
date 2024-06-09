package com.example.demo.Repo;

import com.example.demo.Entity.CuaHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuaHangRepo extends JpaRepository<CuaHang,Long> {
}
