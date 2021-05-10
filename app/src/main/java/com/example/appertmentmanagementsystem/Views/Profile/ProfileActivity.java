package com.example.appertmentmanagementsystem.Views.Profile;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.appertmentmanagementsystem.Adapters.ApartmentAdapter;
import com.example.appertmentmanagementsystem.Presenters.ProfileActivity.ProfileActivityPresenterImp;
import com.example.appertmentmanagementsystem.R;
import com.example.appertmentmanagementsystem.Views.AddFlat.AddFlatsActivity;
import com.example.appertmentmanagementsystem.Views.Login.LoginActivity;
import com.example.appertmentmanagementsystem.Views.Profile.ProfileView;
import com.example.appertmentmanagementsystem.models.Apartmentmodel;

import java.util.List;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener, ProfileView {

    private Button add;
    private RecyclerView flats;
    ApartmentAdapter apartmentAdapter;
    ProfileActivityPresenterImp presenter;
    SharedPreferences sp;
    private int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        add = findViewById(R.id.add_flat_for_rent_id);
        flats = findViewById(R.id.owner_flats_ID);
        presenter = new ProfileActivityPresenterImp(this);
        sp = getPreferences(MODE_PRIVATE);
        Intent intent = getIntent();
        id = intent.getIntExtra("userId",0);//sp.getInt("userId",0);
        Toast.makeText(this,String.valueOf(id),Toast.LENGTH_LONG).show();
        presenter.getOwnerFlats(id);
        add.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.add_flat_for_rent_id){
            //go to flat registration activity
            Intent intent = new Intent(this, AddFlatsActivity.class);
            intent.putExtra("userId",id);
            startActivity(intent);


        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.logoutmenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.logoutID){
            Toast.makeText(this,"Logout",Toast.LENGTH_LONG).show();
            Intent intent = getIntent();
            intent.removeExtra("userId");
            intent = new Intent(ProfileActivity.this, LoginActivity.class);
            startActivity(intent);

        }
        else if(id == R.id.notifyID){
            Toast.makeText(this,"Notification",Toast.LENGTH_LONG).show();

        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void showOwnerFlats(List<Apartmentmodel> apartmentmodelList) {

        apartmentAdapter = new ApartmentAdapter(getApplicationContext(),apartmentmodelList);
        flats.setAdapter(apartmentAdapter);
        flats.setLayoutManager(new LinearLayoutManager(this));
        apartmentAdapter.notifyDataSetChanged();

    }
}