package com.example.appaudiobook.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appaudiobook.Activity.PlayAudioActivity;
import com.example.appaudiobook.Adapter.PlayAudioAdapter;
import com.example.appaudiobook.R;

@SuppressWarnings("deprecation")
public class Fragment_Play_Danh_Sach_Tacpham extends Fragment {
    RecyclerView recyclerViewplayaudio;
    View view;
    PlayAudioAdapter playAudioAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_play_danh_sach_tacpham,container,false);
        recyclerViewplayaudio=view.findViewById(R.id.recyclerviewplayaudio);

        if (PlayAudioActivity.mangtruyen.size()>0){
            playAudioAdapter=new PlayAudioAdapter(getActivity(),PlayAudioActivity.mangtruyen);
            recyclerViewplayaudio.setLayoutManager(new LinearLayoutManager(getActivity()));
            recyclerViewplayaudio.setAdapter(playAudioAdapter);

        }

        return view;
    }
}
