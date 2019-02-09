package com.example.noclip.appnavshop.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import com.example.noclip.appnavshop.R;
import com.example.noclip.appnavshop.model.Product;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostViewHolder> {
    private static final String TAG = "RecycleViewAdapter";

    private Context context;
    private List<Product> postList;

    public PostAdapter(Context context, List<Product> postList) {
        this.context = context;
        this.postList = postList;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.post_layout, parent, false);

        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: called");

        holder.getTxtTitle().setText(postList.get(position).getName());

//        selectionItem(holder, position);
    }

//    private void selectionItem(@NonNull PostViewHolder holder, int position) {
//        holder.getParentLayout().setOnClickListener(view -> {
//            Log.d(TAG, "onClick: clicked on: " + postList.get(position));
//
//            Toast.makeText(context, postList.get(position).getName(), Toast.LENGTH_SHORT).show();

//            Intent intent = new Intent(context, AboutPlace.class);
//            intent.putExtra("image_url", postList.get(position).getUrlLocation());

//            context.startActivity(intent);
//        });
//    }

    @Override
    public int getItemCount() {
        return postList.size();
    }
}