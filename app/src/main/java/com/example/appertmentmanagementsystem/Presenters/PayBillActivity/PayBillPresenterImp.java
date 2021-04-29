package com.example.appertmentmanagementsystem.Presenters.PayBillActivityPresenter;

import com.example.appertmentmanagementsystem.Views.PayBill.PayBillActivityView;
import com.example.appertmentmanagementsystem.models.Paybillmodel;
import com.example.appertmentmanagementsystem.models.Response;

public class PayBillPresenterImp implements PaybillPresenter{

    PayBillActivityView payBillActivityView;

    public PayBillPresenterImp(PayBillActivityView payBillActivityView) {
        this.payBillActivityView = payBillActivityView;
    }

    @Override
    public void sendBill(Paybillmodel paybillmodel) {
        //get model and send to server


        //give response to UI
        Response response = new Response(true,"Bill Paid");
        payBillActivityView.getResponse(response);

    }
}
