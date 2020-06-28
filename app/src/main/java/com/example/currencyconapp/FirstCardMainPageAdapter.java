package com.example.currencyconapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FirstCardMainPageAdapter extends RecyclerView.Adapter<FirstCardMainPageAdapter.FirstViewHolder> {



    private ArrayList<FirstCardMainActivity> dataSet1;

    public static class FirstViewHolder extends RecyclerView.ViewHolder {


        TextView textViewName;
        TextView textViewCharcode;
        ImageView imageViewIcon;

        public FirstViewHolder(View itemView) {
            super(itemView);
            this.textViewName = (TextView) itemView.findViewById(R.id.first_name_text);
            this.textViewCharcode = (TextView) itemView.findViewById(R.id.first_charcode_text);
            this.imageViewIcon = (ImageView) itemView.findViewById(R.id.first_country_flags);
        }
    }

    public FirstCardMainPageAdapter(ArrayList<FirstCardMainActivity> data1) {
        this.dataSet1 = data1;
    }

    @Override
    public FirstViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.first_card_mainpage_activity, parent, false);

        //       view.setOnClickListener(MainActivity.myOnClickListener);

        FirstCardMainPageAdapter.FirstViewHolder firstViewHolder = new FirstCardMainPageAdapter.FirstViewHolder(view);
        return firstViewHolder;
    }

    @Override
    public void onBindViewHolder(final FirstCardMainPageAdapter.FirstViewHolder holder, final int listPosition) {

        TextView textViewName = holder.textViewName;
        TextView textViewCharcode = holder.textViewCharcode;
        ImageView imageView = holder.imageViewIcon;

        textViewName.setText(dataSet1.get(listPosition).getName());
        textViewCharcode.setText(dataSet1.get(listPosition).getCharcode());
        imageView.setImageResource(dataSet1.get(listPosition).getImage());
    }

    @Override
    public int getItemCount() {
        return dataSet1.size();
    }
}


