package com.example.appertmentmanagementsystem.Presenters.PayBillActivity;

import android.content.Context;
import android.widget.Toast;

import com.example.appertmentmanagementsystem.API.APIClient;
import com.example.appertmentmanagementsystem.R;
import com.example.appertmeAddFlattViewntmanagementsystem.Views.PayBill.PayBillActivityView;
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
    public void sendBill() {
        Paybillmodel paybillmodel= null;
        //get model and send to server
        String userId = payBillActivityView.getUserID();
        if(userId.isEmpty()){
            payBillActivityView.showUserIdError(R.string.userID_error);
            return;
        }
        String billtype = payBillActivityView.getBillType();
        if(billtype.isEmpty()){
            payBillActivityView.showBillTypeError(R.string.billtype_error);
            return;
        }
        String billNumber = payBillActivityView.getBillNumber();
        if(billNumber.isEmpty()){
            payBillActivityView.showBillNumberError(R.string.billnumber_error);
            return;
        }
        String amount = payBillActivityView.getBillAmount();
        if(amount.isEmpty()){
            payBillActivityView.showBillAmountError(R.string.amount_error);
            return;
        }
        String month = payBillActivityView.getMonth();
        if(month.isEmpty()){
            payBillActivityView.showMonthError(R.string.month_error);
            return;
        }

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
