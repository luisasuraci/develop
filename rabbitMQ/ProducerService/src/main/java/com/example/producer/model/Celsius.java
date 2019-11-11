package com.example.producer.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Date;

public class Celsius implements Serializable {

    private String id;
    private double degree;
    private Date date;

    public Celsius(@JsonProperty("id") String id,
                   @JsonProperty("degree") double degree,
                   @JsonProperty("date") Date date) {
        this.id = id;
        this.degree = degree;
        this.date = date;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getDegree() {
        return degree;
    }

    public void setDegree(double degree) {
        this.degree = degree;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
