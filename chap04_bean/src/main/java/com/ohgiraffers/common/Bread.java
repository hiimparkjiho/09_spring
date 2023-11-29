package com.ohgiraffers.common;

import java.util.Date;

public class Bread extends Product{
    private Date bakedDate;

    public Bread() {
        super();
    }

    public Bread(String name, int price, Date breakDate) {
        super(name, price);
        this.bakedDate = breakDate;
    }

    public Bread(String name, int price) {
        super(name, price);
    }

    public Date getBreakDate() {
        return bakedDate;
    }

    public void setBreakDate(Date breakDate) {
        this.bakedDate = breakDate;
    }

    @Override
    public String toString() {
        return super.toString() + " " + this.bakedDate;
    }
}
