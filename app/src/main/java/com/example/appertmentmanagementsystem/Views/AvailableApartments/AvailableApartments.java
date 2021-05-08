package com.example.appertmentmanagementsystem.Views.AvailableApartments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import com.example.appertmentmanagementsystem.API.APIClient;
import com.example.appertmentmanagementsystem.Presenters.AvailableApartments.AvailableApartmentPresenterImp;
import com.example.appertmentmanagementsystem.Views.ApartmentDetails.ApartmentDetails;
import com.example.appertmentmanagementsystem.Adapters.ApartmentAdapter;
import com.example.appertmentmanagementsystem.R;
import com.example.appertmentmanagementsystem.Views.AvailableApartments.AvailableApartmentView;
import com.example.appertmentmanagementsystem.models.Apartmentmodel;

import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class AvailableApartments extends AppCompatActivity implements AvailableApartmentView {

    private List<Apartmentmodel> apartmentmodelList;
    private RecyclerView apartmentcontainer;
    private ApartmentAdapter apartmentAdapter;
    private ArrayAdapter locationsarrayAdapter;
    private AutoCompleteTextView autoCompleteTextView;
    private
    AvailableApartmentPresenterImp presenter;

    @Override
    protected void onResume() {
        super.onResume();
        String[] listOfLocations = getResources().getStringArray(R.array.dropdownText);
        locationsarrayAdapter = new ArrayAdapter(getApplicationContext(),R.layout.dropdown_text, listOfLocations);
        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),listOfLocations[position],Toast.LENGTH_LONG).show();
                presenter.getFlatsByLocation(listOfLocations[position]);
            }
        });
        autoCompleteTextView.setAdapter(locationsarrayAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_available_apartments);

        apartmentcontainer = findViewById(R.id.apartmentcontainerID);
        autoCompleteTextView = findViewById(R.id.autoCompleteTextView);

        presenter = new AvailableApartmentPresenterImp(this);
        presenter.getAvailableFlats();


    }

    @Override
    public void setFlats(List<Apartmentmodel> apartmentmodelList) {
        Log.d("Not Working","1");
        apartmentAdapter = new ApartmentAdapter(getApplicationContext(),apartmentmodelList);
        Log.d("Not Working","2");
        apartmentcontainer.setAdapter(apartmentAdapter);
        apartmentAdapter.notifyDataSetChanged();
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
                intent.putExtra("imgurl", APIClient.ipUrl+apartmentmodelList.get(position).getImg());
                //intent.putExtra("img",img);
                startActivity(intent);
            }

        });

    }
}