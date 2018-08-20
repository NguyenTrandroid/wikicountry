package com.example.nguyentrandroid.wikicountry.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nguyentrandroid.wikicountry.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Info_Country_Activity extends AppCompatActivity {
    @BindView(R.id.imgFlag)
    ImageView imgFlag;
    @BindView(R.id.txtNameCt)
    TextView txtNameCt;
    @BindView(R.id.codeCT)
    TextView codeCT;
//    2 lỗi
    @BindView(R.id.capitalCT)
    TextView capitalCT;
    @BindView(R.id.regionCT)
    TextView regionCT;
    @BindView(R.id.populationCT)
    TextView populationCT;
    @BindView(R.id.callingcodes)
    TextView callingcodes;
//    3 lỗi
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
//    4 lỗi
    @BindView(R.id.languagesCT)
    TextView languagesCT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        5 lỗi
        setContentView(R.layout.activity_info_country_);
        ButterKnife.bind(this);
    }
}
