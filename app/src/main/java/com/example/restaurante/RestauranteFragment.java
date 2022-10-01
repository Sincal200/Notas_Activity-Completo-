package com.example.restaurante;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * A fragment representing a list of Items.
 */
public class RestauranteFragment extends Fragment {

    RecyclerView recyclerView;
    MyRestauranteRecyclerViewAdapter adapterRestaurantes;
    List<Restaurante> restauranteList;

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public RestauranteFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static RestauranteFragment newInstance(int columnCount) {
        RestauranteFragment fragment = new RestauranteFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }

            //Lista de elementos (Restaurantes)
            restauranteList = new ArrayList<>();
            restauranteList.add(new Restaurante("Pizzeria Carlos","https://th.bing.com/th/id/R.ad93a6a7158d0a67c8e874a946b16faf?rik=lBaReMFlvQa6dg&pid=ImgRaw&r=0",4.0f,"Madrid, España"));
            restauranteList.add(new Restaurante("Hamburgueseria rápida","https://th.bing.com/th/id/R.600596d992025c657fdc67d8e9af6661?rik=YI%2bC%2fo98p%2ftCyQ&pid=ImgRaw&r=0",3.0f,"Mexico"));
            restauranteList.add(new Restaurante("Venta de Mariscos","https://d1ralsognjng37.cloudfront.net/5bdc8613-9273-4f40-addc-418ada8a8cc5.jpeg",1f,"Guatemala"));
            restauranteList.add(new Restaurante("Restaurante Pedro","https://fullhdpictures.com/wp-content/uploads/2016/11/Restaurant-Photos-HD.jpg",2f,"Honduras"));





            //Asociamos el apapdator el recyclerView
            adapterRestaurantes = new MyRestauranteRecyclerViewAdapter(getActivity(), restauranteList);
            recyclerView.setAdapter(adapterRestaurantes);
        }
        return view;
    }
}