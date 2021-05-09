package com.example.appertmentmanagementsystem.Presenters.LoginActivity;

import android.content.Context;
import android.widget.Toast;

import com.example.appertmentmanagementsystem.API.APIClient;
import com.example.appertmentmanagementsystem.Views.Login.LoginActivityView;
import com.example.appertmentmanagementsystem.models.Response;
import com.example.appertmentmanagementsystem.models.UserModel;

import retrofit2.Call;
import retrofit2.Callback;

public class LoginActivityPresenterImp implements LoginActivityPresenter{

    private LoginActivityView loginActivityView;

    public LoginActivityPresenterImp(LoginActivityView loginActivityView) {
        this.loginActivityView = loginActivityView;
    }

    @Override
    public void CheckForLogin(UserModel userModel) {

        Call<Response> call = APIClient.getInstance().getApi().login(userModel);
        call.enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                if(response.isSuccessful() && response.body() != null){
                    loginActivityView.getResponse(response.body());
                }
                else{
                    Toast.makeText((Context)loginActivityView,response.message(),Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {
                Toast.makeText((Context)loginActivityView,t.getLocalizedMessage(),Toast.LENGTH_LONG).show();

            }
        });

    }
}
