package com.example.appertmentmanagementsystem.Presenters.RegisterPresenter;

import android.content.Context;
import android.widget.Toast;

import com.example.appertmentmanagementsystem.API.APIClient;
import com.example.appertmentmanagementsystem.Views.Register.MainActivity;
import com.example.appertmentmanagementsystem.Views.Register.MainActivityView;
import com.example.appertmentmanagementsystem.models.Response;
import com.example.appertmentmanagementsystem.models.UserModel;

import retrofit2.Call;
import retrofit2.Callback;

public class RegisterPresenterImp implements RegisterPresenter{

    private MainActivityView mainActivityView;
    public RegisterPresenterImp(MainActivityView mainActivityView) {
        this.mainActivityView = mainActivityView;
    }

    @Override
    public void registerUser(UserModel model) {

        Call<Response> call = APIClient.getInstance().getApi().registerUser(model);
        call.enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                if(response.isSuccessful() && response.body()!=null){
                    mainActivityView.FeedBack(response.body());
                }
                else{
                    Toast.makeText((Context) mainActivityView,response.message(),Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {
                Toast.makeText((Context) mainActivityView,t.getLocalizedMessage(),Toast.LENGTH_LONG).show();
            }
        });


    }
}
