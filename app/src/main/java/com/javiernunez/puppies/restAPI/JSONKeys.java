package com.javiernunez.puppies.restAPI;

/**
 * Created by Javier Núñez on 26/06/2016.
 */
public class JSONKeys {
    public static final String RESPONSE_ARRAY               = "data";

    public static final String USER_ID                      = "id";
    public static final String USER_FULLNAME                = "full_name";
    public static final String USER_URL_PROFILE_PICTURE     = "profile_picture";

    public static final String MEDIA_ID                     = "id";
    public static final String MEDIA_IMAGES                 = "images";
    public static final String MEDIA_STANDARD_RESOLUTION    = "standard_resolution";
    public static final String MEDIA_URL                    = "url";
    public static final String MEDIA_LIKES                  = "likes";
    public static final String MEDIA_LIKES_COUNT            = "count";

    //2016-07-12 retorno del código del like
    public static final String LIKE_META                    = "meta";
    public static final String LIKE_META_CODE               = "code";

    //2016-07-14 para sacar el id de usuario de una foto
    public static final String MEDIA_USER                  = "user";
    //USER_ID
    //USER_URL_PROFILE_PICTURE

}
