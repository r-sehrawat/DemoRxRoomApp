package com.example.kartiksehrawat.ourproduct.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.kartiksehrawat.ourproduct.Presenters.UserPresenter;
import com.example.kartiksehrawat.ourproduct.R;
import com.example.kartiksehrawat.ourproduct.Service.SignUpClient;
import com.example.kartiksehrawat.ourproduct.Service.SignUpService;
import com.example.kartiksehrawat.ourproduct.Model.User;
import com.google.gson.JsonObject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class StartActivity extends EventBusActivity {

    public final static int REQUEST_LOGIN = 1;
    public final static int REQUEST_SIGNUP = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        TextView login = (TextView) findViewById(R.id.login);
        TextView signUp = (TextView) findViewById(R.id.signUp);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StartActivity.this,SignUpActivity.class);
                intent.putExtra("requestCode",REQUEST_LOGIN);
                startActivity(intent);
            }
        });

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StartActivity.this,SignUpActivity.class);
                intent.putExtra("requestCode",REQUEST_SIGNUP);
                startActivity(intent);
            }
        });


    }

}
