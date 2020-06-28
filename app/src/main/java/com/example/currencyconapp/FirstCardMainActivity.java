package com.example.currencyconapp;

public class FirstCardMainActivity {


    String charcode;
    String name;
    int image;



    public FirstCardMainActivity(String charcode, String name, int image){
        this.charcode = charcode;
        this.name = name;
        this.image = image;
    }

    public String getCharcode() { return charcode; }
    public String getName() { return name; }
    public int getImage() { return image; }



}
