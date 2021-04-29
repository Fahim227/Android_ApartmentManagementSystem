package com.example.appertmentmanagementsystem.Views.AddFlat;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.appertmentmanagementsystem.Presenters.AddFlatsActivityPresenter.AddFlatsActivityPresenterImp;
import com.example.appertmentmanagementsystem.R;
import com.example.appertmentmanagementsystem.Views.AddFlat.AddFlattView;
import com.example.appertmentmanagementsystem.models.Apartmentmodel;
import com.example.appertmentmanagementsystem.models.Response;

public class AddFlatsActivity extends AppCompatActivity implements AddFlattView, View.OnClickListener {

    AddFlatsActivityPresenterImp addFlatsActivityPresenterImp;
    private EditText flat_num,building_num,location,map_address,flat_size,bed_num,toilet_num,belcony_num,price;
    private ImageView img;
    private Button addimg,post;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_flats);
        flat_num = findViewById(R.id.flatnumID);
        building_num = findViewById(R.id.building_num_ID);
        location = findViewById(R.id.location_ID);
        map_address = findViewById(R.id.map_address_ID);
        flat_size = findViewById(R.id.flat_size_ID);
        bed_num = findViewById(R.id.bed_num_ID);
        toilet_num = findViewById(R.id.toilet_num_ID);
        belcony_num = findViewById(R.id.bed_num_ID);
        price = findViewById(R.id.price_ID);
        img = findViewById(R.id.flat_img);
        addimg = findViewById(R.id.add__img_ID);
        post = findViewById(R.id.post_ID);



        addimg.setOnClickListener(this);
        post.setOnClickListener(this);
    }

    @Override
    public void getResponse(Response response) {
        Toast.makeText(getApplicationContext(),response.getMessage(),Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.add__img_ID){
            //add imgs;

        }
        else if(v.getId() == R.id.post_ID){
            //post data...
            addFlatsActivityPresenterImp = new AddFlatsActivityPresenterImp(this);
            Apartmentmodel model = new Apartmentmodel(R.drawable.homea,flat_num.getText().toString(),"asdjhd",building_num.getText().toString(),"fdsfsdf",flat_size.getText().toString(),bed_num.getText().toString(),toilet_num.getText().toString(),belcony_num.getText().toString(),map_address.getText().toString(),location.getText().toString());

            addFlatsActivityPresenterImp.addFlat(model);

        }
    }
}