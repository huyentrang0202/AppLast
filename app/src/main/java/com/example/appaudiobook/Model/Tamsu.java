package com.example.appaudiobook.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@SuppressWarnings("deprecation")
public class Tamsu implements Serializable {

@SerializedName("IdTamsu")
@Expose
private String idTamsu;
@SerializedName("Tentieude")
@Expose
private String tentieude;
@SerializedName("Hinhanh")
@Expose
private String hinhanh;

public String getIdTamsu() {
return idTamsu;
}

public void setIdTamsu(String idTamsu) {
this.idTamsu = idTamsu;
}

public String getTentieude() {
return tentieude;
}

public void setTentieude(String tentieude) {
this.tentieude = tentieude;
}

public String getHinhanh() {
return hinhanh;
}

public void setHinhanh(String hinhanh) {
this.hinhanh = hinhanh;
}

}