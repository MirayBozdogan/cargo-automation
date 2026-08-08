package com.example.staj1.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String surname;
    @Column(unique = true)
    private String email;
    private Integer age;
    @Column(unique = true)
    private String tc;
    @Column(unique = true)
    private String telNo;
    @JsonIgnore
    @OneToMany(mappedBy = "customer")
    private List<Address> addresses;

    public Customer() {
    }

    public Customer(String name, String surname, String email, Integer age, String tc , String telNo) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.age = age;
        this.tc = tc;
        this.telNo = telNo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {this.id = id;}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {this.surname = surname;}

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getTc() {return tc;}

    public void setTc(String tc) {this.tc = tc;}

    public String getTelNo() {return telNo;}

    public void setTelNo(String telNo) {this.telNo = telNo;}

    @Override
    public String toString() {
        return "Musteri{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", tc=" + tc +
                ",telNo=" + telNo +
                '}';
    }
}
