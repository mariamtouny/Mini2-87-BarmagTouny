package com.example.miniapp.repositories;

import com.example.miniapp.models.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

    List<Payment> findByTripId(Long tripId);

    @Query("SELECT p FROM Payment p WHERE p.amount > :threshold")
    List<Payment> findByAmountGreaterThan(@Param("threshold") Double threshold);
}
