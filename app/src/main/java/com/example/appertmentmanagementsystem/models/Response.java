package com.example.appertmentmanagementsystem.models;

public class Response {
    boolean response;
    String message;
    String userid;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public Response(boolean response, String message) {
        this.response = response;
        this.message = message;
    }

    public boolean getResponse() {
        return response;
    }

    public void setResponse(boolean response) {
        this.response = response;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
