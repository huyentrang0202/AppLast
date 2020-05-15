package com.example.appaudiobook.Service;

import com.example.appaudiobook.Model.Goiy;
import com.example.appaudiobook.Model.Tamsu;
import com.example.appaudiobook.Model.TheLoai;
import com.example.appaudiobook.Model.Truyen;
import com.example.appaudiobook.Model.Truyenhot;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

@SuppressWarnings("deprecation")
public interface Dataservice {

    @GET("GoiyAudio.php")
    Call<List<Goiy>> GetDataBanner();

    @GET("Truyenhot.php")
    Call<List<Truyenhot>> GetTruyenhotCurrentDay();

    @GET("theloai.php")
    Call<List<TheLoai>> GetTheLoai();

    @GET("tamsu.php")
    Call<List<Tamsu>> GetTamsu();

    @FormUrlEncoded
    @POST("danhsachaudio.php")
    Call<List<Truyen>> GetDanhsachtruyentheogoiy(@Field("idgoiy") String idgoiy);

    @FormUrlEncoded
    @POST("danhsachaudio.php")
    Call<List<Truyen>> GetDanhsachbaihattheotruyenhot(@Field("idtruyenhot") String idtruyenhot);

    @GET("danhsachtruyenhot.php")
    Call<List<Truyenhot>> GetDanhsachcacTruyenhot();

    @GET("tatcatamsu.php")
    Call<List<Tamsu>> GetAllTamSu();

    @FormUrlEncoded
    @POST("danhsachaudio.php")
    Call<List<Truyen>> GetDanhsachtruyentheotamsu(@Field("idtamsu") String idtamsu);

    @GET("danhsachtheloai.php")
    Call<List<TheLoai>> GetAllTheloai();


    @FormUrlEncoded
    @POST("danhsachaudio.php")
    Call<List<Truyen>> GetDanhsachtruyentheotheloai(@Field("idtheloai") String idtheloai);


    @FormUrlEncoded
    @POST("timkiem.php")
    Call<List<Truyen>> Gettimkiemtacpham(@Field("tukhoa")String tukhoa );
}
