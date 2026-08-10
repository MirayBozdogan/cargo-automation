package com.example.staj1.Dto;


import com.example.staj1.config.StrictIntegerDeserializer;
import com.example.staj1.config.StrictStringDeserializer;
import com.example.staj1.model.City;
import com.example.staj1.model.District;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import tools.jackson.databind.annotation.JsonDeserialize;

public class AddressRequest {
    @NotNull(message = "Şehir ID boş olamaz.")
    @JsonDeserialize(using = StrictIntegerDeserializer.class)
    private Integer cityId;

    @NotNull(message = "İlçe ID boş olamaz.")
    @JsonDeserialize(using = StrictIntegerDeserializer.class)
    private Integer districtId;

    @NotBlank(message = "Mahalle boş olamaz.")
    @Size(max = 100, message = "Mahalle adı en fazla 100 karakter olabilir.")
    @JsonDeserialize(using = StrictStringDeserializer.class)
    private String neighborhood;

    private Integer buildingNo;
    private Integer apartmentNo;

    public AddressRequest() {
    }

    public AddressRequest(Integer cityId, Integer districtId, String neighborhood, Integer buildingNo, Integer apartmentNo) {
        this.cityId = cityId;
        this.districtId = districtId;
        this.neighborhood = neighborhood;
        this.buildingNo = buildingNo;
        this.apartmentNo = apartmentNo;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public Integer getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Integer districtId) {
        this.districtId = districtId;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public Integer getBuildingNo() {
        return buildingNo;
    }

    public void setBuildingNo(Integer buildingNo) {
        this.buildingNo = buildingNo;
    }

    public Integer getApartmentNo() {
        return apartmentNo;
    }

    public void setApartmentNo(Integer apartmentNo) {
        this.apartmentNo = apartmentNo;
    }
}
