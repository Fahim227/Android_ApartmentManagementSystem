package com.example.appertmeAddFlattViewntmanagementsystem.Views.PayBill;

import com.example.appertmentmanagementsystem.models.Response;

public interface PayBillActivityView {
    void getResponse(Response response);

    String getUserID();

    void showUserIdError(int resID);

    String getBillType();

    void showBillTypeError(int resId);

    String getBillNumber();

    void showBillNumberError(int resId);

    String getBillAmount();

    void showBillAmountError(int resId);

    String getMonth();

    void showMonthError(int resId);
}
