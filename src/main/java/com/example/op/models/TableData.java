package com.example.op.models;


public class TableData {
    private String name;
    private int code;
    private double reminderStart;
    private double added;
    private double reminderReceipt;
    private double used;
    private int count;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public double getReminderStart() {
        return reminderStart;
    }

    public void setReminderStart(double reminderStart) {
        this.reminderStart = reminderStart;
    }

    public double getAdded() {
        return added;
    }

    public void setAdded(double added) {
        this.added = added;
    }

    public double getReminderReceipt() {
        return reminderReceipt;
    }

    public void setReminderReceipt(double reminderReceipt) {
        this.reminderReceipt = reminderReceipt;
    }

    public double getUsed() {
        return used;
    }

    public void setUsed(double used) {
        this.used = used;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public TableData(){
        this.name = "";
        this.added = 0f;
        this.reminderReceipt = 0f;
        this.reminderStart =  0f;
        this.code = 0;
        this.used = 0f;
    }

    public TableData(
            String name,
            int code,
            double reminderStart,
            double reminderReceipt,
            double added,
            double used
            ){
        this.name = name;
        this.code = code;
        this.reminderStart = reminderStart;
        this.reminderReceipt = reminderReceipt;
        this.added = added;
        this.used = used;
    }
}
