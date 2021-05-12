package com.example.appertmentmanagementsystem.Views.AddFlat;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.appertmentmanagementsystem.Presenters.AddFlatsActivity.AddFlatsActivityPresenterImp;
import com.example.appertmentmanagementsystem.R;
import com.example.appertmentmanagementsystem.Views.AddFlat.AddFlattView;
import com.example.appertmentmanagementsystem.models.Apartmentmodel;
import com.example.appertmentmanagementsystem.models.Response;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class AddFlatsActivity extends AppCompatActivity implements AddFlattView, View.OnClickListener {

    AddFlatsActivityPresenterImp addFlatsActivityPresenterImp;
    private EditText flat_num,building_num,location,map_address,flat_size,bed_num,toilet_num,belcony_num,price;
    private ImageView img;
    private Button addimg,post;
    private static int PICK_PHOTO = 1;
    private String filePath;
    private String imageString="";
    public static int userId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_flats);

        Intent intent = getIntent();
        userId = intent.getIntExtra("userId",0);

        flat_num = findViewById(R.id.flatnumID);
        building_num = findViewById(R.id.building_num_ID);
        location = findViewById(R.id.location_ID);
        map_address = findViewById(R.id.map_address_ID);
        flat_size = findViewById(R.id.flat_size_ID);
        bed_num = findViewById(R.id.bed_num_ID);
        toilet_num = findViewById(R.id.toilet_num_ID);
        belcony_num = findViewById(R.id.belcony_num_ID);
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
    public String getFlatNumber() {
        return flat_num.getText().toString();
    }

    @Override
    public void showFlatNumberError(int resId) {
        flat_num.setError(getString(resId));
    }

    @Override
    public String getBuildingNumber() {
        return building_num.getText().toString();
    }

    @Override
    public void showBuildingNumberError(int resId) {
        building_num.setError(getString(resId));
    }

    @Override
    public String getLocation() {
        return location.getText().toString();
    }

    @Override
    public void showLocationError(int resId) {
        location.setError(getString(resId));
    }

    @Override
    public String getMapAddress() {
        return map_address.getText().toString();
    }

    @Override
    public void showMapAddressError(int resId) {
        map_address.setError(getString(resId));
    }

    @Override
    public String getFlatSize() {
        return flat_size.getText().toString();
    }

    @Override
    public void showFlatSizeError(int resId) {
        flat_size.setError(getString(resId));
    }

    @Override
    public String getBedNum() {
        return bed_num.getText().toString();
    }

    @Override
    public void showBedNumError(int resId) {
        bed_num.setError(getString(resId));
    }

    @Override
    public String getBathNum() {
        return toilet_num.getText().toString();
    }

    @Override
    public void showBathNumError(int resId) {
        toilet_num.setError(getString(resId));
    }

    @Override
    public String getBelconyNum() {
        return belcony_num.getText().toString();
    }

    @Override
    public void showBelconyNumError(int resId) {
        belcony_num.setError(getString(resId));
    }

    @Override
    public String getPrice() {
        return price.getText().toString();
    }

    @Override
    public void showPriceError(int resId) {
        price.setError(getString(resId));
    }

    @Override
    public String getImg() {
        return imageString;
    }

    @Override
    public void showImgError(int resId) {
        Toast.makeText(getApplicationContext(),getString(resId),Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.add__img_ID){
            //add imgs;
            Intent intent = new Intent(Intent.ACTION_PICK,
                    MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            intent.setType("image/*");
            startActivityForResult(Intent.createChooser(intent,"Select image"),PICK_PHOTO);

        }
        if(v.getId() == R.id.post_ID){
            //post data...
            addFlatsActivityPresenterImp = new AddFlatsActivityPresenterImp(this);
            Apartmentmodel model = new Apartmentmodel(imageString,flat_num.getText().toString(),"asdjhd",building_num.getText().toString(),"fdsfsdf",flat_size.getText().toString(),bed_num.getText().toString(),toilet_num.getText().toString(),belcony_num.getText().toString(),map_address.getText().toString(),location.getText().toString(),price.getText().toString(),userId);

            addFlatsActivityPresenterImp.addFlat();

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK && requestCode == PICK_PHOTO){
            Uri imgUri = data.getData();
            //Toast.makeText(getApplicationContext(),String.valueOf(imgUri),Toast.LENGTH_SHORT).show();
            filePath = getPath(imgUri);
            img.setImageURI(imgUri);
            Bitmap bitmap = null;
            try {
                //Initialize Bitmap
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(),imgUri);
                // Initialize byte stream
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                // Compress bitmap
                bitmap.compress(Bitmap.CompressFormat.JPEG,100,byteArrayOutputStream);
                // Intialize Byte Array
                byte[] imageBytes = byteArrayOutputStream.toByteArray();
                // Get Base64
                imageString = Base64.encodeToString(imageBytes,Base64.DEFAULT);
                System.out.println("BASE64: "+imageString);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
            Toast.makeText(getApplicationContext(),String.valueOf(requestCode),Toast.LENGTH_SHORT).show();
        }
    }
    private String getPath(Uri uri){
        String[] projection = { MediaStore.Images.Media.DATA };
        Cursor cursor = managedQuery(uri,projection,null,null,null);
        int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();
        return cursor.getString(column_index);
    }
}