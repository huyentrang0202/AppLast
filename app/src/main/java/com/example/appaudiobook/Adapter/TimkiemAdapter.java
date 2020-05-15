package com.example.appaudiobook.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appaudiobook.Activity.PlayAudioActivity;
import com.example.appaudiobook.Model.Truyen;
import com.example.appaudiobook.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import static java.security.AccessController.getContext;

public class TimkiemAdapter  extends RecyclerView.Adapter<TimkiemAdapter.ViewHolder> {
    Context context;

    public TimkiemAdapter(Context context, ArrayList<Truyen> mangtruyen) {
        this.context = context;
        this.mangtruyen = mangtruyen;
    }

    ArrayList<Truyen> mangtruyen;
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.dong_timkiem,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Truyen truyen = mangtruyen.get(position);
        holder.txttentp.setText(truyen.getTentruyen());
        holder.txttacgia.setText(truyen.getTacgia());
        holder.txtdiendoc.setText(truyen.getDiendoc());
        Picasso.with(context).load(truyen.getHinhtruyen()).into(holder.imgtruyen);

    }

    @Override
    public int getItemCount() {
        return mangtruyen.size();
    }

    public  class  ViewHolder extends  RecyclerView.ViewHolder{
        TextView txttentp,txttacgia,txtdiendoc;
        ImageView imgtruyen;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txttentp = itemView.findViewById(R.id.txttentp);
            txttacgia =itemView.findViewById(R.id.txttacgia);
            txtdiendoc = itemView.findViewById(R.id.txtdiendoc);
            imgtruyen = itemView.findViewById(R.id.imgtp);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, PlayAudioActivity.class);
                    intent.putExtra("audio",mangtruyen.get(getAdapterPosition()));
                    context.startActivity(intent);
                }
            });
        }
    }
}
