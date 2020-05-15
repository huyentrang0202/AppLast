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
import com.example.appaudiobook.Model.TheLoai;
import com.example.appaudiobook.Model.Truyenhot;
import com.example.appaudiobook.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class DanhsachAlltheloaiAdapter extends RecyclerView.Adapter<DanhsachAlltheloaiAdapter.ViewHodel> {
        Context context;
        ArrayList<TheLoai> mangtheloai;

    public DanhsachAlltheloaiAdapter(Context context, ArrayList<TheLoai> mangtheloai) {
        this.context = context;
        this.mangtheloai = mangtheloai;
    }

    @NonNull
    @Override
    public ViewHodel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.danh_sach_all_theloai_adapter,parent,false);


        return new ViewHodel(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHodel holder, int position) {
        TheLoai theloai = mangtheloai.get(position);
        Picasso.with(context).load(theloai.getHinhtheloai()).into(holder.imageViewalltheloai);
        holder.txtalltheloai.setText(theloai.getTentheloai());
    }

    @Override
    public int getItemCount() {
        return mangtheloai.size();
    }

    public class ViewHodel extends RecyclerView.ViewHolder{
        ImageView imageViewalltheloai;
        TextView txtalltheloai;
        public ViewHodel(@NonNull View itemView) {
            super(itemView);

            imageViewalltheloai = itemView.findViewById(R.id.imageviewalltheloai);
            txtalltheloai = itemView.findViewById(R.id.textviewtentieudealltheloai);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, DanhsachAudioActivity.class);
                    intent.putExtra("theloai",mangtheloai.get(getPosition()));
                    context.startActivity(intent);
                }
            });
        }
        }
    }

