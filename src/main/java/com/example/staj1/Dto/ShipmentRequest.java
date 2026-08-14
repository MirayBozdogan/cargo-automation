package com.example.staj1.Dto;
import com.example.staj1.config.StrictIntegerDeserializer;
import com.example.staj1.config.StrictStringDeserializer;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import tools.jackson.databind.annotation.JsonDeserialize;

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

    @JsonDeserialize(using = StrictIntegerDeserializer.class)
    private Integer senderId;

    @JsonDeserialize(using = StrictIntegerDeserializer.class)
    private Integer receiverId;

    @JsonDeserialize(using = StrictIntegerDeserializer.class)
    private Integer senderAddressId;

    @JsonDeserialize(using = StrictIntegerDeserializer.class)
    private Integer receiverAddressId;

    @JsonDeserialize(using = StrictStringDeserializer.class)
    private String senderName;
    @JsonDeserialize(using = StrictStringDeserializer.class)
    private String senderSurname;
    @JsonDeserialize(using = StrictStringDeserializer.class)
    private String senderCity;
    @JsonDeserialize(using = StrictStringDeserializer.class)
    private String senderDistrict;
    @JsonDeserialize(using = StrictStringDeserializer.class)
    private String senderAddressText;

    @JsonDeserialize(using = StrictStringDeserializer.class)
    private String receiverName;
    @JsonDeserialize(using = StrictStringDeserializer.class)
    private String receiverSurname;
    @JsonDeserialize(using = StrictStringDeserializer.class)
    private String receiverCity;
    @JsonDeserialize(using = StrictStringDeserializer.class)
    private String receiverDistrict;
    @JsonDeserialize(using = StrictStringDeserializer.class)
    private String receiverAddressText;

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

    public Integer getSenderId() {
        return senderId;
    }

    public void setSenderId(Integer senderId) {
        this.senderId = senderId;
    }

    public Integer getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Integer receiverId) {
        this.receiverId = receiverId;
    }

    public Integer getSenderAddressId() {
        return senderAddressId;
    }

    public void setSenderAddressId(Integer senderAddressId) {
        this.senderAddressId = senderAddressId;
    }

    public Integer getReceiverAddressId() {
        return receiverAddressId;
    }

    public void setReceiverAddressId(Integer receiverAddressId) {
        this.receiverAddressId = receiverAddressId;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getSenderSurname() {
        return senderSurname;
    }

    public void setSenderSurname(String senderSurname) {
        this.senderSurname = senderSurname;
    }

    public String getSenderCity() {
        return senderCity;
    }

    public void setSenderCity(String senderCity) {
        this.senderCity = senderCity;
    }

    public String getSenderDistrict() {
        return senderDistrict;
    }

    public void setSenderDistrict(String senderDistrict) {
        this.senderDistrict = senderDistrict;
    }

    public String getSenderAddressText() {
        return senderAddressText;
    }

    public void setSenderAddressText(String senderAddressText) {
        this.senderAddressText = senderAddressText;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getReceiverSurname() {
        return receiverSurname;
    }

    public void setReceiverSurname(String receiverSurname) {
        this.receiverSurname = receiverSurname;
    }

    public String getReceiverCity() {
        return receiverCity;
    }

    public void setReceiverCity(String receiverCity) {
        this.receiverCity = receiverCity;
    }

    public String getReceiverDistrict() {
        return receiverDistrict;
    }

    public void setReceiverDistrict(String receiverDistrict) {
        this.receiverDistrict = receiverDistrict;
    }

    public String getReceiverAddressText() {
        return receiverAddressText;
    }

    public void setReceiverAddressText(String receiverAddressText) {
        this.receiverAddressText = receiverAddressText;
    }

}
