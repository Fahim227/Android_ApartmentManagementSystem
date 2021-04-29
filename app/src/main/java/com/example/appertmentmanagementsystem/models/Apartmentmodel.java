package com.example.appertmentmanagementsystem.models;

public class Apartmentmodel {
    int img;
    String flat_number;
    String building_name;
    String building_numb;
    String building_address;
    String flat_size;
    String num_of_beds;
    String num_of_toilet;
    String price ;
    String num_of_balcony;
    String map_address ;
    String location ;


    public Apartmentmodel(int img, String flat_number, String building_name, String building_numb, String building_address, String flat_size, String num_of_beds, String num_of_toilet, String num_of_balcony, String map_address, String location) {
        this.flat_number = flat_number;
        this.building_name = building_name;
        this.building_numb = building_numb;
        this.building_address = building_address;
        this.flat_size = flat_size;
        this.num_of_beds = num_of_beds;
        this.num_of_toilet = num_of_toilet;
        this.num_of_balcony = num_of_balcony;
        this.map_address = map_address;
        this.location = location;
        this.img = img;
    }

    public Apartmentmodel() {
    }

    public Apartmentmodel(int img, String flat_size, String num_of_beds, String num_of_toilet, String num_of_balcony, String price) {
        this.flat_size = flat_size;
        this.num_of_beds = num_of_beds;
        this.num_of_toilet = num_of_toilet;
        this.num_of_balcony = num_of_balcony;
        this.price = price;
        this.img = img;

    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getFlat_number() {
        return flat_number;
    }

    public void setFlat_number(String flat_number) {
        this.flat_number = flat_number;
    }

    public String getBuilding_name() {
        return building_name;
    }

    public void setBuilding_name(String building_name) {
        this.building_name = building_name;
    }

    public String getBuilding_numb() {
        return building_numb;
    }

    public void setBuilding_numb(String building_numb) {
        this.building_numb = building_numb;
    }

    public String getBuilding_address() {
        return building_address;
    }

    public void setBuilding_address(String building_address) {
        this.building_address = building_address;
    }

    public String getFlat_size() {
        return flat_size;
    }

    public void setFlat_size(String flat_size) {
        this.flat_size = flat_size;
    }

    public String getNum_of_beds() {
        return num_of_beds;
    }

    public void setNum_of_beds(String num_of_beds) {
        this.num_of_beds = num_of_beds;
    }

    public String getNum_of_toilet() {
        return num_of_toilet;
    }

    public void setNum_of_toilet(String num_of_toilet) {
        this.num_of_toilet = num_of_toilet;
    }

    public String getNum_of_balcony() {
        return num_of_balcony;
    }

    public void setNum_of_balcony(String num_of_balcony) {
        this.num_of_balcony = num_of_balcony;
    }

    public String getMap_address() {
        return map_address;
    }

    public void setMap_address(String map_address) {
        this.map_address = map_address;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
