package com.example.multipledatabaseconfigurationmysql.model;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Document
public class Address {

    @Id
    String name;

    String city;

    String state;

    public Address(String name, String city, String state) {
        this.name = name;
        this.city = city;
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public Address() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
