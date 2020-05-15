package com.example.appaudiobook.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@SuppressWarnings("deprecation")
public class Goiy implements Serializable {

@SerializedName("IdGoiy")
@Expose
private String idGoiy;
@SerializedName("Hinhanh")
@Expose
private String hinhanh;
@SerializedName("Noidung")
@Expose
private String noidung;
@SerializedName("idtruyen")
@Expose
private String idtruyen;
@SerializedName("Tentruyen")
@Expose
private String tentruyen;
@SerializedName("Hinhtruyen")
@Expose
private String hinhtruyen;

public String getIdGoiy() {
return idGoiy;
}

public void setIdGoiy(String idGoiy) {
this.idGoiy = idGoiy;
}

public String getHinhanh() {
return hinhanh;
}

public void setHinhanh(String hinhanh) {
this.hinhanh = hinhanh;
}

public String getNoidung() {
return noidung;
}

public void setNoidung(String noidung) {
this.noidung = noidung;
}

public String getIdtruyen() {
return idtruyen;
}

public void setIdtruyen(String idtruyen) {
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

}
