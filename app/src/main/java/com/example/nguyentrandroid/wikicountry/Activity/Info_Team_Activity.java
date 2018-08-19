package com.example.nguyentrandroid.wikicountry.Activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.nguyentrandroid.wikicountry.R;

public class Info_Team_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(Info_Team_Activity.this, List_Country_Activity.class));
                finish();
            }
        }, 3000);


    }
}

