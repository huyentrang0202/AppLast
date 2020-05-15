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

import com.example.appaudiobook.Activity.DanhsachAudioActivity;
import com.example.appaudiobook.Model.Truyenhot;
import com.example.appaudiobook.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class DanhsachalltruyenhotAdapter extends RecyclerView.Adapter<DanhsachalltruyenhotAdapter.ViewHodel> {
    Context context;
    ArrayList<Truyenhot> mangtruyenhot;

    public DanhsachalltruyenhotAdapter(Context context, ArrayList<Truyenhot> mangtruyenhot) {
        this.context = context;
        this.mangtruyenhot = mangtruyenhot;
    }

    @NonNull
    @Override
    public ViewHodel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater =LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.danh_sach_all_truyenhot_adapter,parent,false);

        return new ViewHodel(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHodel holder, int position) {
        Truyenhot truyenhot = mangtruyenhot.get(position);
        Picasso.with(context).load(truyenhot.getHinhnen()).into(holder.imghinhnen);
        holder.txttentruyenhot.setText(truyenhot.getTentruyen());


    }

    @Override
    public int getItemCount() {
        return mangtruyenhot.size();
    }

    public class ViewHodel extends RecyclerView.ViewHolder{
        ImageView imghinhnen;
        TextView txttentruyenhot,txttacgia,txtdiendoc;
        public ViewHodel(@NonNull View itemView) {
            super(itemView);
            imghinhnen = itemView.findViewById(R.id.imageviewdanhsachcactruyenhot);
            txttentruyenhot= itemView.findViewById(R.id.textviewdanhsachcactruyenhot);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, DanhsachAudioActivity.class);
                    intent.putExtra("itemptruyenhot",mangtruyenhot.get(getPosition()));
                    context.startActivity(intent);
                }
            });
        }
    }
}
