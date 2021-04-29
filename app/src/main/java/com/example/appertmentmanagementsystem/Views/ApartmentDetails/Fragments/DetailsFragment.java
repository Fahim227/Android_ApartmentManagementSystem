package com.example.appertmentmanagementsystem.Views.ApartmentDetails.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.appertmentmanagementsystem.Views.ApartmentDetails.ApartmentDetails;
import com.example.appertmentmanagementsystem.R;

public class DetailsFragment extends Fragment {

    private ImageView img;
    private TextView details;
    Intent intent;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_details, container, false);
        img = v.findViewById(R.id.detailsimgID);
        details = v.findViewById(R.id.detailstextID);
        details.setText(ApartmentDetails.dstr);
        img.setImageResource(ApartmentDetails.img);

        return v;
    }
}