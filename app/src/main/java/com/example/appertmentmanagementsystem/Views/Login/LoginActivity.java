package com.example.appertmentmanagementsystem.Views.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appertmentmanagementsystem.Activities.UserActivity;
import com.example.appertmentmanagementsystem.Presenters.LoginActivity.LoginActivityPresenterImp;
import com.example.appertmentmanagementsystem.R;
import com.example.appertmentmanagementsystem.Services.LoginService;
import com.example.appertmentmanagementsystem.Views.Register.MainActivity;
import com.example.appertmentmanagementsystem.models.Response;
import com.example.appertmentmanagementsystem.models.UserModel;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener, LoginActivityView{

    private EditText email,password;
    private Button login;
    private TextView logintext;
    private LoginActivityPresenterImp loginActivityPresenterImp;
    private SharedPreferences sp;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Checking if user logged in
        sp = getSharedPreferences("login",MODE_PRIVATE);

        email = findViewById(R.id.loginemailID);
        password = findViewById(R.id.loginpasswordID);
        login = findViewById(R.id.loginbuttonID);
        logintext = findViewById(R.id.logintextID);
        loginActivityPresenterImp = new LoginActivityPresenterImp(this,new LoginService());

        login.setOnClickListener(this);
        logintext.setOnClickListener(this);
        /*sp.edit().remove("logg");
        int v = sp.getInt("logg",0);*/
        Intent intent = getIntent();
        int v = intent.getIntExtra("logg",0);
        Toast.makeText(this,String.valueOf(v),Toast.LENGTH_LONG).show();
        if(v==1){
            // goToUserActivity();
            intent = new Intent(LoginActivity.this, UserActivity.class);
            startActivity(intent);
        }

    }

    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.loginbuttonID){
            // Check for login

            loginActivityPresenterImp.CheckForLogin();

        }
        else{
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
        }

    }

    @Override
    public void getResponse(Response response) {
        if(response.getResponse()){
            Toast.makeText(getApplicationContext(),response.getMessage()+" "+response.getUserid(),Toast.LENGTH_LONG).show();
            Intent intent = new Intent(LoginActivity.this, UserActivity.class);
            /*sp.edit().putInt("logg",1).apply();
            sp.edit().putInt("userId",response.getUserid()).apply();*/
            intent.putExtra("logg",1);
            intent.putExtra("userId",response.getUserid());
            startActivity(intent);
        }
        else{
            Toast.makeText(getApplicationContext(),response.getMessage(),Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public String getEmail() {
        return email.getText().toString();
    }

    @Override
    public void showEmailError(int resId) {
        email.setError(getString(resId));

    }

    @Override
    public String getPassword() {
        return password.getText().toString();
    }

    @Override
    public void showPasswordError(int resId) {
        password.setError(getString(resId));

    }

    @Override
    public void startUserActivity() {
        Intent intent = new Intent(LoginActivity.this, UserActivity.class);
        startActivity(intent);

    }

    @Override
    public void showLoginError(int resId) {
        Toast.makeText(this, getString(resId), Toast.LENGTH_SHORT).show();

    }


}