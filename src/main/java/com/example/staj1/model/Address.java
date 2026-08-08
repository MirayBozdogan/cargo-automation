package com.example.staj1.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "addresses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String neighborhood;
    private Integer buildingNo;
    private Integer apartmentNo;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    @JsonIgnore
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "city_id")

    private City city;

    @ManyToOne
    @JoinColumn(name = "district_id")

    private District district;

    public Address() {
    }

    public Address(Integer id, City city, District district, String neighborhood,
                   Integer apartmentNo, Integer buildingNo, Customer customer) {
        this.id = id;
        this.city = city;
        this.district = district;
        this.neighborhood = neighborhood;
        this.buildingNo = buildingNo;
        this.apartmentNo = apartmentNo;
        this.customer = customer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
