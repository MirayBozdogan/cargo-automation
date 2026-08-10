package com.example.staj1.Dto;

import com.example.staj1.config.StrictStringDeserializer;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import tools.jackson.databind.annotation.JsonDeserialize;

public class CityRequest {

    private Integer id;

    @NotBlank(message = "Şehir adı boş olamaz.")
    @Size(max = 100, message = "Şehir adı en fazla 100 karakter olabilir.")
    @JsonDeserialize(using = StrictStringDeserializer.class)
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}