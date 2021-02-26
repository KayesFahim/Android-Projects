package com.kayeswap.shahajjo.Services.BloodBank;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.kayeswap.shahajjo.Services.BloodBank.BloodGroups.AB_Negative;
import com.kayeswap.shahajjo.Services.BloodBank.BloodGroups.AB_Positive;
import com.kayeswap.shahajjo.Services.BloodBank.BloodGroups.A_Negative;
import com.kayeswap.shahajjo.Services.BloodBank.BloodGroups.A_Positive;
import com.kayeswap.shahajjo.Services.BloodBank.BloodGroups.B_Negative;
import com.kayeswap.shahajjo.Services.BloodBank.BloodGroups.B_Positive;
import com.kayeswap.shahajjo.Services.BloodBank.BloodGroups.O_Negative;
import com.kayeswap.shahajjo.Services.BloodBank.BloodGroups.O_Positive;
import com.kayeswap.shahajjo.R;

public class Blood_Group extends AppCompatActivity {
    Button up, ap, an, abp, abn, bp,bn,op,on;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blood__group);

        up = findViewById(R.id.newblood);
        ap = findViewById(R.id.ap);
        an = findViewById(R.id.an);
        abp = findViewById(R.id.abp);
        abn = findViewById(R.id.abn);
        bp = findViewById(R.id.bp);
        bn = findViewById(R.id.bn);
        op = findViewById(R.id.op);
        on = findViewById(R.id.on);



        up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    startActivity(new Intent(Blood_Group.this, Donor_Registration.class));


            }
        });


        ap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    startActivity(new Intent(Blood_Group.this, A_Positive.class));



            }
        });

        an.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                startActivity(new Intent(Blood_Group.this, A_Negative.class));

            }
        });

        abp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                    startActivity(new Intent(Blood_Group.this, AB_Positive.class));

                }

        });
        abn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    startActivity(new Intent(Blood_Group.this, AB_Negative.class));

                }


        });

        bp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    startActivity(new Intent(Blood_Group.this, B_Positive.class));

                }

        });

        bn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    startActivity(new Intent(Blood_Group.this, B_Negative.class));
                }

        });
        op.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    startActivity(new Intent(Blood_Group.this, O_Positive.class));

                }

        });
        on.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Blood_Group.this, O_Negative.class));

            }
        });

    }
}
