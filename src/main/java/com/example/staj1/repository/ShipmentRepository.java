package com.example.staj1.repository;

import com.example.staj1.model.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ShipmentRepository extends JpaRepository<Shipment, Integer > {
    Integer id(Integer id);
    Optional<Shipment> findByBarcode(String barcode);
    boolean existsByBarcode(String barcode);
}
