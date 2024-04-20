package com.example.op.models;

import java.time.LocalDate;


public class tableData {
    private String name;
    private int code;
    private LocalDate reminderStart;
    private double added;
    private LocalDate reminderReceipt;
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

    public LocalDate getReminderStart() {
        return reminderStart;
    }

    public void setReminderStart(LocalDate reminderStart) {
        this.reminderStart = reminderStart;
    }

    public double getAdded() {
        return added;
    }

    public void setAdded(double added) {
        this.added = added;
    }

    public LocalDate getReminderReceipt() {
        return reminderReceipt;
    }

    public void setReminderReceipt(LocalDate reminderReceipt) {
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

    public tableData(){
        this.name = "";
        this.added = 0f;
        this.reminderReceipt = LocalDate.now();
        this.reminderStart =  LocalDate.now();
        this.code = 0;
        this.used = 0f;
    }

    public tableData(
            String name,
            int code,
            LocalDate reminderStart,
            LocalDate reminderReceipt,
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
