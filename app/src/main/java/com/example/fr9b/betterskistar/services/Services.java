package com.example.fr9b.betterskistar.services;

import com.example.fr9b.betterskistar.services.SkistarAPIService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by fr9b on 2018-02-07.
 */


public final class Services {
    private Services(){}

    public static SkistarAPIService getService()
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.skistar.com/myskistar/game/api/v3/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(SkistarAPIService.class);
    }
}

