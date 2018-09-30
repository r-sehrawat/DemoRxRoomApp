package com.example.kartiksehrawat.ourproduct.Service;

/**
 * Created by kartiksehrawat on 16/09/17.
 */

import com.example.kartiksehrawat.ourproduct.Model.User;
import com.google.gson.JsonObject;

import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface SignUpService {

    @GET("/health/ping")
    Single<String> healthCheck();

    @POST("/user/login")
    Single<User> signUpUser(@Header("Content-Type") String string, @Body JsonObject jsonObject);

}