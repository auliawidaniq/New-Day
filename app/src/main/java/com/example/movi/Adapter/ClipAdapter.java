package com.example.movi.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.movi.Models.Clip;
import com.example.movi.R;

import java.util.List;

public class ClipAdapter extends RecyclerView.Adapter<ClipAdapter.ClipViewHolder> {

Context mContext;
List<Clip> mData;

    @NonNull
    @Override
    public ClipViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_clip,viewGroup, false);
        return new ClipViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ClipViewHolder clipViewHolder, int i) {

        Glide.with(mContext).load(mData.get(i).getLink()).into(clipViewHolder.img);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public ClipAdapter(Context mContext, List<Clip> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    public class ClipViewHolder extends RecyclerView.ViewHolder{

        ImageView img;

        public ClipViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img_clip);

        }
    }
}
