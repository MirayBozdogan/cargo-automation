package com.example.staj1.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

@Entity
@Table(name = "cities")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 100)
    private String name;
    @OneToMany(mappedBy = "city")
    @JsonIgnore
    private List<Address> address;

    public City() {

    }

    public City(Integer city_id, String name) {
        this.id = city_id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer city_id) {
        this.id = city_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Address> getAddress() {
        return address;
    }

    public void setAddresses(List<Address> address) {
        this.address = address;
    }
}
