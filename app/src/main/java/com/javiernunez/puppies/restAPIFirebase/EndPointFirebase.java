package com.javiernunez.puppies.restAPIFirebase;

import com.javiernunez.puppies.restAPI.modelo.UsuarioResponse;
import com.javiernunez.puppies.restAPIFirebase.model.UsrIDInstTokenResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by Javier Núñez on 09/07/2016.
 */
public interface EndPointFirebase {

    @FormUrlEncoded
    @POST(ConstantesAPIFirebase.KEY_POST_ID_USR)
    Call<UsrIDInstTokenResponse> registrarTokenID(
            @Field("id_dispositivo") String id_dispositivo,
            @Field("id_usuario_instagram") String id_usuario_instagram,
            @Field("nombre_usuario_instagram") String nombre_usuario_instagram
    );


    //puedo usar de response el mismo, porque me voy a quedar con el id_dispositivo
    @FormUrlEncoded
    @POST(ConstantesAPIFirebase.KEY_POST_LIKE)
    Call<UsrIDInstTokenResponse> darLike(
            @Field("id_dispositivo") String id_dispositivo,
            @Field("id_usuario_instagram") String id_usuario_instagram,
            @Field("id_foto_instagram") String nombre_usuario_instagram
    );

    /*lo cambio a POST
    @GET(ConstantesAPIFirebase.KEY_GET_NOTIFICACION)
    Call<UsrIDInstTokenResponse> notificacionUsuario(
            @Path("id_token") String token,
            @Path("id_usr_inst") String usrInstID,
            @Path("url_foto_usuario") String urlFotoUsr

    );*/
    @FormUrlEncoded
    @POST(ConstantesAPIFirebase.KEY_POST_NOTIFICACION)
    Call<UsrIDInstTokenResponse> notificacionUsuario(
            @Field("id_token") String token,
            @Field("id_usr_inst") String usrInstID,
            @Field("url_foto_usuario") String urlFotoUsr

    );
}
