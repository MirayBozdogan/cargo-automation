package com.example.staj1.repository;

import com.example.staj1.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> , JpaSpecificationExecutor<Customer>{
    boolean existsByEmail(String email);
    boolean existsByTc(String tc);
    boolean existsByTelNo(String telNo);
}
    //JpaSpecificationExecutor, repository'ye dinamik filtreleme yapabilme yeteneği veriyor.






