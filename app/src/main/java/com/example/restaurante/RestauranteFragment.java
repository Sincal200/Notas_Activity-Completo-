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
    List<NotasActivity> notasActivityList;

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
            notasActivityList = new ArrayList<>();
            notasActivityList.add(new NotasActivity("Recordatorio","",1.0f,"Recoger la ropa en la lavandería"));
            notasActivityList.add(new NotasActivity("Lista de Compras","0",0.0f,"Pan,Huevos,Leche"));
            notasActivityList.add(new NotasActivity("Recordatorio","",1f,"Cumpleaños de Mejor amigo"));
            notasActivityList.add(new NotasActivity("Recordatorio","",1f,"Regocer pantalones"));





            //Asociamos el apapdator el recyclerView
            adapterRestaurantes = new MyRestauranteRecyclerViewAdapter(getActivity(), notasActivityList);
            recyclerView.setAdapter(adapterRestaurantes);
        }
        return view;
    }
}