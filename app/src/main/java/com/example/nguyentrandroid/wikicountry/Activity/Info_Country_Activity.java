package com.example.nguyentrandroid.wikicountry.Activity;

import android.content.ClipData;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nguyentrandroid.wikicountry.Obj.Country;
import com.example.nguyentrandroid.wikicountry.R;

import java.io.IOException;
import java.io.InputStream;
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
    SharedPreferences sharedPreferences;
    String dataapp ="ngon_ngu";
    int nn;
    TextView textViewname, textViewalpha, textViewthudo, textViewkhuvuc, textViewdanso,
    textViewquayso, textViewdientich, textViewmuigio, textViewtiepgiap, textViewtendiaphuong,
    textViewdonvitien, textViewngonngu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_country_);
        sharedPreferences = getSharedPreferences(dataapp , Context.MODE_PRIVATE);
        sharedPreferences =getSharedPreferences(getPackageName(), 0);
        nn= sharedPreferences.getInt("ngonngu",1);
        ButterKnife.bind(this);
        if (nn!=1){
            setngonngu();
        }
        arrayList = (ArrayList<Country>) getIntent().getSerializableExtra(
                "arrayList");
        int i = getIntent().getIntExtra("i",0);
        AssetManager assetManager = getAssets();
        InputStream is = null;
        try {
            is = assetManager.open("imgflag/"+arrayList.get(i).getAlpha2Code().toLowerCase()+".png");
            Bitmap bitmap = BitmapFactory.decodeStream(is);
            imgFlag.setImageBitmap(bitmap);
        } catch (IOException e) {
            e.printStackTrace();
        }
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

    private void setngonngu() {
        textViewname = findViewById(R.id.textname);
        textViewname.setText("Tên quốc gia");
        textViewalpha = findViewById(R.id.textalpha2code);
        textViewalpha.setText("Mã Alpha 2");
        textViewthudo = findViewById(R.id.thudo);
        textViewthudo.setText("Thủ đô");
        textViewkhuvuc = findViewById(R.id.khuvuc);
        textViewkhuvuc.setText("Khu vực");
        textViewdanso = findViewById(R.id.danso);
        textViewdanso.setText("Dân số");
        textViewquayso = findViewById(R.id.maquayso);
        textViewquayso.setText("Mã quay số");
        textViewdientich = findViewById(R.id.dientich);
        textViewdientich.setText("Diện tích");
        textViewmuigio = findViewById(R.id.muigio);
        textViewmuigio.setText("Múi giờ");
        textViewtiepgiap = findViewById(R.id.tiepgiap);
        textViewtiepgiap.setText("Tiếp giáp");
        textViewtendiaphuong = findViewById(R.id.tendiaphuong);
        textViewtendiaphuong.setText("Tên địa phương");
        textViewdonvitien = findViewById(R.id.donvitiente);
        textViewdonvitien.setText("Đơn vị tiền tệ");
        textViewngonngu = findViewById(R.id.ngonngu);
        textViewngonngu.setText("Ngôn ngữ");
    }
}
