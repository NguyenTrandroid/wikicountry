package com.example.nguyentrandroid.wikicountry.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.nguyentrandroid.wikicountry.Activity.Info_Country_Activity;
import com.example.nguyentrandroid.wikicountry.Obj.Country;
import com.example.nguyentrandroid.wikicountry.R;

import java.util.ArrayList;
import java.util.Locale;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.ViewHolder> {
    ArrayList<Country> countryArrayList;
    Context context;
    ArrayList<Country> arrayTemp;
    SearchView searchView;

    public CountryAdapter(ArrayList<Country> countryArrayList, Context context) {
        this.countryArrayList = countryArrayList;
        this.context = context;
        this.arrayTemp = new ArrayList<>();
        this.arrayTemp.addAll(countryArrayList);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.name_country_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.txtName.setText(countryArrayList.get(position).getName());
        holder.txtName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Info_Country_Activity.class);
        intent.putExtra("arrayList", arrayTemp);
        intent.putExtra("i",position);
        context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return countryArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtName;

        public ViewHolder(View itemView) {
            super(itemView);
            txtName = (TextView) itemView.findViewById(R.id.txtName);
        }
    }

    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        countryArrayList.clear();
        if (charText.length() == 0) {
            countryArrayList.addAll(arrayTemp);
        } else {
            for (Country country : arrayTemp) {
                if (country.getName().toLowerCase(Locale.getDefault())
                        .contains(charText)) {
                    countryArrayList.add(country);
                }
            }
        }
        notifyDataSetChanged();
    }
}
