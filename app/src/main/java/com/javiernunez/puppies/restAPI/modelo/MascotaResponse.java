package com.javiernunez.puppies.restAPI.modelo;

import com.javiernunez.puppies.pojo.Mascota;
import com.javiernunez.puppies.pojo.MascotaInst;

import java.util.ArrayList;

/**
 * Created by Javier Núñez on 26/06/2016.
 */
public class MascotaResponse {
    ArrayList<MascotaInst> mascotas;

    public ArrayList<MascotaInst> getMascotas() {
        return mascotas;
    }

    public void setMascotas(ArrayList<MascotaInst> mascotas) {
        this.mascotas = mascotas;
    }
}
