package com.wred.choa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.wred.choa.english.DoctorEnglish;
import com.wred.choa.english.PatientEnglish;

public class SelectMenuENG extends AppCompatActivity {
    Button doctor, patient, bng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select__menu);

        doctor = findViewById(R.id.doctor);
        patient = findViewById(R.id.patient);
        bng = findViewById(R.id.bng);

        bng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SelectMenuENG.this, SelectMenuBNG.class));
            }
        });

        doctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SelectMenuENG.this, DoctorEnglish.class));
            }
        }); doctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SelectMenuENG.this, DoctorEnglish.class));
            }
        });

        patient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SelectMenuENG.this, PatientEnglish.class));
            }
        });



    }
}