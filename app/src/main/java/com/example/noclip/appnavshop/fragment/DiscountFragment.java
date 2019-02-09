package com.example.noclip.appnavshop.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.Arrays;


public class DiscountFragment extends Fragment {
private  SearchView searchView;
private  ListView listView;
public  ArrayAdapter<String> adapter;

    public DiscountFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_discount, container, false);
        listView = view.findViewById(R.id.search_food_in_dis_fragment);
        ArrayList<String>array_food = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.my_foods)));
        adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1,
                array_food
        );
        listView.setAdapter(adapter);
        return view;
            }

}


