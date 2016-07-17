package com.javiernunez.puppies.restAPI;

/**
 * Created by Javier Núñez on 26/06/2016.
 */
public class ConstantesRestAPI {

    public static final String VERSION = "/v1/";
    public static final String ROOT_URL = "https://api.instagram.com" + VERSION;
    public static final String ACCESS_TOKEN = "3452990908.b32711c.9ff0a70e55e2469a8ff7c252092bd14c";
    public static final String KEY_ACCESS_TOKEN = "access_token";

    //EndPoints
    public static final String KEY_GET_RECENT_MEDIA_USER = "users/{userid}/media/recent/";
    public static final String KEY_GET_INFO_USER = "users/search?q=usuario";

    public static final String URL_GET_RECENT_MEDIA_USER = KEY_GET_RECENT_MEDIA_USER + "?" + KEY_ACCESS_TOKEN +"="+ ACCESS_TOKEN;
    public static final String URL_GET_INFO_USER = KEY_GET_INFO_USER + "&" + KEY_ACCESS_TOKEN +"=" + ACCESS_TOKEN;


    //para que muestre algo inicialmente
    public static final String SELF_USER = "3452990908";//"self";
    public static final String DEFAULT_USERNAME = "Javier (Tests)";
    public static final String DEFAULT_URL_PROFILE_IMG = "https://scontent.cdninstagram.com/t51.2885-19/s150x150/13437190_255739358129670_951385194_a.jpg";

    //2016-07-12 Para poder hacer like:
    //EndPoint setLike en Instagram
    public static final String URL_POST_SET_LIKE = "media/{media-id}/likes/";
    //en el POST del like el token va como parámetro ACCESS_TOKEN sobra:+ "&" + KEY_ACCESS_TOKEN + ACCESS_TOKEN;

    //EndPoint para averiguar quién es el dueño de una foto
    public static final String URL_GET_MEDIA_USER = "media/{media-id}?"+KEY_ACCESS_TOKEN+"="+ACCESS_TOKEN;

}
