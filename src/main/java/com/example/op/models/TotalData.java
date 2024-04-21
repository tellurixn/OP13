package com.example.op.models;

public class TotalData {
    private String name;
    private double totalReminderStart;
    private double totalAdded;
    private double totalReminderReceipt;
    private double totalUsed;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTotalReminderStart() {
        return totalReminderStart;
    }

    public void setTotalReminderStart(double totalReminderStart) {
        this.totalReminderStart = totalReminderStart;
    }

    public double getTotalAdded() {
        return totalAdded;
    }

    public void setTotalAdded(double totalAdded) {
        this.totalAdded = totalAdded;
    }

    public double getTotalReminderReceipt() {
        return totalReminderReceipt;
    }

    public void setTotalReminderReceipt(double totalReminderReceipt) {
        this.totalReminderReceipt = totalReminderReceipt;
    }

    public double getTotalUsed() {
        return totalUsed;
    }

    public void setTotalUsed(double totalUsed) {
        this.totalUsed = totalUsed;
    }

    public TotalData(){
        name = "Итого";
        totalAdded = 0;
        totalReminderStart = 0;
        totalReminderReceipt = 0;
        totalUsed = 0;
    }
}
