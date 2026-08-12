package com.example.staj1.Dto;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public class ShipmentRequest {

    @NotNull(message = "En değeri boş olamaz.")
    @Positive(message = "En değeri 0 veya negatif olamaz.")
    private BigDecimal width;


    @NotNull(message = "Boy değeri boş olamaz.")
    @Positive(message = "Boy değeri 0 veya negatif olamaz.")
    private BigDecimal length;


    @NotNull(message = "Yükselik değeri boş olamaz.")
    @Positive(message = "Yükseklik değeri 0 veya negatif olamaz.")
    private BigDecimal height;


    @NotNull(message = "Ağırlık değeri boş olamaz.")
    @Positive(message = "Ağırlık değeri 0 veya negatif olamaz.")
    private BigDecimal weight;

    private Integer customerId;

    public BigDecimal getWidth() {
        return width;
    }

    public void setWidth(BigDecimal width) {
        this.width = width;
    }

    public BigDecimal getLength() {
        return length;
    }

    public void setLength(BigDecimal length) {
        this.length = length;
    }

    public BigDecimal getHeight() {
        return height;
    }

    public void setHeight(BigDecimal height) {
        this.height = height;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }
}
