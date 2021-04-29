package com.example.appertmentmanagementsystem.Presenters;

import com.example.appertmentmanagementsystem.R;
import com.example.appertmentmanagementsystem.Views.AvailableApartments.AvailableApartmentView;
import com.example.appertmentmanagementsystem.models.Apartmentmodel;

import java.util.ArrayList;
import java.util.List;

public class AvailableApartmentPresenterImp implements AvailableApartmentPresenter{
    AvailableApartmentView availableApartmentView;
    private List<Apartmentmodel> apartmentmodelList;

    public AvailableApartmentPresenterImp(AvailableApartmentView availableApartmentView) {
        this.availableApartmentView = availableApartmentView;
    }

    @Override
    public void getAvailableFlats() {
        apartmentmodelList = new ArrayList<>();

        Apartmentmodel a = new Apartmentmodel(R.drawable.homea,"3000","3","2","2","1000000");
        Apartmentmodel b = new Apartmentmodel(R.drawable.homeb,"3000","3","2","2","1000000");
        Apartmentmodel c = new Apartmentmodel(R.drawable.homec,"3000","3","2","2","1000000");
        Apartmentmodel d = new Apartmentmodel(R.drawable.homed,"3000","3","2","2","1000000");

        apartmentmodelList.add(a);
        apartmentmodelList.add(b);
        apartmentmodelList.add(c);
        apartmentmodelList.add(d);
        availableApartmentView.giveFlats(apartmentmodelList);

    }
}
