package com.example.euvin;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {
    private final OnHeartClickListener heartClickListener;
    private final OnItemClickListener itemClickListener;
    private final Context context;
    private final List<Events> items;

    public MyAdapter(Context context, List<Events> items, OnHeartClickListener heartClickListener, OnItemClickListener itemClickListener) {
        this.context = context;
        this.items = items;
        this.heartClickListener = heartClickListener;
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false);
        return new MyViewHolder(itemView, heartClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Events event = items.get(position);
        holder.bind(event, itemClickListener);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
