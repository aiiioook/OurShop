package com.example.noclip.appnavshop;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    private ListView listView;
    public ArrayAdapter<String> adapter;


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_home, container, false);
        listView = view.findViewById(R.id.home_list);
        ArrayList<String>arrayHome = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.home_list)));
        adapter = new ArrayAdapter<String> (getActivity(),android.R.layout.simple_list_item_1,arrayHome);
        listView.setAdapter(adapter);
        return view;
    }

}
