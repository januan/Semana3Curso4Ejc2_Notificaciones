package com.javiernunez.puppies.vista_fragment;

import com.javiernunez.puppies.adapter.MascotaAdaptador;
import com.javiernunez.puppies.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by Javier Núñez on 29/05/2016.
 */
public interface IRecyclerViewFragmentView {

    public void generarLinerLayoutVertical();

    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas);

    public void inicializarAdaptadorRecyclerView(MascotaAdaptador adaptador);

}
