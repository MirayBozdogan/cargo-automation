package com.example.staj1.Dto;

public class DistrictRequest {

    private String name;
    private Integer cityId;

    public DistrictRequest() {
    }

    public DistrictRequest(String name, Integer cityId) {
        this.name = name;
        this.cityId = cityId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }
}