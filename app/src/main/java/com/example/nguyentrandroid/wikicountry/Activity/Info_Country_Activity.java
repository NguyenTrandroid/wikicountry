package com.example.nguyentrandroid.wikicountry.Activity;

import android.content.ClipData;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nguyentrandroid.wikicountry.Obj.Country;
import com.example.nguyentrandroid.wikicountry.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Info_Country_Activity extends AppCompatActivity {
    @BindView(R.id.imgFlag)
    ImageView imgFlag;
    @BindView(R.id.txtNameCt)
    TextView txtNameCt;
    @BindView(R.id.codeCT)
    TextView codeCT;
    @BindView(R.id.capitalCT)
    TextView capitalCT;
    @BindView(R.id.regionCT)
    TextView regionCT;
    @BindView(R.id.populationCT)
    TextView populationCT;
    @BindView(R.id.callingcodes)
    TextView callingcodes;
    @BindView(R.id.AreaCT)
    TextView AreaCT;
    @BindView(R.id.timezonesCT)
    TextView timezonesCT;
    @BindView(R.id.bordersCT)
    TextView bordersCT;
    @BindView(R.id.nativenameCT)
    TextView nativenameCT;
    @BindView(R.id.currenciesCT)
    TextView currenciesCT;
    @BindView(R.id.languagesCT)
    TextView languagesCT;
    ArrayList<Country> arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_country_);
        ButterKnife.bind(this);
        arrayList = (ArrayList<Country>) getIntent().getSerializableExtra(
                "arrayList");
        int i = getIntent().getIntExtra("i",0);
        txtNameCt.setText(arrayList.get(i).getName());
        codeCT.setText(arrayList.get(i).getAlpha2Code());
        capitalCT.setText(arrayList.get(i).getCapital());
        regionCT.setText(arrayList.get(i).getRegion());
        populationCT.setText(arrayList.get(i).getPopulation());
        callingcodes.setText(arrayList.get(i).getCallingCodes());
        AreaCT.setText(arrayList.get(i).getArea());
        timezonesCT.setText(arrayList.get(i).getTimezones());
        bordersCT.setText(arrayList.get(i).getBorders());
        nativenameCT.setText(arrayList.get(i).getNativeName());
        currenciesCT.setText(arrayList.get(i).getCurrencies());
        languagesCT.setText(arrayList.get(i).getLanguages());

    }
}
