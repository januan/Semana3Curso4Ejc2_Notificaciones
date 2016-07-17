package com.javiernunez.puppies.presentador;

import android.content.Context;

import com.javiernunez.puppies.db.ConstructorMascotas;
import com.javiernunez.puppies.pojo.Mascota;
import com.javiernunez.puppies.vista_fragment.IRecyclerViewFragmentView;

import java.util.ArrayList;

/**
 * Created by Javier Núñez on 29/05/2016.
 */
public class RecyclerViewFragmentPresenter implements IRecyclerViewFragmentPresenter {

    private IRecyclerViewFragmentView iRecyclerViewFragmentView;
    private Context contexto;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascota> mascotas;

    public RecyclerViewFragmentPresenter(IRecyclerViewFragmentView iRecyclerViewFragmentView, Context contexto) {
        this.iRecyclerViewFragmentView = iRecyclerViewFragmentView;
        this.contexto=contexto;
        obtenerMascotasBaseDatos();
    }

    @Override
    public void obtenerMascotasBaseDatos() {
        constructorMascotas = new ConstructorMascotas(contexto);
        mascotas = constructorMascotas.obtenerDatos();
        mostrarContactosRV();
    }

    @Override
    public void mostrarContactosRV() {
        iRecyclerViewFragmentView.inicializarAdaptadorRecyclerView(iRecyclerViewFragmentView.crearAdaptador(mascotas));
        iRecyclerViewFragmentView.generarLinerLayoutVertical();
    }
}
