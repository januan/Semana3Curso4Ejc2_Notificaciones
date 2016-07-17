package com.javiernunez.puppies.menu_opciones;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.javiernunez.puppies.R;

public class acercade extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_acercade);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //quito imagen 5 estrellas
        ImageView img5Stars= (ImageView) findViewById(R.id.imgFiveStarts);
        img5Stars.setVisibility(View.INVISIBLE);
    }
}
