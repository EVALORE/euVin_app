package com.example.euvin;

import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {
    TextView name;
    TextView location;
    TextView date;
    TextView time;
    ImageView img;
    ImageButton heartButton;
    private final OnHeartClickListener listener;

    public MyViewHolder(@NonNull View itemView, OnHeartClickListener listener) {
        super(itemView);
        this.listener = listener;

        name = itemView.findViewById(R.id.title);
        location = itemView.findViewById(R.id.location);
        date = itemView.findViewById(R.id.date);
        time = itemView.findViewById(R.id.time);
        img = itemView.findViewById(R.id.Img);
        heartButton = itemView.findViewById(R.id.HeartButton);
    }

    public void bind(final Events event, OnItemClickListener itemClickListener) {
        name.setText(event.getName());
        location.setText(event.getLocation());
        date.setText(event.getDate());
        time.setText(event.getTime());
        img.setImageResource(event.getImg());
        heartButton.setImageResource(event.isLiked() ? R.drawable.like_heart_activ : R.drawable.like_heart_inactiv);

        itemView.setOnClickListener(v -> itemClickListener.onItemClick(event));

        heartButton.setOnClickListener(v -> {
            event.toggleLike();
            heartButton.setImageResource(event.isLiked() ? R.drawable.like_heart_activ : R.drawable.like_heart_inactiv);
            if (listener != null) {
                listener.onHeartClicked(event);
            }
        });
    }
}
