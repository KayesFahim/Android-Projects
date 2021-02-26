package com.kayeswap.shahajjo.Services;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.kayeswap.shahajjo.R;

import com.kayeswap.shahajjo.Services.Covid19.CovidCautions;
import com.kayeswap.shahajjo.Services.Covid19.CovidHelpDesk;
import com.kayeswap.shahajjo.Services.Covid19.CovidNews;
import com.kayeswap.shahajjo.Services.Covid19.CovidPracticable;
import com.kayeswap.shahajjo.Services.Covid19.CovidSymptoms;
import com.kayeswap.shahajjo.Services.Covid19.CovidTest;
import com.kayeswap.shahajjo.Services.Covid19.CovidTracker.Covid19Tracker;
import com.kayeswap.shahajjo.Services.Covid19.PlasmaDonationActivity;


public class Covid19Activity extends AppCompatActivity {
    Button tracker,symptoms,test,practicable,plasma, cautions,news, helpdesk;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_covid19);
        tracker = findViewById(R.id.tracker);
        symptoms = findViewById(R.id.symptoms);
        test = findViewById(R.id.test);
        practicable = findViewById(R.id.precticable);
        plasma = findViewById(R.id.plasma);
        cautions = findViewById(R.id.cautious);
        news = findViewById(R.id.news);
        helpdesk = findViewById(R.id.help);




        tracker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Covid19Activity.this, Covid19Tracker.class));
            }


        });
        symptoms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Covid19Activity.this, CovidSymptoms.class));
            }


        });
        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Covid19Activity.this, CovidTest.class));
            }


        });
        practicable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Covid19Activity.this, CovidPracticable.class));
            }


        });
        plasma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Covid19Activity.this, PlasmaDonationActivity.class));
            }


        });

        cautions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Covid19Activity.this, CovidCautions.class));
            }


        });
        news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Covid19Activity.this, CovidNews.class));
            }


        });
        helpdesk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Covid19Activity.this, CovidHelpDesk.class));
            }


        });






    }
}
