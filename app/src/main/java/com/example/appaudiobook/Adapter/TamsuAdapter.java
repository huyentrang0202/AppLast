package com.example.appaudiobook.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appaudiobook.Activity.DanhsachAudioActivity;
import com.example.appaudiobook.Model.Tamsu;
import com.example.appaudiobook.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class TamsuAdapter  extends RecyclerView.Adapter<TamsuAdapter.ViewHoder> {
        Context context;
        ArrayList<Tamsu> tamsuArrayList;

    public TamsuAdapter(Context context, ArrayList<Tamsu> tamsuArrayList) {
        this.context = context;
        this.tamsuArrayList = tamsuArrayList;
    }

    @NonNull
    @Override
    public ViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater =LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_tamsu,parent,false);
        return new ViewHoder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHoder holder, int position) {
        Tamsu tamsu = tamsuArrayList.get(position);
        holder.txttentamsu.setText(tamsu.getTentieude());
        Picasso.with(context).load(tamsu.getHinhanh()).into(holder.imghinhtamsu);


    }

    @Override
    public int getItemCount() {
        return tamsuArrayList.size();
    }

    public  class  ViewHoder extends RecyclerView.ViewHolder{
        ImageView imghinhtamsu;
        TextView txttentamsu;

       public ViewHoder(@NonNull View itemView) {
           super(itemView);
           imghinhtamsu = itemView.findViewById(R.id.imageviewtamsu);
           txttentamsu= itemView.findViewById(R.id.textviewtamsu);
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

