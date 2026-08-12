package com.example.staj1.repository;

import com.example.staj1.model.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShipmentRepository extends JpaRepository<Shipment, Integer > {
    Integer id(Integer id);
}
