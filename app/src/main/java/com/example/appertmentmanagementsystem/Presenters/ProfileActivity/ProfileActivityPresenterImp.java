package com.example.appertmentmanagementsystem.Presenters.ProfileActivity;

import android.content.Context;
import android.widget.Toast;

import com.example.appertmentmanagementsystem.API.APIClient;
import com.example.appertmentmanagementsystem.R;
import com.example.appertmentmanagementsystem.Views.Profile.ProfileView;
import com.example.appertmentmanagementsystem.models.Apartmentmodel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
        Call<List<Apartmentmodel>> call = APIClient.getInstance().getApi().getOwnedFlats(userID);
        call.enqueue(new Callback<List<Apartmentmodel>>() {
            @Override
            public void onResponse(Call<List<Apartmentmodel>> call, Response<List<Apartmentmodel>> response) {
                if(response.isSuccessful() && response.body() != null){
                    profileView.showOwnerFlats(response.body());
                }
                else {
                    Toast.makeText((Context) profileView,response.message(),Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<List<Apartmentmodel>> call, Throwable t) {
                Toast.makeText((Context) profileView,t.getLocalizedMessage(),Toast.LENGTH_LONG).show();

            }
        });
        /*Apartmentmodel a = new Apartmentmodel(R.drawable.homea,"3000","3","2","2","1000000");
        Apartmentmodel b = new Apartmentmodel(R.drawable.homeb,"3000","3","2","2","1000000");
        Apartmentmodel c = new Apartmentmodel(R.drawable.homec,"3000","3","2","2","1000000");
        Apartmentmodel d = new Apartmentmodel(R.drawable.homed,"3000","3","2","2","1000000");

        apartmentmodels.add(a);
        apartmentmodels.add(b);
        apartmentmodels.add(c);*/



    }
}
