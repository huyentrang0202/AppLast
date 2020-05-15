package com.example.appaudiobook.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.appaudiobook.Model.Truyenhot;
import com.example.appaudiobook.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class TruyenhotAdapter extends ArrayAdapter<Truyenhot> {


    public TruyenhotAdapter(@NonNull Context context, int resource, @NonNull List<Truyenhot> objects) {

        super(context, resource, objects);
    }

    class  ViewHodel{
        TextView txttentruyenhot;
        ImageView imgbackgroud,imgtruyenhot;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
       ViewHodel viewHodel = null;
       if (convertView == null){
           LayoutInflater inflater = LayoutInflater.from(getContext());
           convertView = inflater.inflate(R.layout.dong_truyenhot,null);
           viewHodel = new ViewHodel();
           viewHodel.txttentruyenhot = convertView.findViewById(R.id.textviewtentruyenhot);
           viewHodel.imgtruyenhot = convertView.findViewById(R.id.imageviewtruyenhot);
           viewHodel.imgbackgroud = convertView.findViewById(R.id.imageviewbackgroundtruyenhot);
           convertView.setTag(viewHodel);

       }else{
           viewHodel = (ViewHodel) convertView.getTag();
       }
       Truyenhot truyenhot = getItem(position);
        Picasso.with(getContext()).load(truyenhot.getHinhnen()).into(viewHodel.imgbackgroud);
        Picasso.with(getContext()).load(truyenhot.getHinhicon()).into(viewHodel.imgtruyenhot);
        viewHodel.txttentruyenhot.setText(truyenhot.getTentruyen());
        return convertView;
    }
}
