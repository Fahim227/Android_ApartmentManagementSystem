package com.example.appertmentmanagementsystem.models;

public class Response {
    boolean response;
    String message;

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
