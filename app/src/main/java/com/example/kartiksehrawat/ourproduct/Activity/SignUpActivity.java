package com.example.kartiksehrawat.ourproduct.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kartiksehrawat.ourproduct.Model.User;
import com.example.kartiksehrawat.ourproduct.Presenters.UserPresenter;
import com.example.kartiksehrawat.ourproduct.R;
import com.example.kartiksehrawat.ourproduct.Util.Utils;
import com.google.gson.JsonObject;

import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

import static com.example.kartiksehrawat.ourproduct.Activity.StartActivity.REQUEST_LOGIN;
import static com.example.kartiksehrawat.ourproduct.Activity.StartActivity.REQUEST_SIGNUP;

public class SignUpActivity extends EventBusActivity {

    private EditText name, email, password;
    private TextView submit;
    private UserPresenter userPresenter;
    private int getRequestType;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        userPresenter = new UserPresenter(this);
        getRequestType = getIntent().getIntExtra("requestCode",REQUEST_LOGIN);
        setViews();
        setClickListeners();


    }

    private void setClickListeners() {
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = name.getText().toString();
                String userEmail = email.getText().toString();
                String userPassword = password.getText().toString();
                if (Utils.validate(userEmail, userPassword)) {
                    signUp(userName, userEmail, userPassword);
                } else {
                    Toast.makeText(SignUpActivity.this, "Please enter all fields correctly", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void signUp(String userName, String userEmail, String userPassword) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("email", userEmail);
        jsonObject.addProperty("password", userPassword);
        if(getRequestType==REQUEST_SIGNUP) {
            jsonObject.addProperty("userName", userName);
            jsonObject.addProperty("login",0);
        }else{
            jsonObject.addProperty("userName", "");
            jsonObject.addProperty("login",1);
        }

        userPresenter.signUp(jsonObject,"key").
                subscribeOn(Schedulers.io()).
                subscribeWith(new DisposableSingleObserver<User>() {
                    @Override
                    public void onSuccess(@NonNull User user) {

                        String message;
                        if(getRequestType==REQUEST_LOGIN){
                            message = "Logged in";
                        }else{
                            message = "registered";
                        }
                       Log.d("checkSuccess",message);
                       // login successful
                        //start appropriate intent
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        e.printStackTrace();
                    }
                });


    }

    private void setViews() {

        name = (EditText) findViewById(R.id.name);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        submit = (TextView) findViewById(R.id.submit);
        if(getRequestType == REQUEST_SIGNUP){
            name.setVisibility(View.VISIBLE);
        }

    }
}
