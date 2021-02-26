package com.kayeswap.shahajjo.Services;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.facebook.ads.*;

import com.kayeswap.shahajjo.R;
import com.kayeswap.shahajjo.Services.BloodBank.Blood_Group;
import com.kayeswap.shahajjo.Services.BloodBank.Blood_Request;
import com.kayeswap.shahajjo.Services.BloodBank.Donor_Registration;

public class Blood_Bank extends AppCompatActivity {
    private final String TAG = Blood_Bank.class.getSimpleName();

    Button beadonor, buser, request;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blood__bank);
        AudienceNetworkAds.initialize(this);



            request = findViewById(R.id.request);
            beadonor = findViewById(R.id.donorbtn);
            buser = findViewById(R.id.dlist);


            beadonor.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                            startActivity(new Intent(Blood_Bank.this, Donor_Registration.class));

                }
            });

        buser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                        startActivity(new Intent(Blood_Bank.this, Blood_Group.class));


            }
        });

        request.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                        startActivity(new Intent(Blood_Bank.this, Blood_Request.class));


            }
        });

        }

}
