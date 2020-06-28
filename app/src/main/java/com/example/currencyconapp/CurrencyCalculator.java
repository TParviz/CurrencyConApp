package com.example.currencyconapp;

import android.app.Activity;

import android.content.Context;
import android.os.Bundle;

import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

import java.text.DecimalFormat;
import java.util.regex.Pattern;

public class CurrencyCalculator extends AppCompatActivity {

    String[] data = {"Афганский Афган", "Армянский Драм", "Беларусский Рубль", "Датский Крон", "Британский Фунт"};
    String[] data1 = {"Афганский Афган", "Армянский Драм", "Беларусский Рубль", "Датский Крон", "Британский Фунт"};
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





    View view = this.getCurrentFocus();

    /*private DecimalFormat decimalFormat;
    private double valueOne = Double.NaN;
    private double valueTwo;

    // private ActivityMainBinding binding;*/


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator_layout);



        btnone = (Button) findViewById(R.id.btn_one);
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
                float valuteInt = 0;

                if (txtInput.getText().length() > 0) {
                    valuteInt = Float.valueOf(txtInput.getText().toString());
                }
                if (valuteInt > 0) {
                    txtOutput.setText(Float.toString(valuteInt * 69.78f));
                }
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




        // адаптер
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, data);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }

        getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN
        );


        InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);

        Spinner spinner = (Spinner) findViewById(R.id.spinner_one);
        spinner.setAdapter(adapter);

        // заголовок
        spinner.setPrompt("USD - Доллар США");
        // выделяем элемент
        spinner.setSelection(2);
        // устанавливаем обработчик нажатия
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                // показываем позиция нажатого элемента

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });

        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, data1);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Spinner spinner1 = (Spinner) findViewById(R.id.spinner_two);
        spinner1.setAdapter(adapter1);

        // заголовок
        spinner1.setPrompt("USD - Доллар США");
        // выделяем элемент
        spinner1.setSelection(2);
        // устанавливаем обработчик нажатия
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {


            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });

        txtInput.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                EditText edittext = (EditText) v;
                int inType = edittext.getInputType();       // Backup the input type
                edittext.setInputType(InputType.TYPE_NULL); // Disable standard keyboard

                edittext.onTouchEvent(event);               // Call native handler

                float x = event.getX();
                float y = event.getY();
                int touchPosition = edittext.getOffsetForPosition(x, y);
                if (touchPosition > 0) {
                    edittext.setSelection(touchPosition);
                }
                edittext.setInputType(inType);              // Restore input type
                return true; // Consume touch event
            }
        });
    }


}








