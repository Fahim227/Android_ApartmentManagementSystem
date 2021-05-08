package com.example.appertmentmanagementsystem.Presenters.AvailableApartments;

import android.content.Context;
import android.widget.Toast;

import com.example.appertmentmanagementsystem.API.APIClient;
import com.example.appertmentmanagementsystem.Views.AvailableApartments.AvailableApartmentView;
import com.example.appertmentmanagementsystem.models.Apartmentmodel;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AvailableApartmentPresenterImp implements AvailableApartmentPresenter{
    AvailableApartmentView availableApartmentView;
    private List<Apartmentmodel> apartmentmodelList;

    public AvailableApartmentPresenterImp(AvailableApartmentView availableApartmentView) {
        this.availableApartmentView = availableApartmentView;
    }

    @Override
    public void getAvailableFlats() {
        apartmentmodelList = new ArrayList<>();

        /*Apartmentmodel a = new Apartmentmodel(R.drawable.homea,"3000","3","2","2","1000000");
        Apartmentmodel b = new Apartmentmodel(R.drawable.homeb,"3000","3","2","2","1000000");
        Apartmentmodel c = new Apartmentmodel(R.drawable.homec,"3000","3","2","2","1000000");
        Apartmentmodel d = new Apartmentmodel(R.drawable.homed,"3000","3","2","2","1000000");


        apartmentmodelList.add(a);
        apartmentmodelList.add(b);
        apartmentmodelList.add(c);
        apartmentmodelList.add(d);*/
        //get flats from sever
        Call<List<Apartmentmodel>> call = APIClient.getInstance().getApi().getAllAvailableApartments();
        call.enqueue(new Callback<List<Apartmentmodel>>() {
            @Override
            public void onResponse(Call<List<Apartmentmodel>> call, Response<List<Apartmentmodel>> response) {
                if(response.isSuccessful() && response.body() != null){
                    availableApartmentView.setFlats(response.body());

                }
                else {
                    Toast.makeText((Context) availableApartmentView,response.message(),Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<List<Apartmentmodel>> call, Throwable t) {
                Toast.makeText((Context) availableApartmentView,t.getLocalizedMessage(),Toast.LENGTH_LONG).show();

            }
        });
        // availableApartmentView.giveFlats(apartmentmodelList);

    }

    @Override
    public void getFlatsByLocation(String location) {
        Call<List<Apartmentmodel>> call = APIClient.getInstance().getApi().getFlatsByLocation(location);
        call.enqueue(new Callback<List<Apartmentmodel>>() {
            @Override
            public void onResponse(Call<List<Apartmentmodel>> call, Response<List<Apartmentmodel>> response) {
                if(response.isSuccessful() && response.body() != null){
                    availableApartmentView.setFlats(response.body());

                }
                else {
                    Toast.makeText((Context) availableApartmentView,response.message(),Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<List<Apartmentmodel>> call, Throwable t) {

            }
        });

    }
}
