package com.example.appertmentmanagementsystem.Presenters.AddFlatsActivity;

import android.content.Context;
import android.widget.Toast;

import com.example.appertmentmanagementsystem.API.APIClient;
import com.example.appertmentmanagementsystem.Views.AddFlat.AddFlattView;
import com.example.appertmentmanagementsystem.models.Apartmentmodel;
import com.example.appertmentmanagementsystem.models.Response;
import com.example.appertmentmanagementsystem.Presenters.AddFlatsActivityPresenter.AddFlatsActivityPresenter;

import retrofit2.Call;
import retrofit2.Callback;

public class AddFlatsActivityPresenterImp implements AddFlatsActivityPresenter{
    AddFlattView addFlattView;

    public AddFlatsActivityPresenterImp(AddFlattView addFlattView) {
        this.addFlattView = addFlattView;
    }

    @Override
    public void addFlat(Apartmentmodel model) {
        // send data to server
        Call<Response> call = APIClient.getInstance().getApi().postApartment(model);
        /*model.getFlat_number(),model.getBuilding_name(),model.getBuilding_numb(),
                model.getBuilding_address(),model.getFlat_size(),model.getNum_of_beds(),model.getNum_of_toilet(),model.getNum_of_balcony(),model.getMap_address(),
                model.getLocation(),model.getPrice()*/
        call.enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                if(response.isSuccessful() && response.body() != null){
                    Response res = response.body();
                    if(res.getResponse()){
                        addFlattView.getResponse(res);
                    }
                    else{
                        addFlattView.getResponse(res);
                    }
                }
                else {
                    Toast.makeText((Context) addFlattView,response.message(),Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {
                Toast.makeText((Context)addFlattView, t.getLocalizedMessage(),Toast.LENGTH_LONG).show();

            }
        });


        //send Response
        //Response response = new Response(true,"Data Sent");
        //addFlattView.getResponse(response);

    }
}
