package com.example.staj1.Dto;

public class CustomerDetail {

    private Integer id;
    private Integer age;
    private String tc;


    public CustomerDetail(Integer id, Integer age, String tc) {
        this.id = id;
        this.age = age;
        this.tc = tc;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {this.id = id;}
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    public String getTc() {return tc;}
    public void setTc(String tc) {this.tc = tc;}
}