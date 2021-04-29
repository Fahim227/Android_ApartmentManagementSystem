package com.example.appertmentmanagementsystem.Views.ApartmentDetails;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.appertmentmanagementsystem.Views.ApartmentDetails.Fragments.BookFragment;
import com.example.appertmentmanagementsystem.Views.ApartmentDetails.Fragments.DetailsFragment;
import com.example.appertmentmanagementsystem.Presenters.ApartmnetDetails.ApartmentDetailsPresenterImp;
import com.example.appertmentmanagementsystem.R;
import com.example.appertmentmanagementsystem.Views.ApartmentDetails.ApartmentDetailsView;
import com.example.appertmentmanagementsystem.models.Apartmentmodel;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ApartmentDetails extends AppCompatActivity implements ApartmentDetailsView, BottomNavigationView.OnNavigationItemSelectedListener {

    ApartmentDetailsPresenterImp presenter;
    private BottomNavigationView bottomNavigationViewo;
    public static String dstr;
    public static int img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apartment_details);

        bottomNavigationViewo = findViewById(R.id.bottomnavigationbarID);
        bottomNavigationViewo.setOnNavigationItemSelectedListener(this);
        dstr = getIntent().getStringExtra("details");
        img = getIntent().getIntExtra("img",R.drawable.size);
        getSupportFragmentManager().beginTransaction().add(R.id.containerID,new DetailsFragment()).commit();
        presenter = new ApartmentDetailsPresenterImp(this);
        presenter.getApartmentDetails(1);
    }


    @Override
    public void showApartmentData(Apartmentmodel a) {
        Log.d("Wrking","activty");

        Toast.makeText(this,a.getPrice(),Toast.LENGTH_SHORT).show();
        Toast.makeText(this,"Hello",Toast.LENGTH_LONG).show();


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;
        switch (item.getItemId()){
            case R.id.detailsID:
                fragment = new DetailsFragment();
                break;
            case R.id.bookID:
                fragment = new BookFragment();
                break;
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.containerID,fragment).commit();
        return true;
    }
}