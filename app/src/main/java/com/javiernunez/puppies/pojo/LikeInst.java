package com.javiernunez.puppies.pojo;

/**
 * Created by Javier Núñez on 12/07/2016.
 */
public class LikeInst {

    // para traer el código que devuelve el endPoint al hacer un like
    private int code;

    public LikeInst(int code) {
        this.code = code;
    }

    public LikeInst() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
