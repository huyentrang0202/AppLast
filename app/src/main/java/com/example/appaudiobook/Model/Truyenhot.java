package com.example.appaudiobook.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class Truyenhot  implements Serializable {

    @SerializedName("idtruyenhot")
    @Expose
    private String idtruyenhot;
    @SerializedName("Tentruyen")
    @Expose
    private String tentruyen;
    @SerializedName("Hinhnen")
    @Expose
    private String hinhnen;
    @SerializedName("Hinhicon")
    @Expose
    private String hinhicon;

    public String getIdtruyenhot() {
        return idtruyenhot;
    }

    public void setIdtruyenhot(String idtruyenhot) {
        this.idtruyenhot = idtruyenhot;
    }

    public String getTentruyen() {
        return tentruyen;
    }

    public void setTentruyen(String tentruyen) {
        this.tentruyen = tentruyen;
    }

    public String getHinhnen() {
        return hinhnen;
    }

    public void setHinhnen(String hinhnen) {
        this.hinhnen = hinhnen;
    }

    public String getHinhicon() {
        return hinhicon;
    }

    public void setHinhicon(String hinhicon) {
        this.hinhicon = hinhicon;
    }

}