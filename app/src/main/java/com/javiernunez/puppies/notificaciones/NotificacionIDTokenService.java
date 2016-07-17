package com.javiernunez.puppies.notificaciones;

import android.util.Log;
import android.widget.Toast;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by Javier Núñez on 09/07/2016.
 */
public class NotificacionIDTokenService extends FirebaseInstanceIdService {

    private static final String TAG = "FB_TOKEN";

    @Override
    public void onTokenRefresh() {
        //super.onTokenRefresh();
        String token = FirebaseInstanceId.getInstance().getToken();
        enviarTokenRegistro(token);
    }

    private void enviarTokenRegistro(String token){
        Toast.makeText(NotificacionIDTokenService.this, token, Toast.LENGTH_SHORT).show();
        Log.d(TAG,token);
    }
}
