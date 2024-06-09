package com.example.demo.Repo;

import com.example.demo.Entity.NSX;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NSXRepo extends JpaRepository<NSX,Long> {
}
