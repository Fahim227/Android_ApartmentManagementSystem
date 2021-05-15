package com.example.appertmentmanagementsystem.Presenters.AddFlatsActivity;

import android.content.Context;
import android.widget.Toast;

import com.example.appertmentmanagementsystem.API.APIClient;
import com.example.appertmentmanagementsystem.R;
import com.example.appertmentmanagementsystem.Views.AddFlat.AddFlatsActivity;
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
    public void addFlat() {
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
        String flat_number = addFlattView.getFlatNumber();
        if(flat_number.isEmpty()){
            addFlattView.showFlatNumberError(R.string.flat_number_error);
            return;
        }
        String building_number = addFlattView.getBuildingNumber();
        if(building_number.isEmpty()){
            addFlattView.showBuildingNumberError(R.string.building_number_error);
            return;
        }
        String location = addFlattView.getLocation();
        if(location.isEmpty()){
            addFlattView.showLocationError(R.string.location_error);
            return;
        }
        String map_address = addFlattView.getMapAddress();
        if(map_address.isEmpty()){
            addFlattView.showMapAddressError(R.string.map_address_error);
            return;
        }
        String flat_size = addFlattView.getFlatSize();
        if(flat_size.isEmpty()){
            addFlattView.showFlatSizeError(R.string.flat_size_error);
            return;
        }
        String bed_num = addFlattView.getBedNum();
        if(bed_num.isEmpty()){
            addFlattView.showBedNumError(R.string.bed_num_error);
            return;
        }
        String bath_num = addFlattView.getBathNum();
        if(bath_num.isEmpty()){
            addFlattView.showBathNumError(R.string.bath_num_error);
            return;
        }
        String belcony_num = addFlattView.getBelconyNum();
        if(belcony_num.isEmpty()){
            addFlattView.showBelconyNumError(R.string.belcony_num_error);
            return;
        }
        String price = addFlattView.getPrice();
        if(price.isEmpty()){
            addFlattView.showPriceError(R.string.price_error);
            return;
        }

        String img = addFlattView.getImg();
        //Toast.makeText((Context) addFlattView,img,Toast.LENGTH_LONG).show();
        System.out.print("img"+img);
        /*if(img.equals("")){
            Toast.makeText((Context) addFlattView,"Working",Toast.LENGTH_LONG).show();
            addFlattView.showImgError(R.string.img_error);
            return;
        }*/

        Apartmentmodel model = new Apartmentmodel(img,flat_number,"Manjil",building_number,"3/13",flat_size,bed_num,bath_num,belcony_num,map_address,location,price, AddFlatsActivity.userId);
        Call<Response> call = APIClient.getInstance().getApi().postApartment(model);
        call.enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                if (response.isSuccessful() && response.body() != null){
                   addFlattView.getResponse(response.body());
                }
                else {
                    Toast.makeText((Context)addFlattView,response.message(),Toast.LENGTH_LONG).show();
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
