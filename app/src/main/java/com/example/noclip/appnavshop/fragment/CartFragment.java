package com.example.noclip.appnavshop.fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.example.noclip.appnavshop.R;
import com.example.noclip.appnavshop.adapter.PostAdapter;
import com.example.noclip.appnavshop.model.Product;

import java.util.ArrayList;
import java.util.List;

public class CartFragment extends Fragment {

    public ArrayAdapter<String> adapter;
    private RecyclerView recyclerView;

    public CartFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cart, container, false);

        //View
        recyclerView = view.findViewById(R.id.recycler_posts);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


        displayData(new ArrayList<Product>() {{
            add(new Product(0L, "First"));
            add(new Product(1L, "Second"));
            add(new Product(2L, "Third"));
            add(new Product(3L, "Fourth"));
        }});

        return view;
    }

    private void displayData(List<Product> placeWithCategories) {
        PostAdapter adapter = new PostAdapter(getActivity(), placeWithCategories);
        recyclerView.setAdapter(adapter);
    }
}
