package com.example.currencyconapp;


import android.media.audiofx.AcousticEchoCanceler;
import android.widget.ImageView;

public class ThirdPageActivity  {
//    private String title;

     String charcode;
     //String nominal;
     //String value;
     String name;
     //String publicationDate;
     int image;
     String tCharcode;



    public ThirdPageActivity(String charcode, String name, int image){
   //     this.title =title;
        this.charcode = charcode;
   //     this.nominal = nominal;
    //    this.value = value;
        this.name = name;
        this.image = image;
     //   this.publicationDate = publicationDate;
     //   this.countryflags = countryflags;
    }



   // public String  getTitle(){ return title; }

//    public void setTitle(String title) {this.title = title; }

  //  public ImageView getCountryflags(){return countryflags;}

 //   public void setCountryflags(ImageView countryflags) {this.countryflags = countryflags; }


    public String getCharcode() { return charcode; }


  //  public void setCharcode(String charcode) { this.charcode = charcode; }

  //  public String getNominal() { return nominal; }

 //   public void setNominal(String nominal) { this.nominal = nominal; }

  //  public String getValue() { return value; }

  //  public void setValue(String value) { this.value = value; }

    public String getName() { return name; }
    public int getImage() { return image; }


  //  public void setName(String name) { this.name = name; }

 //   public String getPublicationDate() { return publicationDate; }

 // public void setPublicationDate(String publicationDate) { this.publicationDate = publicationDate; }
}
