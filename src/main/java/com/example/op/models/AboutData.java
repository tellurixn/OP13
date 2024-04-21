package com.example.op.models;

public class AboutData {
    private String name;
    private int count;
    private double cost;
    private double sum;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public AboutData(){
        name = "No name";
        cost = 0;
        count = 0;
        sum = 0;
    }

    public AboutData(String name, int count, double cost, double sum){
        this.name = name;
        this.sum = sum;
        this.cost = cost;
        this.count = count;
    }


}

