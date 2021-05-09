package com.example.appertmentmanagementsystem.Views.Register;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.appertmentmanagementsystem.Activities.UserActivity;
import com.example.appertmentmanagementsystem.Presenters.RegisterPresenter.RegisterPresenterImp;
import com.example.appertmentmanagementsystem.R;
import com.example.appertmentmanagementsystem.models.Response;
import com.example.appertmentmanagementsystem.models.UserModel;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,MainActivityView {
    private EditText firstName,lastName,email,phoneNumber,password,confirmpassword;
    private Button register;
    private RegisterPresenterImp registerPresenterImp;
    private SharedPreferences sp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstName = findViewById(R.id.registerfirstnameID);
        lastName = findViewById(R.id.registerLastnameID);
        email = findViewById(R.id.registeremailID);
        phoneNumber = findViewById(R.id.registerphonenumberID);
        password = findViewById(R.id.registerpasswordID);
        confirmpassword = findViewById(R.id.registerconfirmpasswordID);
        register = findViewById(R.id.registerbuttonID);
        registerPresenterImp = new RegisterPresenterImp(this);
        sp = getSharedPreferences("login",MODE_PRIVATE);

        register.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.registerbuttonID){
            UserModel user = new UserModel(firstName.getText().toString(),
                    lastName.getText().toString(),
                    phoneNumber.getText().toString(),
                    email.getText().toString(),
                    password.getText().toString());
            registerPresenterImp.registerUser(user);



        }
    }

    @Override
    public void FeedBack(Response response) {
        if(response.getResponse()){
            Toast.makeText(getApplicationContext(),response.getMessage()+response.getUserid(),Toast.LENGTH_LONG).show();
            Intent intent = new Intent(MainActivity.this, UserActivity.class);
            sp.edit().putBoolean("logged",true).apply();
            sp.edit().putString("userID",response.getUserid()).apply();
            startActivity(intent);
        }
        else{
            Toast.makeText(getApplicationContext(),response.getMessage(),Toast.LENGTH_LONG).show();
        }
    }
}