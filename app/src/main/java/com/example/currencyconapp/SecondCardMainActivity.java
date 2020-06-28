package com.example.currencyconapp;

public class SecondCardMainActivity {

    String charcode;
    String name;
    String value;
    String option;
    int image;



    public SecondCardMainActivity(String charcode, String name, String value, String option, int image){
        this.charcode = charcode;
        this.name = name;
        this.value = value;
        this.option = option;
        this.image = image;
    }


    public String getCharcode() { return charcode; }
    public String getName() { return name; }
    public String getValue() { return value; }
    public String getOption() { return option; }
    public int getImage() { return image; }



}
