package com.javiernunez.puppies.restAPIFirebase.adapter;

import com.javiernunez.puppies.restAPIFirebase.ConstantesAPIFirebase;
import com.javiernunez.puppies.restAPIFirebase.EndPointFirebase;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Javier Núñez on 09/07/2016.
 */
public class RestAPIFirebaseAdapter {

    public EndPointFirebase establecerConexionRestAPIFirebase(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstantesAPIFirebase.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                ;
        return retrofit.create(EndPointFirebase.class);
    }
}
