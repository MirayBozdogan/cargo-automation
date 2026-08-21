package com.example.staj1.repository;

import com.example.staj1.model.Shipment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ShipmentRepository extends JpaRepository<Shipment, Integer> {

    Optional<Shipment> findByBarcode(String barcode);

    boolean existsByBarcode(String barcode);

    Page<Shipment> findBySender_IdOrReceiver_Id(
            Integer senderId,
            Integer receiverId,
            Pageable pageable
    );
}