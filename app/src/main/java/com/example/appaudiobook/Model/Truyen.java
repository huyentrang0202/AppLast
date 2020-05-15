package com.example.appaudiobook.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@SuppressWarnings("deprecation")
public class Truyen implements Parcelable{

@SerializedName("Idtruyen")
@Expose
private Object idtruyen;
@SerializedName("Tentruyen")
@Expose
private String tentruyen;
@SerializedName("Hinhtruyen")
@Expose
private String hinhtruyen;
@SerializedName("Tacgia")
@Expose
private String tacgia;
@SerializedName("Diendoc")
@Expose
private String diendoc;
@SerializedName("Linktruyen")
@Expose
private String linktruyen;

    protected Truyen(Parcel in) {
        tentruyen = in.readString();
        hinhtruyen = in.readString();
        tacgia = in.readString();
        diendoc = in.readString();
        linktruyen = in.readString();
    }

    public static final Creator<Truyen> CREATOR = new Creator<Truyen>() {
        @Override
        public Truyen createFromParcel(Parcel in) {
            return new Truyen(in);
        }

        @Override
        public Truyen[] newArray(int size) {
            return new Truyen[size];
        }
    };

    public Object getIdtruyen() {
return idtruyen;
}

public void setIdtruyen(Object idtruyen) {
this.idtruyen = idtruyen;
}

public String getTentruyen() {
return tentruyen;
}

public void setTentruyen(String tentruyen) {
this.tentruyen = tentruyen;
}

public String getHinhtruyen() {
return hinhtruyen;
}

public void setHinhtruyen(String hinhtruyen) {
this.hinhtruyen = hinhtruyen;
}

public String getTacgia() {
return tacgia;
}

public void setTacgia(String tacgia) {
this.tacgia = tacgia;
}

public String getDiendoc() {
return diendoc;
}

public void setDiendoc(String diendoc) {
this.diendoc = diendoc;
}

public String getLinktruyen() {
return linktruyen;
}

public void setLinktruyen(String linktruyen) {
this.linktruyen = linktruyen;
}

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(tentruyen);
        dest.writeString(hinhtruyen);
        dest.writeString(tacgia);
        dest.writeString(diendoc);
        dest.writeString(linktruyen);
    }
}