package com.example.currencyconapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FirstCardMainPageActivity extends AppCompatActivity {
    private static RecyclerView.Adapter adapter1;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView recyclerView;
    private static ArrayList<FirstCardMainActivity> data1;
    private static RecyclerView.Adapter adapter2;
    private static RecyclerView recyclerView1;
    private static ArrayList<SecondCardMainActivity> data2;



    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_page_activity);

        recyclerView = (RecyclerView) findViewById(R.id.first_recycler_view);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        recyclerView1 = (RecyclerView) findViewById(R.id.second_recycler_view);
        recyclerView1.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView1.setLayoutManager(layoutManager);
        recyclerView1.setItemAnimator(new DefaultItemAnimator());



        data1 = new ArrayList<FirstCardMainActivity>();
        for (int i = 0; i < MyData.firstNameArray.length; i++) {
            data1.add(new FirstCardMainActivity(MyData.firstCharcodeArray[i], MyData.firstNameArray[i], MyData.firstDrawableArray[i]));
        }
        adapter1 = new FirstCardMainPageAdapter(data1);
        recyclerView.setAdapter(adapter1);

        data2 = new ArrayList<SecondCardMainActivity>();
        for (int i = 0; i < MyData.secondNameArray.length; i++) {
            data2.add(new SecondCardMainActivity(MyData.secondCharcodeArray[i], MyData.secondNameArray[i], MyData.secondValueArray[i], MyData.secondOptionArray[i], MyData.secondDrawableArray[i]));
        }
        adapter2 = new SecondCardMainPageAdapter(data2);
        recyclerView1.setAdapter(adapter2);

    }

}




