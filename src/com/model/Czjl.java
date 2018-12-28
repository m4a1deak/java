package com.model;

import java.util.Date;

public class Czjl {
    private Integer id;
    private Integer sid;
    private double jine;
    private Date times;

    public Czjl() {
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getJine() {
        return this.jine;
    }

    public void setJine(double jine) {
        this.jine = jine;
    }

    public Date getTimes() {
        return this.times;
    }

    public void setTimes(Date times) {
        this.times = times;
    }

    public Integer getSid() {
        return this.sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }
}
