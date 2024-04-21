package com.example.op.models;

public class FinalSumData {
    private String label;
    private double sum;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public FinalSumData(){
        label = "Итого";
        sum = 0;
    }
}
