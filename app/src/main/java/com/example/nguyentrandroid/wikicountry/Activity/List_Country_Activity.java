package com.example.nguyentrandroid.wikicountry.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.View;

import com.example.nguyentrandroid.wikicountry.Adapter.CountryAdapter;
import com.example.nguyentrandroid.wikicountry.Obj.Country;
import com.example.nguyentrandroid.wikicountry.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class List_Country_Activity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private CountryAdapter countryAdapter;
    public static ArrayList<Country> countryArrayList = new ArrayList<>();
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_country_);
        intit();
        intdata();
        intevent();
        try {
            Get_json();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void intevent() {
    }

    private void intdata() {
        setUpRecyclerView();
    }

    private void intit() {
        mRecyclerView = findViewById(R.id.actin_recycleview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

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


    //        CODE MAU
//        arrayList.add(new Country("Angola","AO","Luanda","Africa","25868000","244","UTC+01:00","Angola","COG","Portuguese","1246700","Angolan kwanza"));
//        Intent intent = new Intent(this, Info_Country_Activity.class);
//        intent.putExtra("arrayList", arrayList);
//        intent.putExtra("i",0);// anh set cai positon cua item vao day nhe'
//        startActivity(intent);


    private String readJson() throws IOException {
        InputStream inputStream = null;
        StringBuilder builder = new StringBuilder();

        try {
            String jsondata = null;
            inputStream = getResources().openRawResource(R.raw.country);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "Unicode"));
            while ((jsondata = bufferedReader.readLine()) != null) {
                builder.append(jsondata);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return new String(builder);
    }

    public void Get_json() throws JSONException {
        try {
            String s = readJson();
            JSONArray jsonArray = new JSONArray(s);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String name = jsonObject.getString("name");
                String code = jsonObject.getString("alpha2Code");
                String capital = jsonObject.getString("capital");
                String region = jsonObject.getString("region");
                String population = jsonObject.getString("population");
                JSONArray jsonArray1 = jsonObject.getJSONArray("callingCodes");
                String callingCodes = "";
                for (int j = 0; j < jsonArray1.length(); j++) {
                    callingCodes = callingCodes + jsonArray1.get(j) + "  ";
                }
                JSONArray jsonArray2 = jsonObject.getJSONArray("timezones");
                String timezones = "";
                for (int h = 0; h < jsonArray2.length(); h++) {
                    timezones = timezones + jsonArray2.get(h) + " ";
                }
                String nativeName = jsonObject.getString("nativeName");
                JSONArray jsonArray3 = jsonObject.getJSONArray("borders");
                String borders = "";
                for (int k = 0; k < jsonArray3.length(); k++) {
                    borders = borders + jsonArray3.get(k) + "," + " ";
                }
                String languages = "";
                JSONArray jsonArray4 = jsonObject.getJSONArray("languages");
                for (int a = 0; a < jsonArray4.length(); a++) {
                    JSONObject jsonObject1 = jsonArray4.getJSONObject(a);
                    languages = languages + "Name: " + jsonObject1.getString("name") + "\n" + "NativeName: " + jsonObject1.getString("nativeName") + "\n" + "\n";
                }
                Log.d("AAA", languages);
                String area = jsonObject.getString("area") + "km2";
                String currencies = "";
                JSONArray jsonArray5 = jsonObject.getJSONArray("currencies");
                for (int b = 0; b < jsonArray5.length(); b++) {
                    JSONObject jsonObject2 = jsonArray5.getJSONObject(b);
                    currencies = currencies + "Code: " + jsonObject2.getString("code") + "\n" +
                            "Name: " + jsonObject2.getString("name") + "\n" +
                            "Symbol: " + jsonObject2.getString("symbol");
                }
                countryArrayList.add(new Country(name, code, capital, region, population, callingCodes, timezones,
                        nativeName, borders, languages, area, currencies));
            }
            countryAdapter = new CountryAdapter(countryArrayList, this);
            mRecyclerView.setAdapter(countryAdapter);


        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
