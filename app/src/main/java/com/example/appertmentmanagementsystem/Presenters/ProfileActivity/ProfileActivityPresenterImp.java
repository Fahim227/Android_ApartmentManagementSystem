package com.example.appertmentmanagementsystem.Presenters.ProfileActivity;

import com.example.appertmentmanagementsystem.R;
import com.example.appertmentmanagementsystem.Views.Profile.ProfileView;
import com.example.appertmentmanagementsystem.models.Apartmentmodel;

import java.util.ArrayList;
import java.util.List;

public class ProfileActivityPresenterImp implements ProfileActivityPresenter {
    ProfileView profileView;
    List<Apartmentmodel> apartmentmodels;
    public ProfileActivityPresenterImp(ProfileView profileView) {
        this.profileView = profileView;
    }

    @Override
    public void getOwnerFlats(int userID) {
        apartmentmodels = new ArrayList<>();
        //get datas
        Apartmentmodel a = new Apartmentmodel(R.drawable.homea,"3000","3","2","2","1000000");
        Apartmentmodel b = new Apartmentmodel(R.drawable.homeb,"3000","3","2","2","1000000");
        Apartmentmodel c = new Apartmentmodel(R.drawable.homec,"3000","3","2","2","1000000");
        Apartmentmodel d = new Apartmentmodel(R.drawable.homed,"3000","3","2","2","1000000");

        apartmentmodels.add(a);
        apartmentmodels.add(b);
        apartmentmodels.add(c);

        profileView.showOwnerFlats(apartmentmodels);

    }
}
