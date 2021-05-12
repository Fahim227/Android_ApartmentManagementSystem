package com.example.appertmentmanagementsystem.Presenters.Report;

import android.content.Context;
import android.widget.Toast;

import com.example.appertmentmanagementsystem.API.APIClient;
import com.example.appertmentmanagementsystem.R;
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
    public void sendReport() {
        //send Report to server
        //Toast.makeText((Context)reportView, report.getDescription(),Toast.LENGTH_LONG).show();
        String userId = reportView.getUserId();
        if(userId.isEmpty()){
            reportView.showUserIDError(R.string.userID_error);
            return;
        }
        String title = reportView.get_title();
        if(title.isEmpty()){
            reportView.showTitleError(R.string.title_error);
            return;
        }
        String home = reportView.getHomeAddress();
        if(home.isEmpty()){
            reportView.showHomeAddressError(R.string.home_error);
            return;
        }
        String policeStation = reportView.getPoliceStation();
        if(policeStation.isEmpty()){
            reportView.showPoliceStationError(R.string.station_error);
            return;
        }
        String description = reportView.getDescription();
        if(description.length()<200){
            reportView.showDescriptionError(R.string.description_error);
            return;         
        }

        ReportModel report = new ReportModel(userId,title,description,home,policeStation);
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
