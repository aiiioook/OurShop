package com.example.noclip.appnavshop;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;



public class ProfileFragment extends Fragment {

    private String profile_login = "[login]";
    private View mRootView;
    public ProfileFragment() {

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.setGroupVisible(R.id.item_group,false);
//        ((MainActivity)getActivity()).setActionBarTitle(profile_login + "'s account" );
        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();

        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        setHasOptionsMenu(true);


        return inflater.inflate(R.layout.fragment_profile, container, false);
    }



}


