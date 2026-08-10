package com.example.staj1.Dto;

import com.example.staj1.config.StrictIntegerDeserializer;
import com.example.staj1.config.StrictStringDeserializer;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import tools.jackson.databind.annotation.JsonDeserialize;

public class DistrictRequest {

    private Integer id;
    @NotBlank(message = "İlçe adı boş olamaz.")
    @Size(max = 100, message = "İlçe adı en fazla 100 karakter olabilir.")
    @JsonDeserialize(using = StrictStringDeserializer.class)
    private String name;
    @NotNull(message = "Şehir seçilmelidir.")
    @JsonDeserialize(using = StrictIntegerDeserializer.class)
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}