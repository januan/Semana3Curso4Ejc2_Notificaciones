package com.javiernunez.puppies.vista_fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.javiernunez.puppies.MainActivity;
import com.javiernunez.puppies.R;
import com.javiernunez.puppies.adapter.MascotaInstagramAdaptador;
import com.javiernunez.puppies.pojo.MascotaInst;
import com.javiernunez.puppies.pojo.UsuarioInst;
import com.javiernunez.puppies.presentador.IRVMascotasInstagramFragmentPresenter;
import com.javiernunez.puppies.presentador.RVMascotasInstagramFragmentPresenter;
import com.mikhaellopez.circularimageview.CircularImageView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Javier Núñez on 26/06/2016.
 */
public class RVMascotasInstagramFragment extends Fragment implements IRVMascotasInstagramFragmentView {
    ArrayList<MascotaInst> mascotasInst;
    private RecyclerView rvMascotasInst;
    private IRVMascotasInstagramFragmentPresenter presentador;

    private CircularImageView circularImageView;
    private TextView tvNombre ;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_mascota, container,false);

        //Para recoger el usuario de la actividad
        MainActivity actividad = (MainActivity) getActivity();
        //Toast.makeText(getContext(), "El usuario dentro fragment es "+actividad.getUsuarioID(), Toast.LENGTH_LONG).show();

        circularImageView = (CircularImageView) v.findViewById(R.id.circularImageView);
        circularImageView.setBorderWidth(5 * (int) getResources().getDisplayMetrics().density);
        circularImageView.setShadowRadius(0);
        //circularImageView.setBorderColor();

        tvNombre = (TextView) v.findViewById(R.id.tvNombreMascotaInst);
        //nombre Completo del perfil de usuario
        tvNombre.setText(actividad.getNomUsuario());
        //imagen
        Picasso.with(actividad)
                .load(actividad.getUrlUsuario())
                .placeholder(R.drawable.dog)
                .into(circularImageView);

        rvMascotasInst= (RecyclerView) v.findViewById(R.id.rvMascotaInst);
        presentador = new RVMascotasInstagramFragmentPresenter(this,getContext(),actividad.getUsuarioID());
        return v;
    }

    @Override
    public void generarGridLayout() {
        GridLayoutManager lm = new GridLayoutManager(getContext(),3);
        rvMascotasInst.setLayoutManager(lm);
    }

    @Override
    public MascotaInstagramAdaptador crearAdaptador(ArrayList<MascotaInst> mascotasInst) {
        //crea objeto mascotaAdaptador para que reciba la lista y que pueda hacer lo configurado
        MascotaInstagramAdaptador adaptadorInst = new MascotaInstagramAdaptador(mascotasInst,getActivity());
        return adaptadorInst;
    }

    @Override
    public void inicializarAdaptadorInstRecyclerView(MascotaInstagramAdaptador adaptador) {
        rvMascotasInst.setAdapter(adaptador);
    }

    @Override
    public UsuarioInst obtenerDatosUsuario(String nomUsuario) {
        return null;
    }


}
