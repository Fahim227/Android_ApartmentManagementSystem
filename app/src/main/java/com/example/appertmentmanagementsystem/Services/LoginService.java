package com.example.appertmentmanagementsystem.Services;

public class LoginService {
    public boolean login(String username, String password) {
        return "Yes".equals(username) && "Yes".equals(password);
    }
}
