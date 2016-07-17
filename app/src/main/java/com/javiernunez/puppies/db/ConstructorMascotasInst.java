package com.javiernunez.puppies.db;

import android.content.Context;

import com.javiernunez.puppies.pojo.MascotaInst;

import java.util.ArrayList;

/**
 * Created by Javier Núñez on 26/06/2016.
 */
public class ConstructorMascotasInst {
    private Context contexto;
    public ConstructorMascotasInst (Context contexto){
        this.contexto=contexto;
    }

    /*//Prueba obtenerDatos fijos
    public ArrayList<MascotaInst> obtenerDatosInst(){
        ArrayList<MascotaInst> mascotasInst=new ArrayList<MascotaInst>();
        mascotasInst.add(new MascotaInst("id1",5,"https://scontent.cdninstagram.com/t51.2885-15/s150x150/e35/c69.0.181.181/13414149_154228401649553_1751874799_n.jpg?ig_cache_key=MTI4MDU2Mjc1MzkxMjUwMzg0MA%3D%3D.2.c"));
        mascotasInst.add(new MascotaInst("id2",7,"https://scontent.cdninstagram.com/t51.2885-15/s150x150/e35/c5.0.310.310/13525557_1715943068663990_1996869814_n.jpg?ig_cache_key=MTI4MDU2MjM2NDUxMzUxMDkxMw%3D%3D.2.c"));
        mascotasInst.add(new MascotaInst("id3",9,"https://scontent.cdninstagram.com/t51.2885-15/s150x150/e35/c0.25.320.320/13534056_638606376304881_2076835151_n.jpg?ig_cache_key=MTI4MDU2MTU3OTU4Mjg5MDE3MA%3D%3D.2.c"));
        return mascotasInst;
    }
    */

}
