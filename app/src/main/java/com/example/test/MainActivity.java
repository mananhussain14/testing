package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import org.chromium.net.CronetEngine;
import org.chromium.net.UrlRequest;
import org.chromium.net.UrlResponseInfo;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CronetEngine.Builder myBuilder = new CronetEngine.Builder(MainActivity.this);
        CronetEngine cronetEngine = myBuilder.build();
        Executor executor = Executors.newSingleThreadExecutor();




        MyUrlRequestCallback myUrlRequestCallback = new MyUrlRequestCallback() {
            @Override
            public void onSucceeded(UrlRequest request, UrlResponseInfo info) {
                super.onSucceeded(request, info);
            }
        };

        UrlRequest.Builder requestBuilder = cronetEngine.newUrlRequestBuilder(
                "https://gorest.co.in/public/v2/users",myUrlRequestCallback, executor);
//        requestBuilder.setHttpMethod("Post");

        UrlRequest request = requestBuilder.build();
        request.start();

    }


    public void secondActivity(View view) {
        Intent intent = new Intent(MainActivity.this,secondActivity.class
        );
        startActivity(intent);
    }
}