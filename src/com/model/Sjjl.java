package com.model;

import java.util.Date;

public class Sjjl {
    private Integer id;
    private Integer sid;
    private double jine;
    private Date btimes;
    private Date etimes;

    public Sjjl() {
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSid() {
        return this.sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public double getJine() {
        return this.jine;
    }

    public void setJine(double jine) {
        this.jine = jine;
    }

    public Date getBtimes() {
        return this.btimes;
    }

    public void setBtimes(Date btimes) {
        this.btimes = btimes;
    }

    public Date getEtimes() {
        return this.etimes;
    }

    public void setEtimes(Date etimes) {
        this.etimes = etimes;
    }
}
