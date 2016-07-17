package com.javiernunez.puppies.restAPIFirebase;

/**
 * Created by Javier Núñez on 09/07/2016.
 */
public class ConstantesAPIFirebase {
    public static  final String ROOT_URL = "https://warm-stream-32312.herokuapp.com/";
    public static  final String KEY_POST_ID_USR = "registrar-usuario/";
    public static  final String KEY_POST_LIKE = "like-generado/";//{id_dispositivo}/{id_usuario_instagram}/{id_foto_instagram}/";
    // //public static  final String KEY_GET_NOTIFICACION = "notifica-usuario/{id_token}/{id_usr_inst}/";
    // lo cambio a POST para poder enviar la URL sin problemas
    public static  final String KEY_POST_NOTIFICACION = "notifica-usuario/";


}
