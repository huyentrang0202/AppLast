package com.example.appaudiobook.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appaudiobook.Adapter.TimkiemAdapter;
import com.example.appaudiobook.Model.Truyen;
import com.example.appaudiobook.R;
import com.example.appaudiobook.Service.APIService;
import com.example.appaudiobook.Service.Dataservice;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_Timkiem extends Fragment {
    View view;
    Toolbar toolbar;
    RecyclerView recyclerView;
    TextView txtkhongcodulieu;
    TimkiemAdapter timkiemAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_timkiem,container,false);
        toolbar = view.findViewById(R.id.toobartimkiem);
        recyclerView = view.findViewById(R.id.recyclerviewtimkiem);
        txtkhongcodulieu = view.findViewById(R.id.txtkhongcodulieu);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        toolbar.setTitle("");
        setHasOptionsMenu(true);

        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.timkiem_view,menu);
        MenuItem menuItem = menu.findItem(R.id.menutimkiem);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setMaxWidth(Integer.MAX_VALUE);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
              timkiemtukhoa(query);

                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        super.onCreateOptionsMenu(menu, inflater);
    }
    private  void  timkiemtukhoa (String query){
        Dataservice dataservice = APIService.getService();
        Call<List<Truyen>> callback = dataservice.Gettimkiemtacpham(query);
        callback.enqueue(new Callback<List<Truyen>>() {
            @Override
            public void onResponse(Call<List<Truyen>> call, Response<List<Truyen>> response) {
                ArrayList<Truyen> mangtruyen = (ArrayList<Truyen>) response.body();
                if (mangtruyen.size()>0){
                    timkiemAdapter = new TimkiemAdapter(getActivity(),mangtruyen);
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                    recyclerView.setLayoutManager(linearLayoutManager);
                    recyclerView.setAdapter(timkiemAdapter);
                    txtkhongcodulieu.setVisibility(View.GONE);
                    recyclerView.setVisibility(View.VISIBLE);

                }else{
                    recyclerView.setVisibility(View.GONE);
                    txtkhongcodulieu.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onFailure(Call<List<Truyen>> call, Throwable t) {

            }
        });
    }
}
