package com.example.appaudiobook.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appaudiobook.Activity.DanhsachAlltamsuActivity;
import com.example.appaudiobook.Adapter.TamsuAdapter;
import com.example.appaudiobook.Model.Tamsu;
import com.example.appaudiobook.R;
import com.example.appaudiobook.Service.APIService;
import com.example.appaudiobook.Service.Dataservice;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_TamSu extends Fragment {

    View view;
   RecyclerView recyclerView;
    TextView txtxemthemtamsu;
    TamsuAdapter tamsuAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_tamsu,container,false);
        recyclerView = view.findViewById(R.id.recyclerviewtamsu);
        txtxemthemtamsu = view.findViewById(R.id.textviewxemthemtamsu);

        txtxemthemtamsu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),DanhsachAlltamsuActivity.class);
                startActivity(intent);
            }
        });

        GetData();

        return view;
    }

    private void GetData() {

        Dataservice dataservice = APIService.getService();
        Call<List<Tamsu>> callback = dataservice.GetTamsu();
        callback.enqueue(new Callback<List<Tamsu>>() {
            @Override
            public void onResponse(Call<List<Tamsu>> call, Response<List<Tamsu>> response) {
                ArrayList<Tamsu> tamsuArrayList = (ArrayList<Tamsu>) response.body();
                tamsuAdapter = new TamsuAdapter(getActivity(),tamsuArrayList);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                recyclerView.setLayoutManager(linearLayoutManager);
                recyclerView.setAdapter(tamsuAdapter);
            }

            @Override
            public void onFailure(Call<List<Tamsu>> call, Throwable t) {

            }
        });
    }
}
