package com.example.appertmentmanagementsystem.Presenters.LoginActivity;

import android.content.Context;
import android.widget.Toast;

import com.example.appertmentmanagementsystem.API.APIClient;
import com.example.appertmentmanagementsystem.R;
import com.example.appertmentmanagementsystem.Services.LoginService;
import com.example.appertmentmanagementsystem.Views.Login.LoginActivityView;
import com.example.appertmentmanagementsystem.models.Response;
import com.example.appertmentmanagementsystem.models.UserModel;

import retrofit2.Call;
import retrofit2.Callback;

public class LoginActivityPresenterImp implements LoginActivityPresenter{

    private LoginActivityView loginActivityView;
    private LoginService service;

    public LoginActivityPresenterImp(LoginActivityView loginActivityView, LoginService service) {
        this.loginActivityView = loginActivityView;
        this.service = service;
    }

    @Override
    public void CheckForLogin() {
        String email = loginActivityView.getEmail();
        if (email.isEmpty()) {
            loginActivityView.showEmailError(R.string.email_error);
            return;
        }
        String password = loginActivityView.getPassword();
        if (password.isEmpty()) {
            loginActivityView.showPasswordError(R.string.password_error);
            return;
        }
        boolean loginSucceeded = service.login(email, password);
        if (loginSucceeded) {
            loginActivityView.startUserActivity();
            return;
        }
        else{
            UserModel userModel = new UserModel(email,password);
            Call<Response> call = APIClient.getInstance().getApi().login(userModel);
            call.enqueue(new Callback<Response>() {
                @Override
                public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                    if(response.isSuccessful() && response.body() != null){
                        loginActivityView.getResponse(response.body());
                    }
                    else{
                        loginActivityView.showLoginError(R.string.login_failed);
                    }
                }

                @Override
                public void onFailure(Call<Response> call, Throwable t) {
                    Toast.makeText((Context)loginActivityView,t.getLocalizedMessage(),Toast.LENGTH_LONG).show();

                }
            });
        }

    }
}
