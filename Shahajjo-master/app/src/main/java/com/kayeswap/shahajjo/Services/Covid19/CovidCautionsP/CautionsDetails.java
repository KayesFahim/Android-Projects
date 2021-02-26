package com.kayeswap.shahajjo.Services.Covid19.CovidCautionsP;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.kayeswap.shahajjo.R;


public class CautionsDetails extends AppCompatActivity {

    TextView textTitle, textBlog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cautions_details);

        Intent i = getIntent();
        String title = i.getStringExtra("title");
        String blog = i.getStringExtra("blog");
        textTitle = findViewById(R.id.titleview);
        textTitle.setText(title);

        textBlog = findViewById(R.id.blogview);
        textBlog.setText(blog);




    }
}