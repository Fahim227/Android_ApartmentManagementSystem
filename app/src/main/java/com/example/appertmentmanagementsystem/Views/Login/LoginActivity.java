package com.example.appertmentmanagementsystem.Views.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appertmentmanagementsystem.Presenters.LoginActivity.LoginActivityPresenterImp;
import com.example.appertmentmanagementsystem.R;
import com.example.appertmentmanagementsystem.Views.Register.MainActivity;
import com.example.appertmentmanagementsystem.models.Response;
import com.example.appertmentmanagementsystem.models.UserModel;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener, LoginActivityView{

    private EditText email,password;
    private Button login;
    private TextView logintext;
    private LoginActivityPresenterImp loginActivityPresenterImp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = findViewById(R.id.loginemailID);
        password = findViewById(R.id.loginpasswordID);
        login = findViewById(R.id.loginbuttonID);
        logintext = findViewById(R.id.logintextID);
        loginActivityPresenterImp = new LoginActivityPresenterImp(this);

        login.setOnClickListener(this);
        logintext.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.loginbuttonID){
            // Check for login
            UserModel userModel = new UserModel(email.getText().toString(),password.getText().toString());
            loginActivityPresenterImp.CheckForLogin(userModel);

        }
        else{
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
        }

    }

    @Override
    public void getResponse(Response response) {
        Toast.makeText(getApplicationContext(),response.getMessage()+" "+response.getUserid(),Toast.LENGTH_LONG).show();
    }
}