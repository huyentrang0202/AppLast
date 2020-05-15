package com.example.appaudiobook.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

//import com.example.appaudiobook.Adapter.DanhsachaudioAdapter;
import com.example.appaudiobook.Adapter.DanhsachaudioAdapter;
import com.example.appaudiobook.Model.Goiy;
import com.example.appaudiobook.Model.Tamsu;
import com.example.appaudiobook.Model.TheLoai;
import com.example.appaudiobook.Model.Truyen;
import com.example.appaudiobook.Model.Truyenhot;
import com.example.appaudiobook.R;
import com.example.appaudiobook.Service.APIService;
import com.example.appaudiobook.Service.Dataservice;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DanhsachAudioActivity extends AppCompatActivity {


    CoordinatorLayout coordinatorLayout;
    CollapsingToolbarLayout collapsingToolbarLayout;
    Toolbar toolbar;
    RecyclerView recyclerViewdanhsachaudio;
    FloatingActionButton floatingActionButton;
    ImageView imgdanhsachaudio;
    ArrayList<Truyen> mangtruyen;
    Truyenhot truyenhot;
    DanhsachaudioAdapter danhsachaudioAdapter;
    Tamsu tamsu;
    TheLoai theLoai;
    Goiy goiy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danhsach_audio);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Data();
        anhxa();
        init();

        if (goiy != null && !goiy.getTentruyen().equals("")) {
            setValueInView(goiy.getTentruyen(), goiy.getHinhtruyen());
            GetDataGoiy(goiy.getIdGoiy());
        }

        if (truyenhot != null && !truyenhot.getTentruyen().equals("")) {
            setValueInView(truyenhot.getTentruyen(), truyenhot.getHinhnen());
            GetDataTruyenhot(truyenhot.getIdtruyenhot());
        }

        if (tamsu != null && !tamsu.getTentieude().equals("")) {
            setValueInView(tamsu.getTentieude(), tamsu.getHinhanh());
            GetDataTamsu(tamsu.getIdTamsu());
        }
        if (theLoai != null && !theLoai.getTentheloai().equals("")) {
            setValueInView(theLoai.getTentheloai(), theLoai.getHinhtheloai());
            Getdatatheloai(theLoai.getIdtheloai());
        }

    }

    private void GetDataTamsu(String idTamsu) {
        Dataservice dataservice = APIService.getService();
        Call<List<Truyen>> callback = dataservice.GetDanhsachtruyentheotamsu(idTamsu);
        callback.enqueue(new Callback<List<Truyen>>() {
            @Override
            public void onResponse(Call<List<Truyen>> call, Response<List<Truyen>> response) {
                mangtruyen = (ArrayList<Truyen>) response.body();
                danhsachaudioAdapter = new DanhsachaudioAdapter(DanhsachAudioActivity.this, mangtruyen);
                recyclerViewdanhsachaudio.setLayoutManager(new LinearLayoutManager(DanhsachAudioActivity.this));
                recyclerViewdanhsachaudio.setAdapter(danhsachaudioAdapter);
                evenClick();
            }

            @Override
            public void onFailure(Call<List<Truyen>> call, Throwable t) {

            }
        });

    }

    private void Getdatatheloai(String idtheloai) {
        Dataservice dataservice = APIService.getService();
        Call<List<Truyen>> callback = dataservice.GetDanhsachtruyentheotheloai(idtheloai);
        callback.enqueue(new Callback<List<Truyen>>() {
            @Override
            public void onResponse(Call<List<Truyen>> call, Response<List<Truyen>> response) {
                mangtruyen = (ArrayList<Truyen>) response.body();
                danhsachaudioAdapter = new DanhsachaudioAdapter(DanhsachAudioActivity.this, mangtruyen);
                recyclerViewdanhsachaudio.setLayoutManager(new LinearLayoutManager(DanhsachAudioActivity.this));
                recyclerViewdanhsachaudio.setAdapter(danhsachaudioAdapter);
                evenClick();
            }

            @Override
            public void onFailure(Call<List<Truyen>> call, Throwable t) {

            }
        });
    }

    private void GetDataTruyenhot(String idtruyenhot) {
        Dataservice dataservice = APIService.getService();
        Call<List<Truyen>> callback = dataservice.GetDanhsachbaihattheotruyenhot(idtruyenhot);
        callback.enqueue(new Callback<List<Truyen>>() {
            @Override
            public void onResponse(Call<List<Truyen>> call, Response<List<Truyen>> response) {
                mangtruyen = (ArrayList<Truyen>) response.body();
                danhsachaudioAdapter = new DanhsachaudioAdapter(DanhsachAudioActivity.this, mangtruyen);
                recyclerViewdanhsachaudio.setLayoutManager(new LinearLayoutManager(DanhsachAudioActivity.this));
                recyclerViewdanhsachaudio.setAdapter(danhsachaudioAdapter);
                evenClick();
            }

            @Override
            public void onFailure(Call<List<Truyen>> call, Throwable t) {

            }
        });

    }

    @SuppressLint("NewApi")
    private void setValueInView(String ten, String hinh) {
        collapsingToolbarLayout.setTitle(ten);

        try {
            URL url = new URL(hinh);
            Bitmap bitmap = BitmapFactory.decodeStream(url.openConnection().getInputStream());
            BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(), bitmap);
            collapsingToolbarLayout.setBackground(bitmapDrawable);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Picasso.with(this).load(hinh).into(imgdanhsachaudio);
    }

    private void GetDataGoiy(String idGoiy) {
        Dataservice dataservice = APIService.getService();
        Call<List<Truyen>> callback = dataservice.GetDanhsachtruyentheogoiy(idGoiy);
        callback.enqueue(new Callback<List<Truyen>>() {
            @Override
            public void onResponse(Call<List<Truyen>> call, Response<List<Truyen>> response) {
                mangtruyen = (ArrayList<Truyen>) response.body();
                danhsachaudioAdapter = new DanhsachaudioAdapter(DanhsachAudioActivity.this, mangtruyen);
                recyclerViewdanhsachaudio.setLayoutManager(new LinearLayoutManager(DanhsachAudioActivity.this));
                recyclerViewdanhsachaudio.setAdapter(danhsachaudioAdapter);
                evenClick();
            }

            @Override
            public void onFailure(Call<List<Truyen>> call, Throwable t) {

            }
        });

    }


    private void init() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        collapsingToolbarLayout.setExpandedTitleColor(Color.WHITE);
        collapsingToolbarLayout.setCollapsedTitleTextColor(Color.WHITE);
        floatingActionButton.setEnabled(false);
    }


    private void anhxa() {
        coordinatorLayout = findViewById(R.id.cooedinatorlayout);
        collapsingToolbarLayout = findViewById(R.id.collapsingtoolbar);
        toolbar = findViewById(R.id.toolbardanhsach);
        recyclerViewdanhsachaudio = findViewById(R.id.recyclerviewdanhsachaudio);
        imgdanhsachaudio = findViewById(R.id.imageViewdanhsachaudio);
        floatingActionButton = findViewById(R.id.floatactionbutton);

    }

    private void Data() {

        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra("banner")) {
                goiy = (Goiy) intent.getSerializableExtra("banner");

            }


            if (intent.hasExtra("itemptruyenhot")) {
                truyenhot = (Truyenhot) intent.getSerializableExtra("itemptruyenhot");

            }

            if (intent.hasExtra("tamsu")) {
                tamsu = (Tamsu) intent.getSerializableExtra("tamsu");
            }
            if (intent.hasExtra("theloai")) {
                theLoai = (TheLoai) intent.getSerializableExtra("theloai");
            }

        }
    }

    private void evenClick() {
        floatingActionButton.setEnabled(true);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DanhsachAudioActivity.this,PlayAudioActivity.class);
                intent.putExtra("cacaudio", mangtruyen);
                startActivity(intent);

            }
        });
    }
}


