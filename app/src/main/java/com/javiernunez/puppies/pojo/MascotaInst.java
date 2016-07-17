package com.javiernunez.puppies.pojo;

/**
 * Created by Javier Núñez on 26/06/2016.
 */
public class MascotaInst {
    private String id;
    private int likes;
    private String urlImagen;

    public MascotaInst(String id, int likes, String urlImagen) {
        this.id = id;
        this.likes = likes;
        this.urlImagen = urlImagen;
    }
    public  MascotaInst(){};

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

}
