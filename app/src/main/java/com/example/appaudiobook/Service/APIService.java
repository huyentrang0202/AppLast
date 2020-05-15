package com.example.appaudiobook.Service;

public class APIService {

    private  static String base_url = "https://music-mp3-pro.000webhostapp.com/Sever/";
    public static  Dataservice getService(){
        return APIRetrofitClient.getClient(base_url).create(Dataservice.class);
    }
}
