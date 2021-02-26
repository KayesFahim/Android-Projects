package com.kayeswap.shahajjo.Services.Covid19;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import com.kayeswap.shahajjo.R;
import com.kayeswap.shahajjo.Services.Covid19.PlasmaDonation.AboutPlasma;
import com.kayeswap.shahajjo.Services.Covid19.PlasmaDonation.BePlasmaDonor;
import com.kayeswap.shahajjo.Services.Covid19.PlasmaDonation.PlasmaDonorList;
import com.kayeswap.shahajjo.Services.Covid19.PlasmaDonation.RequestPlasma;

public class PlasmaDonationActivity extends AppCompatActivity {

    Button plasmabtn, plasmadonor, plasmalist, plasmareq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plasma_donation);

        plasmabtn = findViewById(R.id.plasmabtn);
        plasmadonor = findViewById(R.id.pdonorbtn);
        plasmalist = findViewById(R.id.plist);
        plasmareq = findViewById(R.id.plasmareq);


        plasmabtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(PlasmaDonationActivity.this, AboutPlasma.class));

            }
        });

        plasmadonor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(PlasmaDonationActivity.this, BePlasmaDonor.class));


            }
        });

        plasmalist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(PlasmaDonationActivity.this, PlasmaDonorList.class));


            }
        });
        plasmareq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(PlasmaDonationActivity.this, RequestPlasma.class));


            }
        });

    }
}

