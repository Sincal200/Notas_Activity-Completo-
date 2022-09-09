package com.example.restaurante;

import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.media.Rating;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.example.restaurante.databinding.FragmentItemBinding;

import java.util.List;


public class MyRestauranteRecyclerViewAdapter extends RecyclerView.Adapter<MyRestauranteRecyclerViewAdapter.ViewHolder> {

    private Context ctx;
    private final List<Restaurante> mValues;

    public MyRestauranteRecyclerViewAdapter(Context context, List <Restaurante> items) {
        ctx = context;
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder(FragmentItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        //Recolectamos los datos del elemento que ocupa la posición "position"
        holder.mItem = mValues.get(position);

        holder.textViewNombreRestaurante.setText(holder.mItem.getNombre());
        holder.textViewDireccionRestaurante.setText(holder.mItem.getDireccion());
        holder.ratingBarValoracionRestaurante.setRating(holder.mItem.getValoracion());

        Glide.with(ctx)
                .load((holder.mItem.getUrlPhoto()))
                .centerCrop()
                .into(holder.imageViewPhotoRestaurante);


    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView mIdView = null;
        public final TextView textViewNombreRestaurante;
        public final TextView textViewDireccionRestaurante;
        public final ImageView imageViewPhotoRestaurante;
        public final RatingBar ratingBarValoracionRestaurante;
        public Restaurante mItem;

        public ViewHolder(FragmentItemBinding binding) {
            super(binding.getRoot());
            textViewNombreRestaurante = binding.textViewNombre;
            textViewDireccionRestaurante = binding.textViewDireccion;
            imageViewPhotoRestaurante = binding.imageViewPhoto;
            ratingBarValoracionRestaurante = binding.ratingBarValoracion;

        }

        @Override
        public String toString() {
            return super.toString() + " '" + textViewNombreRestaurante.getText() + "'";
        }
    }
}