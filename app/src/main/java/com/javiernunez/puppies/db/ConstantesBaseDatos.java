package com.javiernunez.puppies.db;

/**
 * Created by Javier Núñez on 29/05/2016.
 */
public class ConstantesBaseDatos {
    public static final String DATABASE_NAME = "mascotas";
    public static final int DATABASE_VERSION = 4;

    public static final String TABLE_MASCOTAS           = "mascota";
    public static final String TABLE_MASCOTAS_ID        = "id";
    public static final String TABLE_MASCOTAS_NOMBRE    = "nombre";
    public static final String TABLE_MASCOTAS_FOTO      = "foto";
    public static final String TABLE_MASCOTAS_PUNTOS    = "puntos";

    /*//los likes van en la propia tabla mascotas
    public static final String TABLE_LIKES_MASCOTAS = "contacto_likes";
    public static final String TABLE_LIKES_MASCOTAS_ID = "id";
    public static final String TABLE_LIKES_MASCOTAS_ID_MASCOTA = "id_mascota";
    //no añado número de likes porque cada registro es 1 like; sólo los contaré
    */
}
