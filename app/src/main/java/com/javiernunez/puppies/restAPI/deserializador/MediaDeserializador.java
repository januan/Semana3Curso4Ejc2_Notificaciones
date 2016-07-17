package com.javiernunez.puppies.restAPI.deserializador;

import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.javiernunez.puppies.pojo.MediaInst;
import com.javiernunez.puppies.restAPI.JSONKeys;
import com.javiernunez.puppies.restAPI.modelo.MediaResponse;

import java.lang.reflect.Type;

/**
 * Created by Javier Núñez on 14/07/2016.
 */
public class MediaDeserializador  implements JsonDeserializer<MediaResponse> {

    @Override
    public MediaResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Gson gson = new Gson();
        MediaResponse mediaResponse = gson.fromJson(json,MediaResponse.class);


        JsonObject mediaObj = json.getAsJsonObject();

        JsonObject mediaData=mediaObj.getAsJsonObject(JSONKeys.RESPONSE_ARRAY);
        JsonObject mediaUsrObj = mediaData.getAsJsonObject(JSONKeys.MEDIA_USER);
        String userID=mediaUsrObj.get(JSONKeys.USER_ID).getAsString();
        String userPic=mediaUsrObj.get(JSONKeys.USER_URL_PROFILE_PICTURE).getAsString();

        MediaInst mediaInst=new MediaInst();
        mediaInst.setIdUsuario(userID);
        mediaInst.setFotoUSuario(userPic);

        mediaResponse.setMediaInst(mediaInst);

        return mediaResponse;
    }


}
