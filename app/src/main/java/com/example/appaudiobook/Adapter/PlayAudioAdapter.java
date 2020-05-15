package com.example.appaudiobook.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appaudiobook.Model.Truyen;
import com.example.appaudiobook.R;

import java.util.ArrayList;

@SuppressWarnings("ALL")
public class PlayAudioAdapter extends RecyclerView.Adapter<PlayAudioAdapter.ViewHolder>{
    Context context;
    ArrayList<Truyen> mangtruyen;

    public PlayAudioAdapter(Context context, ArrayList<Truyen> mangtruyen) {
        this.context = context;
        this.mangtruyen = mangtruyen;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.dong_play_audio,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Truyen truyen=mangtruyen.get(position);

        holder.txtindex.setText(position+1+"");
        holder.txttacgia.setText(truyen.getTacgia());
        holder.txtentruyen.setText(truyen.getTentruyen());

    }

    @Override
    public int getItemCount() {
        return mangtruyen.size();
    }

    @SuppressWarnings("deprecation")
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txttacgia,txtentruyen,txtindex;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txttacgia=itemView.findViewById(R.id.textviewplayaudiotentacgia);
            txtindex=itemView.findViewById(R.id.texviewplayaudioindex);
            txtentruyen=itemView.findViewById(R.id.textviewplayaudiotentacpham);
        }
    }
}