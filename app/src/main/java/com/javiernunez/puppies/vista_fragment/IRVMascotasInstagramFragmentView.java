package com.javiernunez.puppies.vista_fragment;

import com.javiernunez.puppies.adapter.MascotaInstagramAdaptador;
import com.javiernunez.puppies.pojo.MascotaInst;
import com.javiernunez.puppies.pojo.UsuarioInst;

import java.util.ArrayList;

/**
 * Created by Javier Núñez on 26/06/2016.
 */
public interface IRVMascotasInstagramFragmentView {

    public void generarGridLayout();

    public MascotaInstagramAdaptador crearAdaptador(ArrayList<MascotaInst> mascotas);

    public void inicializarAdaptadorInstRecyclerView(MascotaInstagramAdaptador adaptador);

    public UsuarioInst obtenerDatosUsuario(String nomUsuario);
}
