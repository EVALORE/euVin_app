package com.example.euvin;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ItemDetailsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_details);

        String name = getIntent().getStringExtra("name");
        String location = getIntent().getStringExtra("location");
        String date = getIntent().getStringExtra("date");
        String time = getIntent().getStringExtra("time");
        String categories = getIntent().getStringExtra("categories");
        String description = getIntent().getStringExtra("description");
        int img = getIntent().getIntExtra("img", 0);

        TextView nameTextView = findViewById(R.id.textDetailsName);
        nameTextView.setText(name);

        TextView locationTextView = findViewById(R.id.textDetailsLocation);
        locationTextView.setText(location);

        TextView dateTextView = findViewById(R.id.textDetailsDate);
        dateTextView.setText(date);

        TextView timeTextView = findViewById(R.id.textDetailsTime);
        timeTextView.setText(time);

        TextView categoriesTextView = findViewById(R.id.textDetailsCategories);
        categoriesTextView.setText(categories);

        TextView descriptionTextView = findViewById(R.id.textDetailsDescriere);
        descriptionTextView.setText(description);

        ImageView imageView = findViewById(R.id.my_image_view);
        imageView.setImageResource(img);

        ImageButton imageButtonBack = findViewById(R.id.imageButtonBack);
        imageButtonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
