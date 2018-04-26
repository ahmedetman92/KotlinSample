package com.etisalat.sampletask.bases.network;

import com.etisalat.sampletask.models.Menu;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Ahmed Etman on 4/25/2018.
 */

public interface ApiServices {

    static final String BASE_URL = "https://api.androidhive.info/";


    @GET("pizza/?format=xml")
    Call<Menu> getFood();
}
