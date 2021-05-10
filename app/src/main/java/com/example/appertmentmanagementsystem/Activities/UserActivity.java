package com.example.appertmentmanagementsystem.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.appertmentmanagementsystem.R;
import com.example.appertmentmanagementsystem.Views.AvailableApartments.AvailableApartments;
import com.example.appertmentmanagementsystem.Views.PayBill.PayBillActivity;
import com.example.appertmentmanagementsystem.Views.Profile.ProfileActivity;
import com.example.appertmentmanagementsystem.Views.Report.Report;

public class UserActivity extends AppCompatActivity implements View.OnClickListener {

    private CardView availableflat,paybill,report,emergencycontacts;
    private int userId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        userId=getIntent().getIntExtra("userId",0);

        availableflat = findViewById(R.id.availableflatID);
        paybill = findViewById(R.id.paybillID);
        report = findViewById(R.id.reportID);
        emergencycontacts = findViewById(R.id.emergencylistID);
        availableflat.setOnClickListener(this);
        paybill.setOnClickListener(this);
        report.setOnClickListener(this);
        emergencycontacts.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.useractivitymenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.user_profile_ID){
            //Toast.makeText(getApplicationContext(), "Main action is selected!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, ProfileActivity.class);
            intent.putExtra("userId",userId);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.availableflatID:
                intent =  new Intent(this, AvailableApartments.class);
                startActivity(intent);
                break;
            case R.id.paybillID:
                intent =  new Intent(this, PayBillActivity.class);
                startActivity(intent);
                break;
            case R.id.reportID:
                intent =  new Intent(this, Report.class);
                startActivity(intent);
                break;
            case R.id.emergencyID:
                break;
        }

    }
}