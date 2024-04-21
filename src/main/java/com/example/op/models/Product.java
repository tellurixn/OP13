package com.example.op.models;

public class Product {
    private String name;
    private double cost;
    private int code;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public Product(String name,int code, double cost){
        this.name = name;
        this.code = code;
        this.cost = cost;
    }
}
