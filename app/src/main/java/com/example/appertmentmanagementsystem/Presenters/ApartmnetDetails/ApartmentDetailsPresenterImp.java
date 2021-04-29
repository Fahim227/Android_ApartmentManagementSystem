package com.example.appertmentmanagementsystem.Presenters.ApartmnetDetails;

import android.util.Log;

import com.example.appertmentmanagementsystem.R;
import com.example.appertmentmanagementsystem.Views.ApartmentDetails.ApartmentDetailsView;
import com.example.appertmentmanagementsystem.models.Apartmentmodel;

public class ApartmentDetailsPresenterImp implements ApartmentDetailsPresenter{

    ApartmentDetailsView view;
    public ApartmentDetailsPresenterImp(ApartmentDetailsView view){
        this.view = view;
    }

    @Override
    public void getApartmentDetails(int id) {
        Log.d("Wrking","presenter");
        //get data from retrofit

        Apartmentmodel a = new Apartmentmodel(R.drawable.homea,"3000","3","2","2","1000000");
        view.showApartmentData(a);



    }
}
