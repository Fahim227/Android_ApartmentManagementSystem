package com.example.appertmentmanagementsystem.models;

public class ReportModel {
    String report_id;
    String user_id ;
    String title;
    String description ;
    String home_address ;
    String police_station;

    public ReportModel(String report_id, String user_id, String title, String description, String home_address, String police_station) {
        this.report_id = report_id;
        this.user_id = user_id;
        this.title = title;
        this.description = description;
        this.home_address = home_address;
        this.police_station = police_station;
    }

    public ReportModel(String user_id, String title, String description, String home_address, String police_station) {
        this.user_id = user_id;
        this.title = title;
        this.description = description;
        this.home_address = home_address;
        this.police_station = police_station;
    }

    public String getReport_id() {
        return report_id;
    }

    public void setReport_id(String report_id) {
        this.report_id = report_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHome_address() {
        return home_address;
    }

    public void setHome_address(String home_address) {
        this.home_address = home_address;
    }

    public String getPolice_station() {
        return police_station;
    }

    public void setPolice_station(String police_station) {
        this.police_station = police_station;
    }
}
