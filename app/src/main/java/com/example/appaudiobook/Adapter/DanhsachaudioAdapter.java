package com.example.appaudiobook.Adapter;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appaudiobook.Activity.PlayAudioActivity;
import com.example.appaudiobook.Model.Truyen;
import com.example.appaudiobook.R;


import java.util.ArrayList;

public  class DanhsachaudioAdapter extends RecyclerView.Adapter<DanhsachaudioAdapter.ViewHolder>{
    Context context;
    ArrayList<Truyen> truyenArrayList;
    public DanhsachaudioAdapter(Context context, ArrayList<Truyen> truyenArrayList) {
        this.context = context;
        this.truyenArrayList = truyenArrayList;
    }





    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.dong_danhsach_truyen,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Truyen truyen=truyenArrayList.get(position);
        holder.txttacgia.setText(truyen.getTacgia());
        holder.txttentruyen.setText(truyen.getTentruyen());
        holder.txtdiendoc.setText(truyen.getDiendoc());
        holder.txtindex.setText(position +1+"");

    }

    @Override
    public int getItemCount() {
        return truyenArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtindex,txttentruyen,txttacgia,txtdiendoc;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txttacgia=itemView.findViewById(R.id.textviewtentacgia);
            txttentruyen=itemView.findViewById(R.id.textviewtentruyen);
            txtindex=itemView.findViewById(R.id.textviewdanhsachindex);
            txtdiendoc= itemView.findViewById(R.id.diendoc);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(context, PlayAudioActivity.class);
                    intent.putExtra("audio",truyenArrayList.get(getPosition()));
                    context.startActivity(intent);
                }
            });
        }
    }
}
