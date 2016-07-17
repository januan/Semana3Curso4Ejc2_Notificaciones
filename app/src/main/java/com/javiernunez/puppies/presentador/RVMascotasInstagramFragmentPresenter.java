package com.javiernunez.puppies.presentador;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.gson.Gson;
import com.javiernunez.puppies.R;
import com.javiernunez.puppies.db.ConstructorMascotasInst;
import com.javiernunez.puppies.pojo.MascotaInst;
import com.javiernunez.puppies.restAPI.ConstantesRestAPI;
import com.javiernunez.puppies.restAPI.EndPointsAPI;
import com.javiernunez.puppies.restAPI.adapter.RestAPIAdapter;
import com.javiernunez.puppies.restAPI.modelo.MascotaResponse;
import com.javiernunez.puppies.vista_fragment.IRVMascotasInstagramFragmentView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Javier Núñez on 26/06/2016.
 */
public class RVMascotasInstagramFragmentPresenter implements IRVMascotasInstagramFragmentPresenter{
    private IRVMascotasInstagramFragmentView irvMascotasInstagramFragmentView;
    private Context context;
    private ConstructorMascotasInst constructorMascotasInst;
    private ArrayList<MascotaInst> mascotasInst;

    public RVMascotasInstagramFragmentPresenter(IRVMascotasInstagramFragmentView irvMascotasInstagramFragmentView, Context context, String usuarioID){
        this.irvMascotasInstagramFragmentView=irvMascotasInstagramFragmentView;
        this.context=context;
        //obtenerMascotasInstagram();

        obtenerMediosRecientes(usuarioID);


    }


    //2016-06-26
    @Override
    public void obtenerMediosRecientes(String userID) {
        //Toast.makeText(context, "Usuario en obtenerMediosRecientes: "+userID, Toast.LENGTH_LONG).show();
        RestAPIAdapter restAPIAdapter = new RestAPIAdapter();
        Gson gsonMediaRecent = restAPIAdapter.construyeGsonDeserializadorMediaRecent();
        EndPointsAPI endPointsAPI= restAPIAdapter.establecerConexionRestAPIInstagram(gsonMediaRecent);
        Call<MascotaResponse> mascotaResponseCall = endPointsAPI.getRecentMedia(userID);

        mascotaResponseCall.enqueue(new Callback<MascotaResponse>() {
            @Override
            public void onResponse(Call<MascotaResponse> call, Response<MascotaResponse> response) {
                MascotaResponse mascotaResponse= response.body(); //contiene la data del JSON
                mascotasInst = mascotaResponse.getMascotas();
                mostrarMascotasInstRV();
            }

            @Override
            public void onFailure(Call<MascotaResponse> call, Throwable t) {
                Toast.makeText(context, "¡Error conectanto! Inténtalo de nuevo", Toast.LENGTH_LONG).show();
                Log.e("Falló conexión WS",t.toString());
            }
        });

    }

    @Override
    public void mostrarMascotasInstRV() {
        irvMascotasInstagramFragmentView.inicializarAdaptadorInstRecyclerView(irvMascotasInstagramFragmentView.crearAdaptador(mascotasInst));
        irvMascotasInstagramFragmentView.generarGridLayout();
    }


}

