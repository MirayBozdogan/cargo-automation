package com.example.staj1.repository;

import com.example.staj1.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    boolean existsByEmail(String email);
    boolean existsByTc(String tc);
    boolean existsByTelNo(String telNo);




}
