package com.example.nguyentrandroid.wikicountry.Activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nguyentrandroid.wikicountry.R;

public class Info_Team_Activity extends AppCompatActivity {
    TextView name;
    SharedPreferences sharedPreferences;
    String dataapp ="ngon_ngu";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_team);
        anhxa();
        setfonts();
        sharedPreferences = getSharedPreferences(dataapp, Context.MODE_PRIVATE);
    }

    private void setfonts() {
        Typeface typeface = Typeface.createFromAsset(getAssets(),"fonts/VNMUSTI.TTF");
        name.setTypeface(typeface);
    }

    private void anhxa() {
        name = findViewById(R.id.appname);
    }

    public void chontienganh(View view) {
        SharedPreferences.Editor editor = getSharedPreferences(getPackageName(), 0).edit();
        editor.putInt("ngonngu", 1);
        editor.commit();
        Intent intent = new Intent(this,List_Country_Activity.class);
        startActivity(intent);
    }

    public void chontiengviet(View view) {
        SharedPreferences.Editor editor = getSharedPreferences(getPackageName(), 0).edit();
        editor.putInt("ngonngu", 0);
        editor.commit();
        Intent intent = new Intent(this,List_Country_Activity.class);
        startActivity(intent);
    }
}

