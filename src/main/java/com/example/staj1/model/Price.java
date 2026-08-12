package com.example.staj1.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "prices")
public class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private BigDecimal maxDesi;
    private BigDecimal minDesi;
    private BigDecimal price;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getMaxDesi() {
        return maxDesi;
    }

    public void setMaxDesi(BigDecimal maxDesi) {
        this.maxDesi = maxDesi;
    }

    public BigDecimal getMinDesi() {
        return minDesi;
    }

    public void setMinDesi(BigDecimal minDesi) {
        this.minDesi = minDesi;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
