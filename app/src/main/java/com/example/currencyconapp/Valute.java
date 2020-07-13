package com.example.currencyconapp;

import android.widget.ImageView;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name="Valute")
public class Valute {
    @Element(name = "CharCode")
    private String charcode;
    @Element(name = "Nominal")
    private int nominal;
    @Element(name = "Name")
    private String name;
    @Element(name = "Value")
    private double value;
    @Attribute(name = "ID")
    private int id;
    private ImageView flags;


    @Override
    public String toString() {
        return "Valute{" +
                "charcode='" + charcode + '\'' +
                ", nominal=" + nominal +
                ", name='" + name + '\'' +
                ", value=" + value +
                ", id=" + id +
                '}';
    }

    /*public Valute(ImageView flags){
        this.setFlags(flags);
    }*/

    public String getCharcode() {
        return charcode;
    }

    public void setCharcode(String charcode) {
        this.charcode = charcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNominal() {
        return nominal;
    }

    public void setNominal(int nominal) {
        this.nominal = nominal;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ImageView getFlags() {
        return flags;
    }

    public void setFlags(ImageView flags) {
        this.flags = flags;
    }
}
