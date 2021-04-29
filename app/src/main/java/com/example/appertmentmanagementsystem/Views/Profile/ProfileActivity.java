package com.example.appertmentmanagementsystem.Views.Profile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.appertmentmanagementsystem.Adapters.ApartmentAdapter;
import com.example.appertmentmanagementsystem.Presenters.ProfileActivity.ProfileActivityPresenterImp;
import com.example.appertmentmanagementsystem.R;
import com.example.appertmentmanagementsystem.Views.AddFlat.AddFlatsActivity;
import com.example.appertmentmanagementsystem.Views.Profile.ProfileView;
import com.example.appertmentmanagementsystem.models.Apartmentmodel;

import java.util.List;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener, ProfileView {

    private Button add;
    private RecyclerView flats;
    ApartmentAdapter apartmentAdapter;
    ProfileActivityPresenterImp presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        add = findViewById(R.id.add_flat_for_rent_id);
        flats = findViewById(R.id.owner_flats_ID);
        presenter = new ProfileActivityPresenterImp(this);
        presenter.getOwnerFlats(1);
        add.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.add_flat_for_rent_id){
            //go to flat registration activity
            Intent intent = new Intent(this, AddFlatsActivity.class);
            startActivity(intent);


        }
    }


    @Override
    public void showOwnerFlats(List<Apartmentmodel> apartmentmodelList) {

        apartmentAdapter = new ApartmentAdapter(getApplicationContext(),apartmentmodelList);
        flats.setAdapter(apartmentAdapter);
        flats.setLayoutManager(new LinearLayoutManager(this));

    }
}