package com.ascafi.ProjetoTesteStefanini.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ascafi.ProjetoTesteStefanini.R;
import com.ascafi.ProjetoTesteStefanini.model.ImageItemCat;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ModelViewHolder> {

    private ArrayList<ImageItemCat> listImageCat;
    private OnItemClickListener onItemClickListener;
    private Context context;

    public RecyclerViewAdapter(ArrayList<ImageItemCat> list) {
        listImageCat = list;
    }


    @NonNull
    @Override
    public ModelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_cat_list, parent, false);
        ModelViewHolder modelViewHolder = new ModelViewHolder(v, onItemClickListener);
        context = parent.getContext();
        return modelViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ModelViewHolder holder, int position) {
        ImageItemCat currentItem  = listImageCat.get(position);
        if (currentItem.getType().contains("image")) {
            loadPhoto(currentItem.getLink(), holder.mImageView);
        }
    }

    private void loadPhoto(String url, ImageView imageView) {
        Picasso.with(context).load(url).resize(300, 200).into(imageView);
    }

    @Override
    public int getItemCount() {
        return listImageCat.size();
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public static class ModelViewHolder extends RecyclerView.ViewHolder {
        private ImageView mImageView;

        private ModelViewHolder(View itemView, final OnItemClickListener listener) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.catImageView);
        }
    }
}
