package com.example.currencyconapp;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.Date;
import java.util.List;

@Root(name = "valcurs")
public class Valcurs {

    @Attribute(name = "Date")
    String date;

    @Attribute(name = "name")
    String name;

    @ElementList(name="Valute", inline = true)
    List<Valute> valuteList;


}


