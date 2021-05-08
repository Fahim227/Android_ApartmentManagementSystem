package com.example.appertmentmanagementsystem.Presenters.AddFlatsActivity;

import android.content.Context;
import android.widget.Toast;

import com.example.appertmentmanagementsystem.API.APIClient;
import com.example.appertmentmanagementsystem.Views.AddFlat.AddFlattView;
import com.example.appertmentmanagementsystem.models.Apartmentmodel;
import com.example.appertmentmanagementsystem.models.Response;
import com.example.appertmentmanagementsystem.Presenters.AddFlatsActivity.AddFlatsActivityPresenter;
import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;

import java.io.File;
import java.util.logging.Logger;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;

public class AddFlatsActivityPresenterImp implements AddFlatsActivityPresenter{
    AddFlattView addFlattView;

    public AddFlatsActivityPresenterImp(AddFlattView addFlattView) {
        this.addFlattView = addFlattView;
    }

    @Override
    public void addFlat(String filePath, Apartmentmodel model) {
        model.setImg(filePath);
        // send data to server
        // fileUpload(filePath,model);



        // ApiInterface apiInterface = RetrofitApiClient.getClient().create(ApiInterface.class);
        // Logger.addLogAdapter(new AndroidLogAdapter());

        //File file = new File(filePath);
        //create RequestBody instance from file
        //RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file); //allow image and any other file

        // MultipartBody.Part is used to send also the actual file name
       // MultipartBody.Part body = MultipartBody.Part.createFormData("img", file.getName(), requestFile);

       /* Gson gson = new Gson();
        String patientData = gson.toJson(imageSenderInfo);*/

        // RequestBody description = RequestBody.create(okhttp3.MultipartBody.FORM, patientData);


        // trial:::::
        Call<Response> call = APIClient.getInstance().getApi().postApartment(model);
        call.enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                if (response.body().getResponse()){
                    Toast.makeText((Context)addFlattView,response.body().getMessage(),Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText((Context)addFlattView,response.body().getMessage(),Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {
                Toast.makeText((Context)addFlattView,t.getLocalizedMessage(),Toast.LENGTH_LONG).show();

            }
        });
       /* model.setImage(body);
        Call<Response> call = APIClient.getInstance().getApi().postApartmentwithimg(model);
        call.enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                if (response.body().getResponse()){
                    Toast.makeText((Context)addFlattView,response.body().getMessage(),Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText((Context)addFlattView,response.body().getMessage(),Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {
                Toast.makeText((Context)addFlattView,t.getLocalizedMessage(),Toast.LENGTH_LONG).show();

            }
        });*/






        /*Call<Response> call = APIClient.getInstance().getApi().postApartment(model);

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
        });*/


        //send Response
        //Response response = new Response(true,"Data Sent");
        //addFlattView.getResponse(response);

    }
    public static void fileUpload(String filePath, Apartmentmodel apartmentmodel) {

    }
}
