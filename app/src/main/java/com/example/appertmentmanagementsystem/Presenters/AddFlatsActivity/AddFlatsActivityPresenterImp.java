package com.example.appertmentmanagementsystem.Presenters.AddFlatsActivityPresenter;

import com.example.appertmentmanagementsystem.Views.AddFlat.AddFlattView;
import com.example.appertmentmanagementsystem.models.Apartmentmodel;
import com.example.appertmentmanagementsystem.models.Response;

public class AddFlatsActivityPresenterImp implements AddFlatsActivityPresenter{
    AddFlattView addFlattView;

    public AddFlatsActivityPresenterImp(AddFlattView addFlattView) {
        this.addFlattView = addFlattView;
    }

    @Override
    public void addFlat(Apartmentmodel model) {
        // send data to server


        //send Response
        Response response = new Response(true,"Data Sent");
        addFlattView.getResponse(response);

    }
}
