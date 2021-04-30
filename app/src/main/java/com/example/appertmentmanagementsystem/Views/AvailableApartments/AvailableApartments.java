package com.example.appertmentmanagementsystem.Views.AvailableApartments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.appertmentmanagementsystem.Presenters.AvailableApartments.AvailableApartmentPresenterImp;
import com.example.appertmentmanagementsystem.Views.ApartmentDetails.ApartmentDetails;
import com.example.appertmentmanagementsystem.Adapters.ApartmentAdapter;
import com.example.appertmentmanagementsystem.R;
import com.example.appertmentmanagementsystem.Views.AvailableApartments.AvailableApartmentView;
import com.example.appertmentmanagementsystem.models.Apartmentmodel;

import java.util.ArrayList;
import java.util.List;

public class AvailableApartments extends AppCompatActivity implements AvailableApartmentView {

    private List<Apartmentmodel> apartmentmodelList;
    private RecyclerView apartmentcontainer;
    private ApartmentAdapter apartmentAdapter;
    AvailableApartmentPresenterImp presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_available_apartments);

        apartmentcontainer = findViewById(R.id.apartmentcontainerID);

        presenter = new AvailableApartmentPresenterImp(this);
        presenter.getAvailableFlats();

    }

    @Override
    public void giveFlats(List<Apartmentmodel> apartmentmodelList) {
        Log.d("Not Working","1");
        apartmentAdapter = new ApartmentAdapter(getApplicationContext(),apartmentmodelList);
        Log.d("Not Working","2");
        apartmentcontainer.setAdapter(apartmentAdapter);
        apartmentcontainer.setLayoutManager(new LinearLayoutManager(this));
        Log.d("Not Working","3");
        apartmentAdapter.setOnItemClickListener(new ApartmentAdapter.OnItemClickListener() {
            @Override
            public void onItemClickListener(int position) {
                //Toast.makeText(getApplicationContext(),String.valueOf(position),Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(), ApartmentDetails.class);
                String details = apartmentmodelList.get(position).getBuilding_address()+"\n"
                        +apartmentmodelList.get(position).getBuilding_name()+"\n"
                        +apartmentmodelList.get(position).getBuilding_numb()+"\n"
                        +apartmentmodelList.get(position).getFlat_number()+"\n"
                        +apartmentmodelList.get(position).getFlat_size()+"\n"
                        +apartmentmodelList.get(position).getPrice();
                //int img = apartmentmodelList.get(position).getImg();
                intent.putExtra("details",details);
                //intent.putExtra("img",img);
                startActivity(intent);
            }

        });

    }
}