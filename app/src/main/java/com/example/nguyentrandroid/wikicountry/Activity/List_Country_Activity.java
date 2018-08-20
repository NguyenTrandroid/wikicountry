package com.example.nguyentrandroid.wikicountry.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.nguyentrandroid.wikicountry.Obj.Country;
import com.example.nguyentrandroid.wikicountry.R;

import java.io.Serializable;
import java.util.ArrayList;

public class List_Country_Activity extends AppCompatActivity {
    RecyclerView mRecyclerView;
    RecyclerView.Adapter mAdapter;
    ArrayList<Country> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_country_);
        intit();
        intdata();
        intevent();
    }

    private void intevent() {
    }

    private void intdata() {
        setUpRecyclerView();
    }

    private void intit() {
        arrayList = new ArrayList<>();
        mRecyclerView = findViewById(R.id.actin_recycleview);

    }

    private void setUpRecyclerView() {
        mRecyclerView.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(llm);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        mRecyclerView.addItemDecoration(dividerItemDecoration);
    }
// CODE MAU
//        arrayList.add(new Country("Angola","AO","Luanda","Africa","25868000","244","UTC+01:00","Angola","COG","Portuguese","1246700","Angolan kwanza"));
//        Intent intent = new Intent(this, Info_Country_Activity.class);
//        intent.putExtra("arrayList", arrayList);
//        intent.putExtra("i",0);// anh set cai positon cua item vao day nhe'
//        startActivity(intent);

}
