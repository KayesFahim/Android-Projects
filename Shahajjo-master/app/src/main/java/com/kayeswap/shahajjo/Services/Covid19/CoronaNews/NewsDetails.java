package com.kayeswap.shahajjo.Services.Covid19.CoronaNews;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.kayeswap.shahajjo.R;


public class NewsDetails extends AppCompatActivity {

    TextView textTitle, textBlog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_details);

        Intent i = getIntent();
        String title = i.getStringExtra("title");
        String blog = i.getStringExtra("blog");
        textTitle = findViewById(R.id.titleview);
        textTitle.setText(title);

        textBlog = findViewById(R.id.blogview);
        textBlog.setText(blog);




    }
}