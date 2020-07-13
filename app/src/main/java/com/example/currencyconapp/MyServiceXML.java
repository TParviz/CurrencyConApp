package com.example.currencyconapp;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MyServiceXML {
    @GET("tj/kurs/export_xml.php?export=xmlout")
    Call<Valcurs> getMyService(@Query("date") String date);
}
