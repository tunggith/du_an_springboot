package com.example.demo.Repo;

import com.example.demo.Entity.DongSP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DongSpRepo extends JpaRepository<DongSP,Long> {

}
