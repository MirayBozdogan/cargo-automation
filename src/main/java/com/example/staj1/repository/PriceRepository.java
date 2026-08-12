package com.example.staj1.repository;

import com.example.staj1.model.Price;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;

public interface PriceRepository extends JpaRepository<Price,Integer> {
    Price findByMinDesiLessThanEqualAndMaxDesiGreaterThan(BigDecimal minDesi,BigDecimal maxDesi);
}
