package com.example.manager.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

public class Ph implements Serializable {

    private String id;
    private double ph;
    private Date date;

    public Ph(@JsonProperty("id") String id,
              @JsonProperty("ph") double ph,
              @JsonProperty("date") Date date) {
        this.id = id;
        this.ph = ph;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getPh() {
        return ph;
    }

    public void setPh(double ph) {
        this.ph = ph;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Ph [id=" + this.getId() + ", degree=" + this.getPh() + "]";
    }
}
