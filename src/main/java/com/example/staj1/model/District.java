package com.example.staj1.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "districts")

public class District {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;
    @OneToMany(mappedBy = "district")
    @JsonIgnore
    private List<Address> address;

    public District() {
    }

    public District(Integer district_id, String name, City city) {
        this.id = district_id;
        this.name = name;
        this.city = city;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer district_id) {
        this.id = district_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public List<Address> getAddress() {
        return address;
    }

    public void setAddresses(List<Address> address) {
        this.address = address;
    }
}
