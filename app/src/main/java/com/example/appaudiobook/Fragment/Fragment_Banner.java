package com.example.appaudiobook.Fragment;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.appaudiobook.Adapter.BannerAdapter;
import com.example.appaudiobook.Model.Goiy;
import com.example.appaudiobook.R;
import com.example.appaudiobook.Service.APIService;
import com.example.appaudiobook.Service.Dataservice;
import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_Banner extends Fragment {

    View view;
    ViewPager viewPager;
    CircleIndicator circleIndicator;
    BannerAdapter bannerAdapter;
    Runnable runnable;
    Handler handler;
    int currentItem;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_banner, container, false);
        GetData();
        anhxa();
        return view;


    }

    private void anhxa() {
        viewPager = view.findViewById(R.id.viewpager);
        circleIndicator = view.findViewById(R.id.indicatordefaul);
    }

    private void GetData() {
        Dataservice dataservice = APIService.getService();
       Call<List<Goiy>> callback = dataservice.GetDataBanner();
        callback.enqueue(new Callback<List<Goiy>>() {
            @Override
            public void onResponse(Call<List<Goiy>> call, Response<List<Goiy>> response) {
                ArrayList<Goiy> banners = (ArrayList<Goiy>) response.body();
                bannerAdapter=new BannerAdapter(getActivity(),banners);
                viewPager.setAdapter(bannerAdapter);
                circleIndicator.setViewPager(viewPager);
                handler=new Handler();
                runnable=new Runnable() {
                    @Override
                    public void run() {
                        currentItem=viewPager.getCurrentItem();
                        currentItem++;
                        if(currentItem>=viewPager.getAdapter().getCount()){
                            currentItem=0;
                        }
                        viewPager.setCurrentItem(currentItem,true);
                        handler.postDelayed(runnable,4500);

                    }
                };
                handler.postDelayed(runnable,4500);

            }

            @Override
            public void onFailure(Call<List<Goiy>> call, Throwable t) {

            }
        });



    }
}

