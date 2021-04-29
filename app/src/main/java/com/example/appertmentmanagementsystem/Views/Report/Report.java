package com.example.appertmentmanagementsystem.Views.Report;

import androidx.appcompat.app.AppCompatActivity;

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

        userid = findViewById(R.id.flatnumID);
        title = findViewById(R.id.building_num_ID);
        homeaddress = findViewById(R.id.location_ID);
        policestations = findViewById(R.id.map_address_ID);
        description = findViewById(R.id.flat_size_ID);
        submit = findViewById(R.id.submitID);

        model = new ReportModel(userid.getText().toString(),title.getText().toString(),description.getText().toString(),homeaddress.getText().toString(),policestations.getText().toString());
        submit.setOnClickListener(this);


    }


    @Override
    public void getResponse(Response response) {

        Toast.makeText(getApplicationContext(),response.getMessage(),Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.submitID){
            presenter = new ReportPresenterImp(this);
            presenter.sendReport(model);
        }

    }
}