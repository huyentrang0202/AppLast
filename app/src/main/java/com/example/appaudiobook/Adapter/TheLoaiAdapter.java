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
import com.example.appaudiobook.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class TheLoaiAdapter  extends RecyclerView.Adapter<TheLoaiAdapter.ViewHoder> {
    Context context;
    ArrayList<TheLoai> mangtheloai;

    public TheLoaiAdapter(Context context, ArrayList<TheLoai> mangtheloai) {
        this.context = context;
        this.mangtheloai = mangtheloai;
    }

    @NonNull
    @Override
    public ViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_theloai,parent,false);
        return new ViewHoder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHoder holder, int position) {
        TheLoai theLoai = mangtheloai.get(position);
        holder.txttentheloai.setText(theLoai.getTentheloai());
        Picasso.with(context).load(theLoai.getHinhtheloai()).into(holder.imghinhtheloai);

    }

    @Override
    public int getItemCount() {
        return mangtheloai.size();
    }

    public class ViewHoder extends RecyclerView.ViewHolder {
       ImageView imghinhtheloai;
       TextView txttentheloai;

       public ViewHoder(@NonNull View itemView) {
           super(itemView);
           imghinhtheloai = itemView.findViewById(R.id.imageviewtheloai);
           txttentheloai = itemView.findViewById(R.id.textviewtentheloai);
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
