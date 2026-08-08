package com.example.staj1.Dto;

public class CityRequest {

    private String name;

    public CityRequest() {
    }

    public CityRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}