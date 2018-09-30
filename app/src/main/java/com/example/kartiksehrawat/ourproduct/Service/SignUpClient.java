package com.example.kartiksehrawat.ourproduct.Service;

/**
 * Created by kartiksehrawat on 16/09/17.
 */


import static com.example.kartiksehrawat.ourproduct.Service.RetrofitClient.getClient;


public class SignUpClient {

    public static SignUpService getSignUpClient() {
        return getClient().create(SignUpService.class);
    }


}