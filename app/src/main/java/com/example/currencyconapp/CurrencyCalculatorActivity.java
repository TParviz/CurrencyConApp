package com.example.currencyconapp;

import android.app.Activity;

import android.content.Context;
import android.os.Bundle;

import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class CurrencyCalculatorActivity extends AppCompatActivity {

    List<Valute> dataset;

    RecyclerView recyclerView;
    List<Valute> valuteList;
    List<String> namesList = new ArrayList<>();
    RecyclerAdapter recyclerAdapter;
    Spinner spinner1;
    TextView textView;
    List<Double> valueList = new ArrayList<>();
    Map<String, Double> hashMap = new HashMap<String, Double>();





    Button btnone;
    Button btntwo;
    Button btnthree;
    Button btnfour;
    Button btnfive;
    Button btnsix;
    Button btnseven;
    Button btneight;
    Button btnnine;
    Button btndelete;
    Button btndot;
    Button btnclear;
    Button btntriplezero;
    Button btndoublezero;
    Button btnzero;
    EditText txtInput;
    TextView txtOutput;
    ImageView image;


    View view = this.getCurrentFocus();
    private Double currencyVal;

    /*private DecimalFormat decimalFormat;
    private double valueOne = Double.NaN;
    private double valueTwo;

    // private ActivityMainBinding binding;*/


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator_layout);

        String[] valuteNames = getIntent().getStringArrayExtra("valuteNamesList");
        spinner1 = (Spinner) findViewById(R.id.spinner_two);
/*
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, valuteNames);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Spinner spinner1 = (Spinner) findViewById(R.id.spinner_two);
        spinner1.setAdapter(adapter1);*/
        final MutableLiveData<List<Valute>> names = new MutableLiveData<>();


        btnone = (Button) findViewById(R.id.btn_one);
        image = (ImageView) findViewById(R.id.second_image_converter_layout);
        btntwo = (Button) findViewById(R.id.btn_two);
        btnthree = (Button) findViewById(R.id.btn_three);
        btnfour = (Button) findViewById(R.id.btn_four);
        btnfive = (Button) findViewById(R.id.btn_five);
        btnsix = (Button) findViewById(R.id.btn_six);
        btnseven = (Button) findViewById(R.id.btn_seven);
        btneight = (Button) findViewById(R.id.btn_eight);
        btnnine = (Button) findViewById(R.id.btn_nine);
        btndelete = (Button) findViewById(R.id.btn_delete);
        btndot = (Button) findViewById(R.id.btn_dot);
        btnclear = (Button) findViewById(R.id.btn_clear);
        btntriplezero = (Button) findViewById(R.id.btn_triple_zero);
        btndoublezero = (Button) findViewById(R.id.btn_double_zero);
        btnzero = (Button) findViewById(R.id.btn_zero);

        txtInput = (EditText) findViewById(R.id.txt_input);
        txtOutput = (TextView) findViewById(R.id.txt_output);

        txtInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
//                double valuteInt = 0;
//
//                if (txtInput.getText().length() > 0) {
//                    valuteInt = Double.valueOf(txtOutput.getText().toString());
//                }
                String s1 = "0.0";
                if(!s.toString().isEmpty())
                    s1 = s.toString();
                double output = Math.round(Double.parseDouble(s1) * currencyVal * 100.0) / 100.0;
                txtOutput.setText(Double.toString(output));

            }
        });

        names.observe(this, new Observer<List<Valute>>() {
            @Override
            public void onChanged(List<Valute> valutes) {
                namesList.clear();
                for (int i = 0; i < valutes.size(); i++) {

                    namesList.add(valutes.get(i).getName());

                }


                Log.d("myLogs", namesList.toString());

                ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(CurrencyCalculatorActivity.this, android.R.layout.simple_spinner_item, namesList);
                adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

                Spinner spinner1 = (Spinner) findViewById(R.id.spinner_two);
                spinner1.setAdapter(adapter1);

                // recyclerAdapter.submitList(valutes);
            }

        });

        names.observe(this, new Observer<List<Valute>>() {
            @Override
            public void onChanged(List<Valute> valutes) {
                for (Valute v : valutes) {
                    hashMap.put(v.getName(), v.getValue());
                }
            }
        });


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

                Log.d("FILTERED_LIST", "" + valuteList.toString());
                names.postValue(valuteList);

            }
            @Override
            public void onFailure(Call<Valcurs> call, Throwable t) {


                Log.d("TASK_RESP1", "" + t);
            }
        });



        btnone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtInput.setText(txtInput.getText() + "1");
            }
        });
        btntwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtInput.setText(txtInput.getText() + "2");
            }
        });
        btnthree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtInput.setText(txtInput.getText() + "3");
            }
        });
        btnfour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtInput.setText(txtInput.getText() + "4");
            }
        });
        btnfive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtInput.setText(txtInput.getText() + "5");
            }
        });
        btnsix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtInput.setText(txtInput.getText() + "6");
            }
        });
        btnseven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtInput.setText(txtInput.getText() + "7");
            }
        });
        btneight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtInput.setText(txtInput.getText() + "8");
            }
        });
        btnnine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtInput.setText(txtInput.getText() + "9");
            }
        });
        btndot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtInput.setText(txtInput.getText() + ".");
            }
        });
        btntriplezero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtInput.setText(txtInput.getText() + "000");
            }
        });
        btndoublezero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtInput.setText(txtInput.getText() + "00");
            }
        });
        btnzero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtInput.setText(txtInput.getText() + "0");
            }
        });

        btnclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtInput.setText("");
            }
        });


        /*Log.d("SHOW ITEMS NAME", "" + dataset.toString());
        List<String> names = new ArrayList();
        names.add(valute.getName());
        Log.d("SHOW ITEMS NAME", "" + valute);*/

        // адаптер
        /*ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, data);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);*/


        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }

        getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN
        );


        InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);


        // заголовок
        spinner1.setPrompt("USD - Доллар США");
        // выделяем элемент
        spinner1.setSelection(2);
        // устанавливаем обработчик нажатия
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {

                String selectedName = parent.getSelectedItem().toString();
                Log.d("SELECTED_NAME", "" + selectedName);
                currencyVal = hashMap.get(selectedName);




                if (selectedName.equals("Доллари ИМА")) {
                    image.setImageResource(R.drawable.usa);
                }
                if (selectedName.equals("ЕВРО")) {
                    image.setImageResource(R.drawable.europa);
                }
                if (selectedName.equals("Юани Чин")) {
                    image.setImageResource(R.drawable.china);
                }
                if (selectedName.equals("Франки Швейтсария")) {
                    image.setImageResource(R.drawable.swiss);
                }
                /*if (selectedName.equals("Доллари ИМА")) {
                    image.setImageResource(R.drawable.england);
                }
                if (selectedName.equals("Доллари ИМА")) {
                    image.setImageResource(R.drawable.england);
                }
                if (selectedName.equals("Доллари ИМА")) {
                    image.setImageResource(R.drawable.england);
                }
                if (selectedName.equals("Доллари ИМА")) {
                    image.setImageResource(R.drawable.england);
                }
                if (selectedName.equals("Доллари ИМА")) {
                    image.setImageResource(R.drawable.england);
                }
                if (selectedName.equals("Доллари ИМА")) {
                    image.setImageResource(R.drawable.england);
                }
                if (selectedName.equals("Доллари ИМА")) {
                    image.setImageResource(R.drawable.england);
                }
                if (selectedName.equals("Доллари ИМА")) {
                    image.setImageResource(R.drawable.england);
                }
                if (selectedName.equals("Доллари ИМА")) {
                    image.setImageResource(R.drawable.england);
                }
                if (selectedName.equals("Доллари ИМА")) {
                    image.setImageResource(R.drawable.england);
                }
                if (selectedName.equals("Доллари ИМА")) {
                    image.setImageResource(R.drawable.england);
                }
                if (selectedName.equals("Доллари ИМА")) {
                    image.setImageResource(R.drawable.england);
                }*/


            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });

    }


}








