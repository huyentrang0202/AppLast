package com.example.appaudiobook.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.appaudiobook.Adapter.DanhsachAlltheloaiAdapter;
import com.example.appaudiobook.Model.TheLoai;
import com.example.appaudiobook.R;
import com.example.appaudiobook.Service.APIService;
import com.example.appaudiobook.Service.Dataservice;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DanhsachalltheloaiActivity extends AppCompatActivity {
RecyclerView recyclerView;
Toolbar toolbar;
DanhsachAlltheloaiAdapter danhsachAlltheloaiAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danhsachalltheloai);
        GetData();
        anhxa();
    }

    private void GetData() {
        Dataservice dataservice = APIService.getService();
        Call<List<TheLoai>> callback = dataservice.GetAllTheloai();
        callback.enqueue(new Callback<List<TheLoai>>() {
            @Override
            public void onResponse(Call<List<TheLoai>> call, Response<List<TheLoai>> response) {
                ArrayList<TheLoai> mangtheloai = (ArrayList<TheLoai>) response.body();
                danhsachAlltheloaiAdapter = new DanhsachAlltheloaiAdapter(DanhsachalltheloaiActivity.this,mangtheloai);
                recyclerView.setLayoutManager(new GridLayoutManager(DanhsachalltheloaiActivity.this,2));
                recyclerView.setAdapter(danhsachAlltheloaiAdapter);
            }

            @Override
            public void onFailure(Call<List<TheLoai>> call, Throwable t) {

            }
        });

    }

    private void anhxa() {
        recyclerView = findViewById(R.id.recycrviewTheloai);
        toolbar = findViewById(R.id.toolbartheloai);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Tất Cả Thể Loại");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


}
