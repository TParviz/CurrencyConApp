package com.example.currencyconapp;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ThirdPageMainActivity extends AppCompatActivity {
    private static RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView recyclerView;
    private static ArrayList<ThirdPageActivity> data;



    // private RecyclerView resultlist;
    //private ThirdActivityAdapter adapter;


    ListView listView;

   /* String mCharcode[] = {"AFG", "ARM", "BEL", "DEN", "GBP"};
    String mName[] = {"Афганский Афган", "Армянский Драм", "Беларусский Рубль", "Датский Крон", "Британский Фунт"};
    int images[] = {
            R.drawable.afghanistan,
            R.drawable.armenia,
            R.drawable.belarus,
            R.drawable.denmark,
            R.drawable.england,

    };*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_page_activity_recycler);
        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());



        data = new ArrayList<ThirdPageActivity>();
        for (int i = 0; i < MyData.nameArray.length; i++) {
            data.add(new ThirdPageActivity(MyData.charcodeArray[i], MyData.nameArray[i], MyData.drawableArray[i]));
        }
        adapter = new ThirdActivityAdapter(data);
        recyclerView.setAdapter(adapter);

    }



}









































































/*



    //    resultlist = findViewById(R.id.listView);
     //   setupRecycler();

    //    RecyclerView gallery = (RecyclerView) findViewById(R.id.country_flags);
    //    gallery.setAdapter(new GalleryImageAdapter(this, R.layout.img));

    }

    class MyAdapter extends ArrayAdapter<String> {
        Context context;
        String rCharcode[];
        String rName[];
        int rImages[];

        MyAdapter (ThirdPageMainActivity c, String[] charCode, String[] nameText, int[] imgs){
            super(c, R.layout.third_page_activity, R.id.charcode_text, charCode, R.id.name_text, nameText);

            this.context = c;
            this.rCharcode = charCode;
            this.rName = nameText;
            this.rImages = imgs;

        }

    }

  *//*  private void setupRecycler(){
        resultlist.setHasFixedSize(true);
        resultlist.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        adapter = new ThirdActivityAdapter();
        ArrayList<ThirdPageActivity> items = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ThirdPageActivity item = new ThirdPageActivity("Title" + (i + 1), "CharCode" + (i + 1), "Nominal" + (i + 1), "Value" + (i + 1), "Name" + (i + 1), "Date" + (i + 1)) ;
            items.add(item);

        }
        adapter.populateList(items);
        resultlist.setAdapter(adapter);

    }*/


