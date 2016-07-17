package com.javiernunez.puppies.restAPI.adapter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.javiernunez.puppies.restAPI.ConstantesRestAPI;
import com.javiernunez.puppies.restAPI.EndPointsAPI;
import com.javiernunez.puppies.restAPI.deserializador.LikeDeserializador;
import com.javiernunez.puppies.restAPI.deserializador.MascotaDeserializador;
import com.javiernunez.puppies.restAPI.deserializador.MediaDeserializador;
import com.javiernunez.puppies.restAPI.deserializador.UsuarioInstDeserializador;
import com.javiernunez.puppies.restAPI.modelo.LikeResponse;
import com.javiernunez.puppies.restAPI.modelo.MascotaResponse;
import com.javiernunez.puppies.restAPI.modelo.MediaResponse;
import com.javiernunez.puppies.restAPI.modelo.UsuarioResponse;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Javier Núñez on 26/06/2016.
 */
public class RestAPIAdapter {

    public EndPointsAPI establecerConexionRestAPIInstagram(Gson gson){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstantesRestAPI.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        return retrofit.create(EndPointsAPI.class);
    }

    public Gson construyeGsonDeserializadorMediaRecent(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(MascotaResponse.class, new MascotaDeserializador());
        return gsonBuilder.create();
    }

    public Gson construyeGsonDeserializadorDatosUsuario(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(UsuarioResponse.class, new UsuarioInstDeserializador());
        return gsonBuilder.create();
    }

    //2016-07-12
    public Gson contruyeGsonDeserializadorLike(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(LikeResponse.class, new LikeDeserializador());
        return gsonBuilder.create();
    }

    //2016-07-14
    public Gson construyeGsonDeserializadorMediaUsr(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(MediaResponse.class, new MediaDeserializador());
        return gsonBuilder.create();
    }

}
