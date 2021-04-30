package com.example.appertmentmanagementsystem.Presenters.PayBillActivity;

import android.content.Context;
import android.widget.Toast;

import com.example.appertmentmanagementsystem.API.APIClient;
import com.example.appertmentmanagementsystem.Views.PayBill.PayBillActivityView;
import com.example.appertmentmanagementsystem.models.Paybillmodel;
import com.example.appertmentmanagementsystem.models.Response;

import retrofit2.Call;
import retrofit2.Callback;

public class PayBillPresenterImp implements PaybillPresenter{

    PayBillActivityView payBillActivityView;

    public PayBillPresenterImp(PayBillActivityView payBillActivityView) {
        this.payBillActivityView = payBillActivityView;
    }

    @Override
    public void sendBill(Paybillmodel paybillmodel) {
        //get model and send to server

        Call<Response> call = APIClient.getInstance().getApi().paybill(paybillmodel);
        call.enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                if(response.isSuccessful() && response.body() != null){
                    Response res = response.body();
                    if(res.getResponse()){
                        payBillActivityView.getResponse(res);
                    }
                    else{
                        payBillActivityView.getResponse(res);
                    }
                }
                else {
                    Toast.makeText((Context) payBillActivityView,response.message(),Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {
                Toast.makeText((Context)payBillActivityView, t.getLocalizedMessage(),Toast.LENGTH_LONG).show();

            }
        });



        //give response to UI
        Response response = new Response(true,"Bill Paid");
        payBillActivityView.getResponse(response);

    }
}
