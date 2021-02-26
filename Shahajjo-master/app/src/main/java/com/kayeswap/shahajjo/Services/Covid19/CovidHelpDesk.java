package com.kayeswap.shahajjo.Services.Covid19;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.kayeswap.shahajjo.R;
import com.kayeswap.shahajjo.Services.Covid19.CoronaHelpDesk.CovidTestHelpLine;
import com.kayeswap.shahajjo.Services.Covid19.CoronaHelpDesk.HotlineActivity;
import com.kayeswap.shahajjo.Services.HealthComplexActivity;
import com.kayeswap.shahajjo.Services.Hospital.Hospital;

public class CovidHelpDesk extends AppCompatActivity {

    Button covidtest, covidhospital, helathcomplex, covidallhotline;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_covid_help_desk);
        covidtest = findViewById(R.id.covidtestbtn);
        covidhospital = findViewById(R.id.hospitallist);
        helathcomplex = findViewById(R.id.healthcomplex);
        covidallhotline = findViewById(R.id.hotline);



        covidtest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(CovidHelpDesk.this, CovidTestHelpLine.class));


            }
        });





        helathcomplex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(CovidHelpDesk.this, HealthComplexActivity.class));


            }
        });

        covidhospital.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(CovidHelpDesk.this, Hospital.class));


            }
        });

        covidallhotline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(CovidHelpDesk.this, HotlineActivity.class));


            }
        });

    }
}
