package com.example.appertmentmanagementsystem.Views.AddFlat;

import com.example.appertmentmanagementsystem.models.Response;

public interface AddFlattView {
    void getResponse(Response response);

    String getFlatNumber();

    void showFlatNumberError(int resId);

    String getBuildingNumber();

    void showBuildingNumberError(int resId);

    String getLocation();

    void showLocationError(int resId);

    String getMapAddress();

    void showMapAddressError(int resId);

    String getFlatSize();

    void showFlatSizeError(int resId);

    String getBedNum();

    void showBedNumError(int resId);

    String getBathNum();

    void showBathNumError(int resId);

    String getBelconyNum();

    void showBelconyNumError(int resId);

    String getPrice();

    void showPriceError(int resId);

    String getImg();

    void showImgError(int resId);
}
