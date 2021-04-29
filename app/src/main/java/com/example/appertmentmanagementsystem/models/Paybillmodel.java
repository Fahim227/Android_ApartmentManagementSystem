package com.example.appertmentmanagementsystem.models;

public class Paybillmodel {

    public String name;
    public String user_id;
    public String BillType;
    public String BillNumber;
    public String Amount;
    public String BillMonth;
    public int img;

    public Paybillmodel(String user_id, String billType, String billNumber, String amount, String billMonth) {
        this.user_id = user_id;
        BillType = billType;
        BillNumber = billNumber;
        Amount = amount;
        BillMonth = billMonth;
    }

    public Paybillmodel(String name, int img) {
        this.name = name;
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
