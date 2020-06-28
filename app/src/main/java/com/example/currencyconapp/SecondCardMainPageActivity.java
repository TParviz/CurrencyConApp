package com.example.currencyconapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SecondCardMainPageActivity extends AppCompatActivity {

    private static RecyclerView.Adapter adapter2;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView recyclerView1;
    private static ArrayList<SecondCardMainActivity> data2;



    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_page_activity);

        recyclerView1 = (RecyclerView) findViewById(R.id.second_recycler_view);
        recyclerView1.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView1.setLayoutManager(layoutManager);
        recyclerView1.setItemAnimator(new DefaultItemAnimator());



        data2 = new ArrayList<SecondCardMainActivity>();
        for (int i = 0; i < MyData.secondNameArray.length; i++) {
            data2.add(new SecondCardMainActivity(MyData.secondCharcodeArray[i], MyData.secondNameArray[i], MyData.secondValueArray[i], MyData.secondOptionArray[i], MyData.secondDrawableArray[i]));
        }
        adapter2 = new SecondCardMainPageAdapter(data2);
        recyclerView1.setAdapter(adapter2);

    }

}

