package com.example.appertmentmanagementsystem.Presenters.Report;

import android.content.Context;
import android.widget.Toast;

import com.example.appertmentmanagementsystem.API.APIClient;
import com.example.appertmentmanagementsystem.Views.Report.ReportView;
import com.example.appertmentmanagementsystem.models.ReportModel;
import com.example.appertmentmanagementsystem.models.Response;

import retrofit2.Call;
import retrofit2.Callback;

public class ReportPresenterImp implements ReportPresenter{

    ReportView reportView;

    public ReportPresenterImp(ReportView reportView) {
        this.reportView = reportView;
    }

    @Override
    public void sendReport(ReportModel report) {
        //send Report to server
        //Toast.makeText((Context)reportView, report.getDescription(),Toast.LENGTH_LONG).show();
        Call<Response> call = APIClient.getInstance().getApi().postReport(report);
        call.enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                if(response.isSuccessful() && response.body() != null){
                    Response res = response.body();
                    if(res.getResponse()){
                        reportView.getResponse(res);
                    }
                    else{
                        reportView.getResponse(res);
                    }
                }
                else {
                    Toast.makeText((Context) reportView,response.message(),Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {
                Toast.makeText((Context)reportView, t.getLocalizedMessage(),Toast.LENGTH_LONG).show();

            }
        });

        //get Response from server
        /*Response response = new Response(true,"Report Sent");
        reportView.getResponse(response);*/


    }
}
