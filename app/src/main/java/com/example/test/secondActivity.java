package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class secondActivity extends AppCompatActivity {
    private static final String TAG = "secondActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    public void onStartClicked(View view) {
        myThread myThread = new myThread();
        myThread.start();
    }

    public void onStopclicked(View view) {
    }

    public class myThread extends Thread{
        @Override
        public void run() {
            Log.d(TAG, "run: "+ this.getName());
            Log.d(TAG, "run: "+ this.getName());
        }
    }


}