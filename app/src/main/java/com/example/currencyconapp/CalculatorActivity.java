package com.example.currencyconapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class CalculatorActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Valute> valuteList;
    List<String> namesList = new ArrayList<>();
    RecyclerAdapter recyclerAdapter;
    Spinner spinner;
    TextView textView;
    List<Double> valueList = new ArrayList<>();





    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator_layout);

      //  recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        spinner = (Spinner) findViewById(R.id.spinner_two);
      //  textView = (TextView) findViewById(R.id.third_main_title_text);
      //  setDataInRecyclerView();
      //  final MutableLiveData<List<Valute>> result = new MutableLiveData<>();
        final MutableLiveData<List<Valute>> names = new MutableLiveData<>();
        final MutableLiveData<List<Valute>> values = new MutableLiveData<>();
        values.observe(this, new Observer<List<Valute>>() {
            @Override
            public void onChanged(List<Valute> valutes) {
                valueList.clear();
                for(int i = 0; i< valutes.size(); i++){
                    valueList.add(valutes.get(i).getValue());
                }

                Log.d("ValueLogs", valueList.toString());

            }
        });
        names.observe(this, new Observer<List<Valute>>() {
            @Override
            public void onChanged(List<Valute> valutes) {
                namesList.clear();
                for (int i = 0; i < valutes.size(); i++) {

                    namesList.add(valutes.get(i).getName());
                    namesList.add(valutes.get(i).getCharcode());
                }


                Log.d("myLogs", namesList.toString());

                ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(CalculatorActivity.this, android.R.layout.simple_spinner_item, namesList);
                adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

                Spinner spinner1 = (Spinner) findViewById(R.id.spinner_two);
                spinner1.setAdapter(adapter1);

                // recyclerAdapter.submitList(valutes);
            }

        });


      /*  textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] names = new String[namesList.size()];
                for (int i = 0; i < namesList.size(); i++) {
                    names[i] = namesList.get(i);
                }
                Intent intent = new Intent(MainActivity.this, CurrencyCalculatorActivity.class);
                intent.putExtra("valuteNamesList", names);
                startActivity(intent);

            }
        });*/

        OkHttpClient client = new OkHttpClient().newBuilder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .callTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://nbt.tj/")
                .client(client)
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build();


        Date c = Calendar.getInstance().getTime();
        System.out.println("Current time => " + c);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        String formattedDate = df.format(c);
        Log.d("CURRENT_DATE", "" + formattedDate);
        MyServiceXML myServiceXML = retrofit.create(MyServiceXML.class);
        Call<Valcurs> call = myServiceXML.getMyService(formattedDate);

        call.enqueue(new Callback<Valcurs>() {
            @Override
            public void onResponse(Call<Valcurs> call, Response<Valcurs> response) {
                List<Valute> valuteList = response.body().valuteList;
                //List<String> names  = new ArrayList<>();
                //names.add(Valute.getName());

               /* Log.d("FILTERED_LIST1", "" + valuteList.toString());
                List<Valute> filteredValuteList = new ArrayList<>();
                for (Valute valute : valuteList) {
                    if (valute.getCharcode().equals("USD") || valute.getCharcode().equals("RUB")) {
                        filteredValuteList.add(valute);
                    }
                }
                Log.d("FILTERED_LIST", "" + filteredValuteList.toString());*/
                names.postValue(valuteList);
                values.postValue(valuteList);
            }


            @Override
            public void onFailure(Call<Valcurs> call, Throwable t) {
                // progressDialog.dismiss();

                Log.d("TASK_RESP1", "" + t);
            }
        });


    }





    /*private void setDataInRecyclerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerAdapter = new RecyclerAdapter(this);
        recyclerView.setAdapter(recyclerAdapter);
    }*/

    /*private void spinRetrofit(String responce) {

        try {
            List<Valute> namesValuteList = new ArrayList<>();
            for (Valute valute : valuteList) {
                valute.getName().add(namesValuteList.toString());
            }


        }catch (IOException e ){
            e.printStackTrace();
        }
    }
*/

}


