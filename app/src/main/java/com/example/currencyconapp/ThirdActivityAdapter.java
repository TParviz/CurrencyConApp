package com.example.currencyconapp;

import android.content.Context;
import android.content.RestrictionEntry;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class ThirdActivityAdapter extends RecyclerView.Adapter<ThirdActivityAdapter.MyViewHolder> {


    private ArrayList<ThirdPageActivity> dataSet;

    public static class MyViewHolder extends RecyclerView.ViewHolder {


        TextView textViewName;
        TextView textViewCharcode;
        ImageView imageViewIcon;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.textViewName = (TextView) itemView.findViewById(R.id.name_text);
            this.textViewCharcode = (TextView) itemView.findViewById(R.id.charcode_text);
            this.imageViewIcon = (ImageView) itemView.findViewById(R.id.country_flags);
        }
    }

    public ThirdActivityAdapter(ArrayList<ThirdPageActivity> data) {
        this.dataSet = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                           int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.third_page_activity, parent, false);

 //       view.setOnClickListener(MainActivity.myOnClickListener);

        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int listPosition) {

        TextView textViewName = holder.textViewName;
        TextView textViewCharcode = holder.textViewCharcode;
        ImageView imageView = holder.imageViewIcon;

        textViewName.setText(dataSet.get(listPosition).getName());
        textViewCharcode.setText(dataSet.get(listPosition).getCharcode());
        imageView.setImageResource(dataSet.get(listPosition).getImage());
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}












































    /*ArrayList<ThirdPageActivity> items =new ArrayList<>();

    private Context getContext;

    public void populateList(List<ThirdPageActivity> list) {
        this.items.clear();
        this.items.addAll(list);
        notifyDataSetChanged();
    }

    @NonNull
    @Override

    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.third_page_activity, parent, false);
        return new ResultViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position){
        ((ResultViewHolder) holder).bind(items.get(position));
    }

    @Override
    public int getItemCount() { return items.size();}

    class ResultViewHolder extends RecyclerView.ViewHolder {

        private TextView titleTextView;
        private TextView charcodeTextView;
        private TextView nominalTextView;
        private TextView valueTextView;
        private TextView nameTextView;
        private TextView pubDateTextView;

        private ImageView flagsImageView;

        ResultViewHolder(@NonNull View itemView) {
            super(itemView);
            flagsImageView = itemView.findViewById(R.id.country_flags);
   //         titleTextView = itemView.findViewById(R.id.title_text);
            charcodeTextView = itemView.findViewById(R.id.charcode_text);
            nominalTextView = itemView.findViewById(R.id.nominal_text);
            valueTextView = itemView.findViewById(R.id.value_text);
            nameTextView = itemView.findViewById(R.id.name_text);
            pubDateTextView = itemView.findViewById(R.id.date_text);

        }

        void bind(ThirdPageActivity item){
   //         titleTextView.setText(item.getTitle());
            charcodeTextView.setText(item.getCharcode());
            nominalTextView.setText(item.getNominal());
            valueTextView.setText(item.getValue());
            nameTextView.setText(item.getName());
            pubDateTextView.setText(item.getPublicationDate());
       //     flagsImageView.setImageDrawable();
       //     int id = getResources().getIdentifier("com.example.currencyconapp:drawable/" + StringGenerated, null, null);

        }

    }
*/

