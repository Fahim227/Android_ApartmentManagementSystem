package com.example.appertmentmanagementsystem.Views.Register;

import com.example.appertmentmanagementsystem.models.Response;

public interface MainActivityView {

    void FeedBack(Response response);

    String getFirstname();

    void showFirstNameError(int resId);

    String getLastName();

    void showLastNameError(int resId);

    String getEmail();

    void showEmailError(int resId);

    void showPhonNumberError(int resId);

    String getPhoneNumer();

    String getPassword();

    void showPasswordError(int resId);

    String getConPassword();

    void showConPasswordError(int resId);


}
