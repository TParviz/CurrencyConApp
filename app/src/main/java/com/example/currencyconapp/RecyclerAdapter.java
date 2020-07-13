package com.example.currencyconapp;

import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ValuteViewHolder> {

    public List<Valute> dataset;
    private String res;
    private Context context;

    ImageView image;


    public void submitList(List<Valute> valutes) {
        dataset.clear();
        dataset.addAll(valutes);
        notifyDataSetChanged();
    }


    public RecyclerAdapter(Context context) {
        dataset = new ArrayList<>();
        this.context = context;
    }


    @NonNull
    @Override
    public RecyclerAdapter.ValuteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.third_page_activity, parent, false);
        return new ValuteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.ValuteViewHolder holder, int position) {
        Valute item = dataset.get(position);
        holder.charCodeTv.setText(item.getCharcode());


//        if (item.getCharcode().equals("USD")) {
//            holder.flagsIv.setImageResource(R.drawable.usa);
//        } else
//            holder.flagsIv.setImageResource(R.drawable.europa);


        switch (item.getCharcode()) {
            case "USA": {
                holder.flagsIv.setImageResource(R.drawable.usa);
                break;
            }
            case "EUR": {
                holder.flagsIv.setImageResource(R.drawable.europa);
                break;
            }
            case "CNY": {
                holder.flagsIv.setImageResource(R.drawable.china);
                break;
            }
            case "CHF": {
                holder.flagsIv.setImageResource(R.drawable.swiss);
                break;
            }
            case "RUB": {
                holder.flagsIv.setImageResource(R.drawable.russia);
                break;
            }
            case "UZS": {
                holder.flagsIv.setImageResource(R.drawable.uzbekistan);
                break;
            }
            case "KGS": {
                holder.flagsIv.setImageResource(R.drawable.kyrgyzstan);
                break;
            }
            case "KZT": {
                holder.flagsIv.setImageResource(R.drawable.kazakhstan);
                break;
            }
            case "BYN": {
                holder.flagsIv.setImageResource(R.drawable.belarus);
                break;
            }
            case "IRR": {
                holder.flagsIv.setImageResource(R.drawable.iran);
                break;
            }
            case "AFN": {
                holder.flagsIv.setImageResource(R.drawable.afghanistan);
                break;
            }
            case "PKR": {
                holder.flagsIv.setImageResource(R.drawable.pakistan);
                break;
            }
            case "TRY": {
                holder.flagsIv.setImageResource(R.drawable.turkey);
                break;
            }
            case "TMT": {
                holder.flagsIv.setImageResource(R.drawable.turkmenistan);
                break;
            }
            case "GBP": {
                holder.flagsIv.setImageResource(R.drawable.england);
                break;
            }
            case "AUD": {
                holder.flagsIv.setImageResource(R.drawable.australia);
                break;
            }
            case "DKK": {
                holder.flagsIv.setImageResource(R.drawable.denmark);
                break;
            }
            case "ISK": {
                holder.flagsIv.setImageResource(R.drawable.iceland);
                break;
            }
            case "CAD": {
                holder.flagsIv.setImageResource(R.drawable.canada);
                break;
            }
            case "KWD": {
                holder.flagsIv.setImageResource(R.drawable.kuwait);
                break;
            }
            case "NOK": {
                holder.flagsIv.setImageResource(R.drawable.norway);
                break;
            }
            case "SGD": {
                holder.flagsIv.setImageResource(R.drawable.singapore);
                break;
            }
            case "SEK": {
                holder.flagsIv.setImageResource(R.drawable.sweden);
                break;
            }
            case "JPY": {
                holder.flagsIv.setImageResource(R.drawable.japan);
                break;
            }
            case "AZN": {
                holder.flagsIv.setImageResource(R.drawable.azerbaijan);
                break;
            }
            case "AMD": {
                holder.flagsIv.setImageResource(R.drawable.armenia);
                break;
            }
            case "GEL": {
                holder.flagsIv.setImageResource(R.drawable.georgia);
                break;
            }
            case "MDL": {
                holder.flagsIv.setImageResource(R.drawable.moldova);
                break;
            }
            case "UAH": {
                holder.flagsIv.setImageResource(R.drawable.ukraine);
                break;
            }
            case "AED": {
                holder.flagsIv.setImageResource(R.drawable.uae);
                break;
            }
            case "SAR": {
                holder.flagsIv.setImageResource(R.drawable.saudi);
                break;
            }
            case "INR": {
                holder.flagsIv.setImageResource(R.drawable.india);
                break;
            }
            case "PLN": {
                holder.flagsIv.setImageResource(R.drawable.poland);
                break;
            }
            case "MYR": {
                holder.flagsIv.setImageResource(R.drawable.malaysia);
                break;
            }
            case "THB": {
                holder.flagsIv.setImageResource(R.drawable.thailand);
                break;
            }
            default:
                holder.flagsIv.setImageResource(R.drawable.usa);
                break;

        }

        /*int id = context.getResources().getIdentifier(BuildConfig.APPLICATION_ID + ":drawable/" + res, null, null);
        Log.d("LOG_ID_0", "" + id);
        holder.flagsIv.setImageResource(id);*/

        holder.nominalTv.setText(String.valueOf(item.getNominal()));
        holder.valueTv.setText(String.valueOf(item.getValue()));
        holder.nameTv.setText(item.getName());
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    class ValuteViewHolder extends RecyclerView.ViewHolder {

        TextView charCodeTv;
        TextView nominalTv;
        TextView nameTv;
        TextView valueTv;
        ImageView flagsIv;

        public ValuteViewHolder(@NonNull View itemView) {
            super(itemView);
            charCodeTv = itemView.findViewById(R.id.charcode_text);
            nominalTv = itemView.findViewById(R.id.nominal_text);
            nameTv = itemView.findViewById(R.id.name_text);
            valueTv = itemView.findViewById(R.id.value_text);
            flagsIv = itemView.findViewById(R.id.country_flags);


        }
    }
}
