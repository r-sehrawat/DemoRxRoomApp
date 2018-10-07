package com.example.kartiksehrawat.ourproduct.Activity;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import com.example.kartiksehrawat.ourproduct.R;
import com.example.kartiksehrawat.ourproduct.Util.Utils;

public class DeepLinkActivity extends EventBusActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deep_link);
        Uri data = this.getIntent().getData();
        if (data != null) {
            String uri = this.getIntent().getDataString();
            new Utils().invokeDeeplink(this, uri);
            Log.i("MyApp", "Deep link clicked " + uri);
        }

    }
}
