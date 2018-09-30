package com.example.kartiksehrawat.ourproduct.Presenters;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.util.Log;

import com.example.kartiksehrawat.ourproduct.Database.MediPlusDb;
import com.example.kartiksehrawat.ourproduct.Model.User;
import com.example.kartiksehrawat.ourproduct.Service.SignUpClient;
import com.example.kartiksehrawat.ourproduct.Service.SignUpService;
import com.google.gson.JsonObject;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by kartiksehrawat on 07/07/18.
 */

public class UserPresenter {

    private SignUpService signUpService;
    private MediPlusDb db;

    public UserPresenter(Context context) {
        signUpService = SignUpClient.getSignUpClient();

        db = Room.databaseBuilder(context.getApplicationContext(),
                MediPlusDb.class, "database-name").build();
    }

    public Single<User> signUp(JsonObject jsonObject, String key) {

        db.userDao().findById(key).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribeWith(
                new DisposableSingleObserver<User>() {

                    @Override
                    public void onSuccess(@NonNull User user) {

                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.d("error1", e.getMessage());

                    }

                }

        );
        return signUpService.signUpUser("application/json", jsonObject);
    }


}
