package com.example.appaudiobook.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appaudiobook.Activity.DanhsachalltheloaiActivity;
import com.example.appaudiobook.Adapter.TheLoaiAdapter;
import com.example.appaudiobook.Model.TheLoai;
import com.example.appaudiobook.R;
import com.example.appaudiobook.Service.APIService;
import com.example.appaudiobook.Service.Dataservice;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_TheLoai extends Fragment {
    View view;
    RecyclerView recyclerViewtheloai;
    TextView txtxemthemtheloai;
    TheLoaiAdapter theLoaiAdapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_theloai,container,false);
        recyclerViewtheloai = view.findViewById(R.id.recyclerviewtheloai);
        txtxemthemtheloai = view.findViewById(R.id.textviewxemthemtheloai);

        txtxemthemtheloai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), DanhsachalltheloaiActivity.class);
                startActivity(intent);
            }
        });

        GetData();

        return view;
    }

    private void GetData() {
        Dataservice dataservice = APIService.getService();

        Call<List<TheLoai>> callback = dataservice.GetTheLoai();
        callback.enqueue(new Callback<List<TheLoai>>() {
            @Override
            public void onResponse(Call<List<TheLoai>> call, Response<List<TheLoai>> response) {
                ArrayList<TheLoai> theLoaiArrayList = (ArrayList<TheLoai>) response.body();
                theLoaiAdapter = new TheLoaiAdapter(getActivity(),theLoaiArrayList);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                recyclerViewtheloai.setLayoutManager(linearLayoutManager);
                recyclerViewtheloai.setAdapter(theLoaiAdapter  );
            }

            @Override
            public void onFailure(Call<List<TheLoai>> call, Throwable t) {

            }
        });
    }
}
