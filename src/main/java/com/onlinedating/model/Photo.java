package com.onlinedating.model;

import java.io.File;

/**
 * Created by Aver on 18.06.2015.
 */
public class Photo {
    private int photo_id;
    private byte[] photo;
    private String url;

    public int getPhoto_id() {
        return photo_id;
    }

    public void setPhoto_id(int photo_id) {
        this.photo_id = photo_id;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


}
