package com.example.miniapp.repositories;

import com.example.miniapp.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    
    /**
     * Find customers by their email domain
     * @param domain the email domain to search for (e.g., "gmail.com")
     * @return list of customers with emails ending with the specified domain
     */
    @Query("SELECT c FROM Customer c WHERE c.email LIKE %:domain")
    List<Customer> findByEmailDomain(@Param("domain") String domain);
    
    /**
     * Find customers by their phone number prefix
     * @param prefix the phone number prefix to search for
     * @return list of customers with phone numbers starting with the specified prefix
     */
    @Query("SELECT c FROM Customer c WHERE c.phoneNumber LIKE :prefix%")
    List<Customer> findByPhonePrefix(@Param("prefix") String prefix);
}