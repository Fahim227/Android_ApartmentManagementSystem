package com.example.appertmentmanagementsystem.Views.Report;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.appertmentmanagementsystem.Presenters.Report.ReportPresenterImp;
import com.example.appertmentmanagementsystem.R;
import com.example.appertmentmanagementsystem.Views.Report.ReportView;
import com.example.appertmentmanagementsystem.models.ReportModel;
import com.example.appertmentmanagementsystem.models.Response;

public class Report extends AppCompatActivity implements ReportView, View.OnClickListener {

    ReportPresenterImp presenter;
    private EditText userid,title,homeaddress,policestations,description;
    private Button submit;
    ReportModel model;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        userid = findViewById(R.id.reportuserid);
        title = findViewById(R.id.reporttitleid);
        homeaddress = findViewById(R.id.reportlocationid);
        policestations = findViewById(R.id.reportpolicestationid);
        description = findViewById(R.id.reportdescriptionid);
        submit = findViewById(R.id.reportsubmitid);
        submit.setOnClickListener(this);


    }


    @Override
    public void getResponse(Response response) {

        Toast.makeText(getApplicationContext(),response.getMessage(),Toast.LENGTH_SHORT).show();

    }

    @Override
    public String getUserId() {
        return userid.getText().toString();
    }

    @Override
    public void showUserIDError(int resID) {
        userid.setError(getString(resID));
    }

    @Override
    public String get_title() {
        return title.getText().toString();
    }

    @Override
    public void showTitleError(int resId) {
        title.setError(getString(resId));
    }

    @Override
    public String getHomeAddress() {
        return homeaddress.getText().toString();
    }

    @Override
    public void showHomeAddressError(int resId) {
        homeaddress.setError(getString(resId));
    }

    @Override
    public String getPoliceStation() {
        return policestations.getText().toString();
    }

    @Override
    public void showPoliceStationError(int resId) {
        policestations.setError(getString(resId));
    }

    @Override
    public String getDescription() {
        return description.getText().toString();
    }

    @Override
    public void showDescriptionError(int resId) {
        description.setError(getString(resId));
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.reportsubmitid){
            model = new ReportModel(userid.getText().toString(),title.getText().toString(),description.getText().toString(),homeaddress.getText().toString(),policestations.getText().toString());
            Toast.makeText(getApplicationContext(), model.getDescription(),Toast.LENGTH_SHORT).show();
            presenter = new ReportPresenterImp(this);
            presenter.sendReport();
        }

    }
}