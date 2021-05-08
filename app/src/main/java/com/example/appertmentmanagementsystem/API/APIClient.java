package com.example.appertmentmanagementsystem.API;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {

    public static  String ipUrl = "http://192.168.0.106:8000";
    private static String BaseUrl = "http://192.168.0.106:8000/db/";
    private static APIClient mInstance;

    private static Retrofit retrofit;

    private APIClient(){
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        retrofit = new Retrofit.Builder()
                .baseUrl(BaseUrl)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }
    public static synchronized APIClient getInstance(){
        if(mInstance == null){

            mInstance = new APIClient();

        }
        return mInstance;
    }
    public  JsonPlaceHolderApi getApi(){
        return retrofit.create(JsonPlaceHolderApi.class);
    }

}