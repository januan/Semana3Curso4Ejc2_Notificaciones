package com.javiernunez.puppies.vista_fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import com.javiernunez.puppies.MainActivity;
import com.javiernunez.puppies.R;
import com.javiernunez.puppies.adapter.MascotaAdaptador;
import com.javiernunez.puppies.pojo.Mascota;
import com.javiernunez.puppies.presentador.IRecyclerViewFragmentPresenter;
import com.javiernunez.puppies.presentador.RecyclerViewFragmentPresenter;

import java.util.ArrayList;

/**
 * Created by Javier Núñez on 22/05/2016.
 */
public class RecyclerViewFragment extends Fragment implements IRecyclerViewFragmentView {
    ArrayList<Mascota> mascotas;
    private RecyclerView rvListaMascotas;
    private IRecyclerViewFragmentPresenter presentador;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_recyclerview, container,false);

        //return super.onCreateView(inflater, container, savedInstanceState);

        rvListaMascotas= (RecyclerView) v.findViewById(R.id.rvMascotas);
        presentador= new RecyclerViewFragmentPresenter(this, getContext());
        return v;

    }


    @Override
    public void generarLinerLayoutVertical() {
        //GridLayoutManager lm = new GridLayoutManager(this,2);
        LinearLayoutManager lm = new LinearLayoutManager(getActivity());
        lm.setOrientation(LinearLayoutManager.VERTICAL);
        rvListaMascotas.setLayoutManager(lm);
    }

    @Override
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas) {
        //crea objeto mascotaAdaptador para que reciba la lista y que pueda hacer lo configurado
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, getActivity());
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRecyclerView(MascotaAdaptador adaptador) {
        rvListaMascotas.setAdapter(adaptador);
    }

    /* ya no se inicializa aquí, sino en bbdd
    public void inicializarvListaMascotas(){
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota(R.drawable.mascota1,"Scooby"));
        mascotas.add(new Mascota(R.drawable.mascota2,"Infantil"));
        mascotas.add(new Mascota(R.drawable.mascota3,"Hamster"));
        mascotas.add(new Mascota(R.drawable.mascota4,"Marroncete"));
        mascotas.add(new Mascota(R.drawable.mascota5,"Tristón"));
        mascotas.add(new Mascota(R.drawable.mascota6,"Juguetón"));
    }
    */
}
