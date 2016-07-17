package com.javiernunez.puppies.pojo;

/**
 * Created by Javier Núñez on 26/06/2016.
 */
public class UsuarioInst {
    private String id;
    private String fullName;
    private String urlFotoPerfil;

    public UsuarioInst(String id, String fullName, String urlFotoPerfil) {
        this.id = id;
        this.fullName = fullName;
        this.urlFotoPerfil = urlFotoPerfil;
    }

    public UsuarioInst(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUrlFotoPerfil() {
        return urlFotoPerfil;
    }

    public void setUrlFotoPerfil(String urlFotoPerfil) {
        this.urlFotoPerfil = urlFotoPerfil;
    }
}
