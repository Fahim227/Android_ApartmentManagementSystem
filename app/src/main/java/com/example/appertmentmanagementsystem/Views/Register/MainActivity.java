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
        register.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.registerbuttonID){
            registerPresenterImp.registerUser();



        }
    }

    @Override
    public void FeedBack(Response response) {
        if(response.getResponse()){
            Toast.makeText(getApplicationContext(),response.getMessage()+response.getUserid(),Toast.LENGTH_LONG).show();
            Intent intent = new Intent(MainActivity.this, UserActivity.class);
           /* sp.edit().putInt("logg",1).apply();
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
    public String getFirstname() {
        return firstName.getText().toString();
    }

    @Override
    public void showFirstNameError(int resId) {
        firstName.setError(getString(resId));

    }

    @Override
    public String getLastName() {
        return lastName.getText().toString();
    }

    @Override
    public void showLastNameError(int resId) {
        lastName.setError(getString(resId));
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
    public String getConPassword() {
        return confirmpassword.getText().toString();
    }

    @Override
    public void showConPasswordError(int resId) {
        confirmpassword.setError(getString(resId));
    }

    @Override
    public String getPhoneNumer() {
        return phoneNumber.getText().toString();
    }

    @Override
    public void showPhonNumberError(int resId) {
        phoneNumber.setError(getString(resId));
    }
}