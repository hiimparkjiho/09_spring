package com.ohgiraffers.common;

import java.util.Date;

public class Bread extends Product{
    private Date bakedDate;

    public Bread() {
        super();
    }

    public Bread(String name, int price, Date bakedDate) {
        super(name, price);
        this.bakedDate = bakedDate;
    }

    public Bread(String name, int price) {
        super(name, price);
    }

    public Date getBreakDate() {
        return bakedDate;
    }

    public void setBreakDate(Date bakedDate) {
        this.bakedDate = bakedDate;
    }

    @Override
    public String toString() {
        return super.toString() + " " + this.bakedDate;
    }
}
