package com.example.staj1.repository;

import com.example.staj1.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Integer> {

    List<Address> findByCustomerId(Integer customer_id);

    boolean existsByCustomerId(Integer customer_id);
}