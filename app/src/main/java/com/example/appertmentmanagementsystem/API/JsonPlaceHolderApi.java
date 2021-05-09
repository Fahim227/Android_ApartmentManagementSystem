package com.example.appertmentmanagementsystem.API;

import com.example.appertmentmanagementsystem.models.Apartmentmodel;
import com.example.appertmentmanagementsystem.models.Paybillmodel;
import com.example.appertmentmanagementsystem.models.ReportModel;
import com.example.appertmentmanagementsystem.models.Response;
import com.example.appertmentmanagementsystem.models.UserModel;

import java.util.List;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface JsonPlaceHolderApi {


    @POST("insertApartment/")
    Call<Response> postApartmentwithimg(@Body Apartmentmodel model);

    @FormUrlEncoded
    @POST("trial/")
    Call<Response> trial(@Field("img") String img);

    //@FormUrlEncoded
    @POST("insertApartment/")
    Call<Response> postApartment(@Body Apartmentmodel model);
                                 /*@Field("owner_id") int owner_id,@Field("flat_number") String flat_number,
                                 @Field("building_name") String building_name,
                                 @Field("building_numb") String building_numb,
                                 @Field("building_address") String building_address,
                                 @Field("flat_size") String flat_size,
                                 @Field("num_of_beds") String num_of_beds,
                                 @Field("num_of_toilet") String num_of_toilet,
                                 @Field("num_of_balcony") String num_of_balcony,
                                 @Field("map_address") String map_address,
                                 @Field("location") String location,
                                 @Field("price") String price);*/

    //@FormUrlEncoded
    @POST("insertReport/")
    Call<Response> postReport(@Body ReportModel model);

    @POST("registerUser/")
    Call<Response> registerUser(@Body UserModel model);

    @POST("loginUser/")
    Call<Response> login(@Body UserModel model);

    
    @GET("getAllFlats/")
    Call<List<Apartmentmodel>> getAllAvailableApartments();

    @FormUrlEncoded
    @POST("getAllFlats/")
    Call<List<Apartmentmodel>> getFlatsByLocation(@Field("location") String location);


    @POST("insertBill/")
    Call<Response> paybill(@Body Paybillmodel model);

    @FormUrlEncoded
    @POST("getOwnerFlats/")
    Call<List<Apartmentmodel>> getOwnedFlats(@Field("id") int id);


}
