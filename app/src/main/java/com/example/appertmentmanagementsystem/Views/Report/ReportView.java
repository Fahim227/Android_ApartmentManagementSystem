package com.example.appertmentmanagementsystem.Views.Report;

import com.example.appertmentmanagementsystem.models.Response;

public interface ReportView {

    void getResponse(Response response);

    String getUserId();

    void showUserIDError(int resID);

    String get_title();

    void showTitleError(int resId);

    String getHomeAddress();

    void showHomeAddressError(int resId);

    String getPoliceStation();

    void showPoliceStationError(int resId);

    String getDescription();

    void showDescriptionError(int resId);


}
