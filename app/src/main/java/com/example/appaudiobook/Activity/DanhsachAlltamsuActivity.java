package com.example.appaudiobook.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.appaudiobook.Adapter.DanhsachalltamsuAdapter;
import com.example.appaudiobook.Model.Tamsu;
import com.example.appaudiobook.R;
import com.example.appaudiobook.Service.APIService;
import com.example.appaudiobook.Service.Dataservice;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DanhsachAlltamsuActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    Toolbar toolbar;
    DanhsachalltamsuAdapter danhsachalltamsuAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danhsach_alltamsu);
        GetData();
        anhxa();
    }

    private void GetData() {

        Dataservice dataservice = APIService.getService();
        Call<List<Tamsu>> callback = dataservice.GetAllTamSu();
        callback.enqueue(new Callback<List<Tamsu>>() {
            @Override
            public void onResponse(Call<List<Tamsu>> call, Response<List<Tamsu>> response) {
                ArrayList<Tamsu> mangtamsu = (ArrayList<Tamsu>) response.body();
                danhsachalltamsuAdapter = new DanhsachalltamsuAdapter(DanhsachAlltamsuActivity.this,mangtamsu);
                recyclerView.setLayoutManager(new GridLayoutManager(DanhsachAlltamsuActivity.this,2));
                recyclerView.setAdapter(danhsachalltamsuAdapter);
            }

            @Override
            public void onFailure(Call<List<Tamsu>> call, Throwable t) {

            }
        });
    }

    private void anhxa() {
        recyclerView = findViewById(R.id.recycrviewTamsu);
        toolbar = findViewById(R.id.toolbartamsu);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Nhiều Hơn ");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


}
