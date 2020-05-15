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

import com.example.appaudiobook.Activity.DanhsachAlltamsuActivity;
import com.example.appaudiobook.Activity.DanhsachAudioActivity;
import com.example.appaudiobook.Model.Tamsu;
import com.example.appaudiobook.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class DanhsachalltamsuAdapter  extends  RecyclerView.Adapter<DanhsachalltamsuAdapter.ViewHoder> {

    Context context;

    public DanhsachalltamsuAdapter(Context context, ArrayList<Tamsu> tamsuArrayList) {
        this.context = context;
        this.tamsuArrayList = tamsuArrayList;
    }

    ArrayList<Tamsu> tamsuArrayList;
    @NonNull
    @Override
    public ViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.danh_sach_all_tamsu_adapter,parent,false);
        return new ViewHoder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHoder holder, int position) {
        Tamsu tamsu = tamsuArrayList.get(position);
        Picasso.with(context).load(tamsu.getHinhanh()).into(holder.imgalltamsu);
        holder.txttentieude.setText(tamsu.getTentieude());
    }

    @Override
    public int getItemCount() {
        return tamsuArrayList.size();
    }

    public  class  ViewHoder extends RecyclerView.ViewHolder{
        ImageView imgalltamsu;
        TextView txttentieude;

        public ViewHoder(@NonNull View itemView) {
            super(itemView);
            imgalltamsu = itemView.findViewById(R.id.imageviewalltamsu);
            txttentieude = itemView.findViewById(R.id.textviewtentieudealltamsu);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, DanhsachAudioActivity.class);
                    intent.putExtra("tamsu",tamsuArrayList.get(getPosition()));
                    context.startActivity(intent);
                }
            });


        }
    }
}
