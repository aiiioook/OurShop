package com.example.noclip.appnavshop;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.Arrays;


/**
 * A simple {@link Fragment} subclass.
 */
public class FavoriteFragment extends Fragment {
    private ListView listView;
    public  ArrayAdapter<String> adapter;


    public FavoriteFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_favorite, container, false);
        listView = view.findViewById(R.id.list_view_in_favorites);
        ArrayList<String> array_food = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.favorites)));
        adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1,
                array_food
        );
        listView.setAdapter(adapter);
        return view;
    }


}
