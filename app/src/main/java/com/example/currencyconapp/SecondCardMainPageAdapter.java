package com.example.currencyconapp;

import android.speech.tts.TextToSpeech;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class SecondCardMainPageAdapter  extends  RecyclerView.Adapter<SecondCardMainPageAdapter.SecondViewHolder>{
    private ArrayList<SecondCardMainActivity> dataSet2;

    public static class SecondViewHolder extends RecyclerView.ViewHolder {

        TextView textViewCharcode;
        TextView textViewName;
        TextView textViewValue;
        TextView textViewOption;
        ImageView imageViewIcon;


        public SecondViewHolder(View itemView) {
            super(itemView);
            this.textViewCharcode = (TextView) itemView.findViewById(R.id.second_charcode_resources_text);
            this.textViewName = (TextView) itemView.findViewById(R.id.second_name_resources_text);
            this.textViewValue = (TextView) itemView.findViewById(R.id.second_value_resources_text);
            this.textViewOption = (TextView) itemView.findViewById(R.id.second_option_resources_text);
            this.imageViewIcon = (ImageView) itemView.findViewById(R.id.second_resources_images);
        }
    }

    public SecondCardMainPageAdapter(ArrayList<SecondCardMainActivity> data2) {
        this.dataSet2 = data2;
    }

    @Override
    public SecondCardMainPageAdapter.SecondViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.second_card_mainpage_activity, parent, false);

        //       view.setOnClickListener(MainActivity.myOnClickListener);

        SecondCardMainPageAdapter.SecondViewHolder secondViewHolder = new SecondCardMainPageAdapter.SecondViewHolder(view);
        return secondViewHolder;
    }

    @Override
    public void onBindViewHolder(final SecondCardMainPageAdapter.SecondViewHolder holder, final int listPosition) {


        TextView textViewCharcode = holder.textViewCharcode;
        TextView textViewName = holder.textViewName;
        TextView textViewValue = holder.textViewValue;
        TextView textViewOption = holder.textViewOption;
        ImageView imageView = holder.imageViewIcon;


        textViewCharcode.setText(dataSet2.get(listPosition).getCharcode());
        textViewName.setText(dataSet2.get(listPosition).getName());
        textViewValue.setText(dataSet2.get(listPosition).getValue());
        textViewOption.setText(dataSet2.get(listPosition).getOption());
        imageView.setImageResource(dataSet2.get(listPosition).getImage());
    }

    @Override

    public int getItemCount() {
        return dataSet2.size();
    }
}


