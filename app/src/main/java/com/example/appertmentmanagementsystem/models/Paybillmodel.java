package com.example.appertmentmanagementsystem.models;

public class Paybillmodel {

    public String user_id;
    public String type_of_bill;
    public String bill_number;
    public String paid_amount;
    public String bill_month;


    public Paybillmodel(String user_id, String type_of_bill, String bill_number, String paid_amount, String bill_month) {
        this.user_id = user_id;
        this.type_of_bill = type_of_bill;
        this.bill_number = bill_number;
        this.paid_amount = paid_amount;
        this.bill_month = bill_month;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getType_of_bill() {
        return type_of_bill;
    }

    public void setType_of_bill(String type_of_bill) {
        this.type_of_bill = type_of_bill;
    }

    public String getBill_number() {
        return bill_number;
    }

    public void setBill_number(String bill_number) {
        this.bill_number = bill_number;
    }

    public String getPaid_amount() {
        return paid_amount;
    }

    public void setPaid_amount(String paid_amount) {
        this.paid_amount = paid_amount;
    }

    public String getBill_month() {
        return bill_month;
    }

    public void setBill_month(String bill_month) {
        this.bill_month = bill_month;
    }
}
