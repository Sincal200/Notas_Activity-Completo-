package com.example.restaurante;

import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.example.restaurante.databinding.FragmentItemBinding;

import java.util.List;


public class MyRestauranteRecyclerViewAdapter extends RecyclerView.Adapter<MyRestauranteRecyclerViewAdapter.ViewHolder> {

    private Context ctx;
    private final List<NotasActivity> mValues;

    public MyRestauranteRecyclerViewAdapter(Context context, List <NotasActivity> items) {
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



    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView mIdView = null;
        public final TextView textViewNombreRestaurante;
        public final TextView textViewDireccionRestaurante;

        public final RatingBar ratingBarValoracionRestaurante;
        public NotasActivity mItem;

        public ViewHolder(FragmentItemBinding binding) {
            super(binding.getRoot());
            textViewNombreRestaurante = binding.textViewNombre;
            textViewDireccionRestaurante = binding.textViewDireccion;

            ratingBarValoracionRestaurante = binding.ratingBarValoracion;

        }

        @Override
        public String toString() {
            return super.toString() + " '" + textViewNombreRestaurante.getText() + "'";
        }
    }
}