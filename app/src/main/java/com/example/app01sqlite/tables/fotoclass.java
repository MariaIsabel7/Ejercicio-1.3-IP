package com.example.app01sqlite.tables;

import java.sql.Blob;

public class fotoclass{

    private Integer id;
    private byte[] image;

    public fotoclass() {}


    public fotoclass(Integer id, byte[] image) {
        this.id = id;
        this.image = image;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }




}


