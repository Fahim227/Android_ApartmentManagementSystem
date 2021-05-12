package com.example.appertmentmanagementsystem.Views.Login;

import com.example.appertmentmanagementsystem.models.Response;

public interface LoginActivityView {
    void getResponse(Response response);

    String getEmail();

    void showEmailError(int resId);

    String getPassword();

    void showPasswordError(int resId);

    void startUserActivity();

    void showLoginError(int resId);

}
