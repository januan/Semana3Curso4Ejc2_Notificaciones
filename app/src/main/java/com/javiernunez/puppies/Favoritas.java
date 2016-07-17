package com.javiernunez.puppies;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.javiernunez.puppies.adapter.MascotaAdaptador;
import com.javiernunez.puppies.db.BaseDatos;
import com.javiernunez.puppies.menu_opciones.PedirUsuarioInstagram;
import com.javiernunez.puppies.menu_opciones.acercade;
import com.javiernunez.puppies.menu_opciones.contacto;
import com.javiernunez.puppies.pojo.Mascota;

import java.util.ArrayList;

public class Favoritas extends AppCompatActivity {

    ArrayList<Mascota> mascotasFav;
    private RecyclerView listaMascotasFav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritas);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //quito imagen 5 estrellas
        ImageView img5Stars= (ImageView) findViewById(R.id.imgFiveStarts);
        img5Stars.setVisibility(View.INVISIBLE);

        //recibe datos mascotas -> ToDo ver cómo pasar un listado
        /*
        Bundle parametros = getIntent().getExtras();
        mascotasFav =  (ArrayList<Mascota>) getIntent().getSerializableExtra("listado");
        */


        listaMascotasFav= (RecyclerView) findViewById(R.id.rvMascotasFavoritas);


        //GridLayoutManager lm = new GridLayoutManager(this,2);
        LinearLayoutManager lm = new LinearLayoutManager(this);
        lm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotasFav.setLayoutManager(lm);
        inicializaListaMascotasFav();
        inicializarAdaptador();


    }

    public void inicializarAdaptador(){
        //crea objeto mascotaAdaptador para que reciba la lista y que pueda hacer lo configurado
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotasFav);
        listaMascotasFav.setAdapter(adaptador);
    }

    public void inicializaListaMascotasFav(){
        mascotasFav = new ArrayList<Mascota>();
        BaseDatos db = new BaseDatos(getApplicationContext());
        mascotasFav = db.obtenerMascotasFavoritas();
/*
        mascotasFav.add(new Mascota(R.drawable.mascota4,"Marroncete"));
        mascotasFav.add(new Mascota(R.drawable.mascota3,"Hamster"));
        mascotasFav.add(new Mascota(R.drawable.mascota6,"Juguetón"));
        mascotasFav.add(new Mascota(R.drawable.mascota1,"Scooby"));
        mascotasFav.add(new Mascota(R.drawable.mascota2, "Infantil"));
*/
    }

    // ToDo -> Menú Opciones - guardar en clase aparte para manejarlo una única vez
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //return super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.mContacto:
                Intent intentContacto = new Intent(this, contacto.class);
                startActivity(intentContacto);
                break;
            case R.id.mAcercaDe:
                Intent intentAcercade= new Intent(this, acercade.class);
                startActivity(intentAcercade);
                break;
            case R.id.mPedirUsuarioInstagram:
                Intent intentPedirUsuarioInstagram = new Intent(this, PedirUsuarioInstagram.class);
                startActivity(intentPedirUsuarioInstagram);
                break;

        }

        return super.onOptionsItemSelected(item);
    }
}
