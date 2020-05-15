package com.example.appaudiobook.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;

import com.example.appaudiobook.Adapter.DanhsachalltruyenhotAdapter;
import com.example.appaudiobook.Adapter.DanhsachaudioAdapter;
import com.example.appaudiobook.Model.Truyenhot;
import com.example.appaudiobook.R;
import com.example.appaudiobook.Service.APIService;
import com.example.appaudiobook.Service.Dataservice;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DanhsachcactruyenhotActivity extends AppCompatActivity {
        Toolbar toolbar;
        RecyclerView recyclerView;
        DanhsachalltruyenhotAdapter danhsachalltruyenhotAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danhsachcactruyenhot);
        toolbar = findViewById(R.id.toolbardanhsachcactruyenhot);
        recyclerView = findViewById(R.id.recyclerviewdanhsachcactruyenhot);
        GetData();
        init();



    }

    private void GetData() {
        Dataservice dataservice = APIService.getService();
        Call<List<Truyenhot>> callback =dataservice.GetDanhsachcacTruyenhot();
        callback.enqueue(new Callback<List<Truyenhot>>() {
            @Override
            public void onResponse(Call<List<Truyenhot>> call, Response<List<Truyenhot>> response) {
                ArrayList<Truyenhot> mangtruyenhot = (ArrayList<Truyenhot>) response.body();
                danhsachalltruyenhotAdapter = new DanhsachalltruyenhotAdapter(DanhsachcactruyenhotActivity.this,mangtruyenhot);
                recyclerView.setLayoutManager(new GridLayoutManager(DanhsachcactruyenhotActivity.this,2));
                recyclerView.setAdapter(danhsachalltruyenhotAdapter);
            }

            @Override
            public void onFailure(Call<List<Truyenhot>> call, Throwable t) {

            }
        });
    }

    private void init() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Truyen Hot");
        toolbar.setTitleTextColor(getResources().getColor(R.color.mautim));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }


}
