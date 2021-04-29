package com.example.appertmentmanagementsystem.Presenters.Report;

import com.example.appertmentmanagementsystem.Views.Report.ReportView;
import com.example.appertmentmanagementsystem.models.ReportModel;
import com.example.appertmentmanagementsystem.models.Response;

public class ReportPresenterImp implements ReportPresenter{

    ReportView reportView;

    public ReportPresenterImp(ReportView reportView) {
        this.reportView = reportView;
    }

    @Override
    public void sendReport(ReportModel report) {
        //send Report to server

        //get Response from server
        Response response = new Response(true,"Report Sent");
        reportView.getResponse(response);


    }
}
