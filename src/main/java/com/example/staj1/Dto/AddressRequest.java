package com.example.staj1.Dto;


import com.example.staj1.model.City;
import com.example.staj1.model.District;

public class AddressRequest {
    private Integer cityId;
    private Integer districtId;
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
