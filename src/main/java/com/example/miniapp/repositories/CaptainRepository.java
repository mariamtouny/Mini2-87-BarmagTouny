package com.example.miniapp.repositories;

import com.example.miniapp.models.Captain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CaptainRepository extends JpaRepository<Captain, Long> {
}
